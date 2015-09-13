/**
 * 
 */
package com.ask.actions;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ask.pojo.InvoicePojo;
import com.ask.service.BillingService;
import com.ask.util.ApplicationConstants;
import com.ask.util.CommonObjectMethods;

/**
 * @author ASK
 * 
 */
@Controller
public class BillingController {

	@Autowired
	BillingService billingService;
	
	
	
	
	public BillingService getBillingService() {
		return billingService;
	}

	public void setBillingService(BillingService billingService) {
		this.billingService = billingService;
	}
	/**
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/billing.htm", method = RequestMethod.GET)
	public String getbillingPage(HttpSession session) {
		String page = "billing";
		if (session.getAttribute(ApplicationConstants.LOGGED_IN) == null) {
			page = "login";
		}
		return page;
	}
	/**
	 * 
	 * @param pojo
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/billingSubmit.htm", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String,String> saveBillingPage(@ModelAttribute InvoicePojo pojo,HttpSession session) {
		
		if (session.getAttribute(ApplicationConstants.LOGGED_IN) == null) {
			// out.write("");
			return CommonObjectMethods.buildOutObject(ApplicationConstants.SESSION_TIMED_OUT);
		}
		return billingService.saveBillingDetails(pojo);
	}
	/**
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/billingEditSubmit.htm", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String,String> saveEditedBillingPage(HttpServletRequest request,HttpSession session) {
		
		String id = request.getParameter("id");
		String billAmount = request.getParameter("billAmount");
		String shopId = request.getParameter("shopId");
		
		if (session.getAttribute(ApplicationConstants.LOGGED_IN) == null) {
			// out.write("");
			return CommonObjectMethods.buildOutObject(ApplicationConstants.SESSION_TIMED_OUT);
		}
		return billingService.saveEditedBillingData(id, billAmount, shopId);
	}
	/**
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/removebilling.htm", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String,String> removeBillingPage(HttpServletRequest request,HttpSession session) {
		
		String id = request.getParameter("id");
		String billAmount = request.getParameter("billAmount");
		String shopId = request.getParameter("shopId");
		
		if (session.getAttribute(ApplicationConstants.LOGGED_IN) == null) {
			// out.write("");
			return CommonObjectMethods.buildOutObject(ApplicationConstants.SESSION_TIMED_OUT);
		}
		return billingService.removeBillingData(id, billAmount, shopId);
	}
	
	
}
