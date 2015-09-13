/**
 * 
 */
package com.ask.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ask.adapter.BillHistoryAdapter;
import com.ask.adapter.PurchaseHistoryAdapter;
import com.ask.adapter.ShopBillAdapter;
import com.ask.adapter.VendorProductItemDetailsAdapter;
import com.ask.dbpojo.BillPaidHistory;
import com.ask.dbpojo.PurchaseHistory;
import com.ask.dbpojo.ShopBillDetails;
import com.ask.dbpojo.VendorDetails;
import com.ask.dbpojo.VendorProductDetails;
import com.ask.dbpojo.VendorProductItemDetails;
import com.ask.service.DataService;
import com.ask.util.ApplicationConstants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author ASK
 * 
 */
@Controller
public class DataController {

	@Autowired
	DataService dataService;

	public DataService getDataService() {
		return dataService;
	}

	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}

	@RequestMapping(value = "/allVendorList.htm", method = RequestMethod.GET)
	@ResponseBody
	public List<VendorDetails> getAllVendorList(HttpSession session) {
		if (session.getAttribute(ApplicationConstants.LOGGED_IN) == null) {
			return null;
		}
		return dataService.getVendorList();

	}

	@RequestMapping(value = "/getProductByVendor.htm", method = RequestMethod.GET)
	@ResponseBody
	public List<VendorProductDetails> getProductByVendor(HttpSession session,
			HttpServletRequest request) {
		String id = request.getParameter("id");
		if (session.getAttribute(ApplicationConstants.LOGGED_IN) == null
				&& id != null) {
			return null;
		}
		return dataService.getProductByVendor(id);

	}
	@RequestMapping(value = "/getItemByProduct.htm", method = RequestMethod.GET)
	@ResponseBody
	public String getItemByProduct(HttpSession session,
			HttpServletRequest request) {
		String id = request.getParameter("id");
		if (session.getAttribute(ApplicationConstants.LOGGED_IN) == null
				&& id != null) {
			return null;
		}
		 GsonBuilder gsonBuilder = new GsonBuilder();
		    Gson gson = gsonBuilder.registerTypeAdapter(VendorProductItemDetails.class, new VendorProductItemDetailsAdapter()).create();
		return gson.toJson(dataService.getItemByProduct(id));

	}
	@RequestMapping(value = "/getInvoiceDetails.htm", method = RequestMethod.GET)
	@ResponseBody
	public String getInvoiceDetails(HttpSession session,
			HttpServletRequest request) {
		String id = request.getParameter("id");
		if (session.getAttribute(ApplicationConstants.LOGGED_IN) == null
				&& id != null) {
			return null;
		}
		 GsonBuilder gsonBuilder = new GsonBuilder();
	    Gson gson = gsonBuilder.registerTypeAdapter(ShopBillDetails.class, new ShopBillAdapter()).create();
		return gson.toJson(dataService.getInvoiceDetails(id));

	}
	@RequestMapping(value = "/getBillingDetails.htm", method = RequestMethod.GET)
	@ResponseBody
	public String getBillingDetails(HttpSession session,
			HttpServletRequest request) {
		String id = request.getParameter("id");
		if (session.getAttribute(ApplicationConstants.LOGGED_IN) == null
				&& id != null) {
			return null;
		}
		 GsonBuilder gsonBuilder = new GsonBuilder();
	    Gson gson = gsonBuilder.registerTypeAdapter(BillPaidHistory.class, new BillHistoryAdapter()).create();
		return gson.toJson(dataService.getBillingDetails(id));

	}
	
	@RequestMapping(value = "/getPurchaseDetails.htm", method = RequestMethod.GET)
	@ResponseBody
	public String getPurchaseDetails(HttpSession session,
			HttpServletRequest request) {
		String id = request.getParameter("id");
		if (session.getAttribute(ApplicationConstants.LOGGED_IN) == null
				&& id != null) {
			return null;
		}
		 GsonBuilder gsonBuilder = new GsonBuilder();
	    Gson gson = gsonBuilder.registerTypeAdapter(PurchaseHistory.class, new PurchaseHistoryAdapter()).create();
		return gson.toJson(dataService.getPurchaseDetails(id));

	}
	@RequestMapping(value = "/getItemData.htm", method = RequestMethod.GET)
	@ResponseBody
	public String getItemData(HttpSession session,
			HttpServletRequest request) {
		String vendorId = request.getParameter("vendorId");
		String productId = request.getParameter("productId");
		String itemId = request.getParameter("itemId");
		if (session.getAttribute(ApplicationConstants.LOGGED_IN) == null
				&& vendorId != null) {
			return null;
		}
		 GsonBuilder gsonBuilder = new GsonBuilder();
	    Gson gson = gsonBuilder.registerTypeAdapter(VendorProductItemDetails.class, new VendorProductItemDetailsAdapter()).create();
		return gson.toJson(dataService.getItemData(vendorId,productId,itemId));

	}
	
	
}
