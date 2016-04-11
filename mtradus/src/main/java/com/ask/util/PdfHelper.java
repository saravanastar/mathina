/**
 * 
 */
package com.ask.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

/**
 * @author ASK
 * 
 */
@Service
public class PdfHelper {

	public StringBuilder buildHtml(HashMap<String, String> map,
			HttpServletRequest request,String reportName) {

		String header = map.get("Header");
		String data = map.get("data");
		Gson gson = new Gson();
		StringBuilder htmlBuilder = new StringBuilder();
		@SuppressWarnings("unchecked")
		ArrayList<ArrayList<Object>> dataArray = (ArrayList<ArrayList<Object>>) gson
				.fromJson(data, ArrayList.class);

		BufferedReader br;
		try {
			ServletContext context = request.getSession().getServletContext();
			InputStream stream = context
					.getResourceAsStream("/jsp/pdfTemplate.html");
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					stream));

			String line = reader.readLine();

			while (line != null) {
				htmlBuilder.append(line);
				// htmlBuilder.append(System.lineSeparator());
				line = reader.readLine();
			}
			String split[] = header.split(",");
			createTable(htmlBuilder);
			createRow(htmlBuilder);
			htmlBuilder.append("<td colspan='"+(split.length-2)+"'>"+reportName+"</td>");
			htmlBuilder.append("<td colspan='2'>"+new Date()+"</td>");
			endRow(htmlBuilder);
			createGradientRow(htmlBuilder);
			
			for (int i = 0; i < split.length; i++) {
				createNormalDataTag(htmlBuilder);
				htmlBuilder.append((split[i]));
				endDataTag(htmlBuilder);
			}
			endRow(htmlBuilder);
			for (int i = 0; i < dataArray.size(); i++) {
				createRow(htmlBuilder);
				ArrayList<Object> subArray = dataArray.get(i);
				for (int j = 0; j < subArray.size(); j++) {
					createBlackDataTag(htmlBuilder);
					htmlBuilder.append(String.valueOf(subArray.get(j)));
					endDataTag(htmlBuilder);
				}
				endRow(htmlBuilder);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		endTable(htmlBuilder);
		return htmlBuilder.append("</body></html>");
	}

	public void convertHTMLtoPDF(Document document, PdfWriter pdfWriter,
			StringBuilder htmlBuilder) {

		try {

			document.addAuthor("Mtradus");
			document.addCreator("StringBuilder htmlBuilder");
			document.addSubject("Mtrauds Reports");
			document.addCreationDate();
			document.addTitle("Reports");

			XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
			worker.parseXHtml(pdfWriter, document,
					new StringReader(htmlBuilder.toString()));

			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param htmlBuilder
	 */
	private void createNormalDataTag(StringBuilder htmlBuilder) {
		htmlBuilder.append("<td style='border:1px solid white'>");
	}
	/**
	 * @param htmlBuilder
	 */
	private void createBlackDataTag(StringBuilder htmlBuilder) {
		htmlBuilder.append("<td style='color:black;border:1px solid black'>");
	}

	/**
	 * @param htmlBuilder
	 */
	private void endDataTag(StringBuilder htmlBuilder) {
		htmlBuilder.append("</td>");
	}

	/**
	 * @param htmlBuilder
	 */
	private void createRow(StringBuilder htmlBuilder) {
		htmlBuilder.append("<tr>");
	}/**
	 * @param htmlBuilder
	 */
	private void createGradientRow(StringBuilder htmlBuilder) {
		htmlBuilder.append("<tr id='dataHeaders' class='gradient'>");
	}
	/**
	 * @param htmlBuilder
	 */
	private void endRow(StringBuilder htmlBuilder) {
		htmlBuilder.append("</tr>");
	}

	/**
	 * @param htmlBuilder
	 */
	private void createTable(StringBuilder htmlBuilder) {
		htmlBuilder.append("<table id='dataTable' cellspacing='0' cellpadding='5' style='margin-top:40px;'>");
	}

	/**
	 * @param htmlBuilder
	 */
	private void endTable(StringBuilder htmlBuilder) {
		htmlBuilder.append("</table>");
	}

}
