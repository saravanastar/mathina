/**
 * 
 */
package com.ask.actions;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ask.pojo.InvoicePojo;
import com.ask.service.ReportsService;
import com.ask.util.ApplicationConstants;

/**
 * @author 298651
 *
 */
@Controller
public class ReportingController {

	@Autowired
	ReportsService reportService;

	
	public ReportsService getReportService() {
		return reportService;
	}


	public void setReportService(ReportsService reportService) {
		this.reportService = reportService;
	}


	@RequestMapping(value="/reports.htm",method=RequestMethod.GET)
	public String loadReportPage(HttpSession session){
		String page = "reports";
		if(session.getAttribute(ApplicationConstants.LOGGED_IN)==null){
			page = "login";
		}
		return page;
	}
	
	@RequestMapping(value="getReport.htm",method=RequestMethod.POST)
	@ResponseBody
	public String getReport(@ModelAttribute InvoicePojo pojo,HttpSession session){
		if(session.getAttribute(ApplicationConstants.LOGGED_IN)==null){
			return "";
		}
		return reportService.getReport(pojo);
		
	}
}
