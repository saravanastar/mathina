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
import com.ask.service.ShopSpecialService;
import com.ask.util.ApplicationConstants;
import com.ask.util.CommonObjectMethods;

/**
 * @author ASK
 * 
 */
@Controller
public class ShopsSpecialAction {

	@Autowired
	ShopSpecialService shopSpecialService;

	public ShopSpecialService getShopSpecialService() {
		return shopSpecialService;
	}

	public void setShopSpecialService(ShopSpecialService shopSpecialService) {
		this.shopSpecialService = shopSpecialService;
	}

	/**
	 * 
	 * @param pojo
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/saveeditedShops.htm", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, String> saveEdittedShops(
			@ModelAttribute InvoicePojo pojo, HttpSession session,
			HttpServletRequest request) {
		if (session.getAttribute(ApplicationConstants.LOGGED_IN) == null) {
			return CommonObjectMethods
					.buildOutObject(ApplicationConstants.SESSION_TIMED_OUT);
		}
		return shopSpecialService.saveEditedShopDetails(pojo);

	}

	/**
	 * 
	 * @param pojo
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getShopsProdcutMap.htm", method = RequestMethod.GET)
	public String getShopsProdcutMap(HttpSession session,
			HttpServletRequest request) {
		String page = "editproductMap";
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
	@RequestMapping(value = "/saveProductMapCost.htm", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String,String> saveProductMapCost(HttpSession session,
			HttpServletRequest request) {
		String id = request.getParameter("id");
		String productCost = request.getParameter("itemPrice");
		String prodcutPercentage = request.getParameter("itemPercentage");
		
		if (session.getAttribute(ApplicationConstants.LOGGED_IN) == null) {
			CommonObjectMethods.buildOutObject(ApplicationConstants.SESSION_TIMED_OUT);
		}
		return shopSpecialService.saveProductMapCost(id, productCost, prodcutPercentage);

	}

}
