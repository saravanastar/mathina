/**
 * 
 */
package com.ask.actions;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ask.pojo.VendorDetailsPojo;
import com.ask.service.VendorDetailItemService;
import com.ask.util.ApplicationConstants;
import com.ask.util.CommonObjectMethods;

/**
 * @author ASK
 *
 */
@Controller
public class SpecialActionController {
	
	
	@Autowired
	VendorDetailItemService vendorDetailItemService;
	
	
	
	public VendorDetailItemService getVendorDetailItemService() {
		return vendorDetailItemService;
	}
	public void setVendorDetailItemService(
			VendorDetailItemService vendorDetailItemService) {
		this.vendorDetailItemService = vendorDetailItemService;
	}
	/**
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/actions.htm",method=RequestMethod.GET)
	public String getActionsPage(HttpSession session){
		String page = "actions";
		if(session.getAttribute(ApplicationConstants.LOGGED_IN)==null){
			page = "login";
		}
		return page;
		
	}
	/**
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/vendorEdit.htm",method=RequestMethod.GET)
	public String getVendorActionsPage(HttpSession session){
		String page = "vendoraction";
		if(session.getAttribute(ApplicationConstants.LOGGED_IN)==null){
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
	@RequestMapping(value="/vendorDetailItemSubmit.htm",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String,String> saveVendorDetailItem(@ModelAttribute VendorDetailsPojo pojo,HttpSession session){
			
		if(session.getAttribute(ApplicationConstants.LOGGED_IN)==null){
			return CommonObjectMethods.buildOutObject(ApplicationConstants.SESSION_TIMED_OUT);
					
		}
		return vendorDetailItemService.saveVendorItemDetails(pojo);
	}
	/**
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/invoiceEdit.htm",method=RequestMethod.GET)
	public String getInvoiceActionsPage(HttpSession session){
		String page = "invoiceaction";
		if(session.getAttribute(ApplicationConstants.LOGGED_IN)==null){
			page = "login";
		}
		return page;
		
	}
	/**
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/billingEdit.htm",method=RequestMethod.GET)
	public String getBillingActionsPage(HttpSession session){
		String page = "billingaction";
		if(session.getAttribute(ApplicationConstants.LOGGED_IN)==null){
			page = "login";
		}
		return page;
		
	}
	/**
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/shopEdit.htm",method=RequestMethod.GET)
	public String getShopEditActionsPage(HttpSession session){
		String page = "shopEditAction";
		if(session.getAttribute(ApplicationConstants.LOGGED_IN)==null){
			page = "login";
		}
		return page;
		
	}
	
	/**
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/itemRates.htm",method=RequestMethod.GET)
	public String getItemRateActionsPage(HttpSession session){
		String page = "itemrates";
		if(session.getAttribute(ApplicationConstants.LOGGED_IN)==null){
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
	@RequestMapping(value="/saveRateEdit.htm",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String,String> saveRateEdit(@ModelAttribute VendorDetailsPojo pojo,HttpSession session){
			
		if(session.getAttribute(ApplicationConstants.LOGGED_IN)==null){
			return CommonObjectMethods.buildOutObject(ApplicationConstants.SESSION_TIMED_OUT);
					
		}
		return vendorDetailItemService.saveRateEdit(pojo);
	}

}
