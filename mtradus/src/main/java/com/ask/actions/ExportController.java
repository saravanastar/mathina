/**
 * 
 */
package com.ask.actions;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ask.pojo.InvoicePojo;
import com.ask.service.ReportsService;
import com.ask.util.ExcelHelper;
import com.ask.util.PdfHelper;
import com.google.gson.Gson;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author ASK
 * 
 */
@Controller
public class ExportController {

	@Autowired
	ReportsService reportService;
	
	@Autowired
	ExcelHelper excelHelper;
	
	@Autowired
	PdfHelper pdfHelper;
	

	public PdfHelper getPdfHelper() {
		return pdfHelper;
	}

	public void setPdfHelper(PdfHelper pdfHelper) {
		this.pdfHelper = pdfHelper;
	}

	public ExcelHelper getExcelHelper() {
		return excelHelper;
	}

	public void setExcelHelper(ExcelHelper excelHelper) {
		this.excelHelper = excelHelper;
	}

	public ReportsService getReportService() {
		return reportService;
	}

	public void setReportService(ReportsService reportService) {
		this.reportService = reportService;
	}

	@RequestMapping(value = "/export.htm", method = RequestMethod.GET)
	public void exportReports(HttpServletRequest request,
			HttpServletResponse response, HttpSession session)
			throws IOException {
		InvoicePojo pojo = new InvoicePojo();
		pojo.setShopId(new String[]{request.getParameter("shopId")});
		pojo.setReportId(request.getParameter("reportId"));
		pojo.setBillNumber(new String[]{request.getParameter("billNo")});

		pojo.setVendorId(request.getParameter("company"));

		pojo.setProductId(new String[] { (String) request
				.getParameter("product") });
		pojo.setItemId(new String[] { (String) request.getParameter("item") });
		String type = request.getParameter("type");
		String reportName = request.getParameter("reportName");
		Gson gson = new Gson();
		@SuppressWarnings("unchecked")
		HashMap<String, String> map = (HashMap<String, String>) gson.fromJson(
				reportService.getReport(pojo), HashMap.class);

		if (type.equalsIgnoreCase("excel")) {
			HSSFWorkbook book = excelHelper.writeInExcel(map);
			setHeaderForXl(response, "Reports.xls");
			OutputStream out = response.getOutputStream();
			book.write(out);
		} else {

			Document document = new Document();
			setHeaderForPDF(response,"Reports");
			PdfWriter writer = null;
			try {
				 writer = PdfWriter.getInstance(document, response.getOutputStream());
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			document.open();
			pdfHelper.convertHTMLtoPDF(document,writer,pdfHelper.buildHtml(map,request,reportName));
			document.close();

		}

	}

	private void setHeaderForPDF(HttpServletResponse response, String fileName) {
		response.setContentType("application/vnd.pdf");
		response.setHeader("Expires", "0");
		response.setHeader("Pragma", "public");
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0
		response.setDateHeader("Expires", 0); // prevents caching at the proxy
		response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
		response.setHeader("Cache-Control", "max-age=0");
		response.setHeader("Content-disposition", "attachment; filename="
				+ fileName + ".pdf");
	}

	private void setHeaderForXl(HttpServletResponse response, String fileName) {
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Expires", "0");
		response.setHeader("Pragma", "public");
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0
		response.setDateHeader("Expires", 0); // prevents caching at the proxy
		response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
		response.setHeader("Cache-Control", "max-age=0");
		response.setHeader("Content-disposition", "attachment; filename="
				+ fileName);
	}
}
