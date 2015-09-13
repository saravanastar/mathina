/**
 * 
 */
package com.ask.actions;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ask.pojo.PurchaseData;
import com.ask.service.PurchaseService;
import com.ask.util.ApplicationConstants;
import com.ask.util.CommonObjectMethods;

/**
 * @author ASK
 *
 */
@Controller
public class PurchaseController {
	
	@Autowired
	PurchaseService purchaseService;
	
	
	public PurchaseService getPurchaseService() {
		return purchaseService;
	}
	public void setPurchaseService(PurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}
	/**
	 * 
	 * @param purchaseData
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/savePurchase.htm",method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, String> savePurchase(@ModelAttribute PurchaseData purchaseData,HttpSession session){
		
		if (session.getAttribute(ApplicationConstants.LOGGED_IN) == null) {
			return CommonObjectMethods.buildOutObject(ApplicationConstants.SESSION_TIMED_OUT);
		}
		return purchaseService.savePurchaseDetails(purchaseData);
		
	}
	/**
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/purchase.htm", method = RequestMethod.GET)
	public String getPurchase(HttpSession session) {
		String page = "purchase";
		if (session.getAttribute(ApplicationConstants.LOGGED_IN) == null) {
			page = "login";
		}
		return page;

	}
	/**
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/editpurchase.htm", method = RequestMethod.GET)
	public String editPurchase(HttpSession session) {
		String page = "editpurchase";
		if (session.getAttribute(ApplicationConstants.LOGGED_IN) == null) {
			page = "login";
		}
		return page;

	}
	/**
	 * 
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/savePurchaseEditDetails.htm", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String,String> savePurchaseEditDetails(HttpSession session,HttpServletRequest request) {
		String id = request.getParameter("id");
		String billAmount = request.getParameter("billAmount");
		String quantity = request.getParameter("billQuantity");
		String discountQuantity = request.getParameter("discountQuantity");
		

		if (session.getAttribute(ApplicationConstants.LOGGED_IN) == null) {
			return CommonObjectMethods.buildOutObject(ApplicationConstants.SESSION_TIMED_OUT);
		}
		
		return purchaseService.savePurchaseEditDetails(id,billAmount,quantity,discountQuantity);

	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/removePurchaseEditDetails.htm", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String,String> removePurchaseEditDetails(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		String id = request.getParameter("id");
		String billAmount = request.getParameter("billAmount");
		String quantity = request.getParameter("billQuantity");
		

		if (session.getAttribute(ApplicationConstants.LOGGED_IN) == null) {
			return CommonObjectMethods.buildOutObject(ApplicationConstants.SESSION_TIMED_OUT);
		}
		
		return purchaseService.removeInvoiceEditDetails(id,billAmount,quantity);
		
	}
	
}
