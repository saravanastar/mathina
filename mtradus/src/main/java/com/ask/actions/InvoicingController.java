/**
 * 
 */
package com.ask.actions;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ask.adapter.ShopsAdapter;
import com.ask.dbpojo.Area;
import com.ask.dbpojo.Country;
import com.ask.dbpojo.District;
import com.ask.dbpojo.Shops;
import com.ask.dbpojo.States;
import com.ask.pojo.InvoicePojo;
import com.ask.service.DataService;
import com.ask.service.InvoiceService;
import com.ask.util.ApplicationConstants;
import com.ask.util.CommonObjectMethods;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author 298651
 * 
 */
@Controller
public class InvoicingController {
	@Autowired
	DataService dataService;
	
	@Autowired
	InvoiceService invoiceService;
	
	
	

	public InvoiceService getInvoiceService() {
		return invoiceService;
	}

	public void setInvoiceService(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}

	public DataService getDataService() {
		return dataService;
	}

	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/invoicing.htm", method = RequestMethod.GET)
	public String invoicingUser(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		String page = "login";
		if (session.getAttribute(ApplicationConstants.LOGGED_IN) != null) {
			page = "invoicing";
		}

		return page;

	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/loadDetails.htm", method = RequestMethod.GET)
	@ResponseBody
	public String loadInvoiceDetails(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		String type = request.getParameter("type");
		String id = request.getParameter("id");
		Gson gson= new Gson();
		String responseText = "";
		try {
//			PrintWriter out = response.getWriter();
			if (session.getAttribute(ApplicationConstants.LOGGED_IN) == null) {
//				out.write("");
				return responseText;
			}
			
			if (type != null) {
				if (type.equalsIgnoreCase("district")) {
					List<District> districsList = dataService
							.getAllDistrictById(id);
//					out.write(gson.toJson(districsList).toString());
					responseText = gson.toJson(districsList).toString();
				}
				if (type.equalsIgnoreCase("country")) {
					List<Country> countriesList = dataService.getAllCountries();
//					out.write(gson.toJson(countriesList).toString());
					responseText = gson.toJson(countriesList).toString();
				}
				if (type.equalsIgnoreCase("state")) {
					List<States> stateList = dataService.getAllStatesById(id);

//					out.write(gson.toJson(stateList).toString());
					responseText = gson.toJson(stateList).toString();

				}
				if (type.equalsIgnoreCase("area")) {
					List<Area> areaList = dataService.getAllAreasById(id);
//					out.write(gson.toJson(areaList).toString());
					responseText = gson.toJson(areaList).toString();
				}
				if (type.equalsIgnoreCase("shop")) {
					List<Shops> shopsList = dataService.getAllShopsById(id);
//					out.write(gson.toJson(shopsList).toString());
					 GsonBuilder gsonBuilder = new GsonBuilder();
					 gson = gsonBuilder.registerTypeAdapter(Shops.class, new ShopsAdapter()).create();
					responseText = gson.toJson(shopsList).toString();
				}
				if(type.equalsIgnoreCase("vendor")){
					List<Object> vendorList = dataService.getAllCompainesByShopId(id);
//					out.write(gson.toJson(vendorList).toString());
					responseText = gson.toJson(vendorList).toString();
				}
				if(type.equalsIgnoreCase("billNumber")){
					List<Object> vendorList = dataService.getAllBillNumbersByShopId(id);
//					out.write(gson.toJson(vendorList).toString());
					responseText = gson.toJson(vendorList).toString();
				}
				if(type.equalsIgnoreCase("billSearch")){
					List<Object> billList = dataService.getSearchedBillNumbersDetails(id);
//					out.write(gson.toJson(vendorList).toString());
					responseText = gson.toJson(billList).toString();
				}
				
			}
//		} catch (JsonGenerationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return responseText;

	}
	/**
	 * 
	 * @param invoice
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/saveInvoiceDetails.htm", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String,String> saveInvoiceDetails(@ModelAttribute InvoicePojo invoice,HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		
		if (session.getAttribute(ApplicationConstants.LOGGED_IN) == null) {
			return CommonObjectMethods.buildOutObject(ApplicationConstants.SESSION_TIMED_OUT);
		}
		
		return invoiceService.saveInvoiceDetails(invoice);
		
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/saveInvoiceEdit.htm", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String,String> saveInvoiceEditDetails(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		String id = request.getParameter("id");
		String billAmount = request.getParameter("billAmount");
		String quantity = request.getParameter("billQuantity");
		

		if (session.getAttribute(ApplicationConstants.LOGGED_IN) == null) {
			return CommonObjectMethods.buildOutObject(ApplicationConstants.SESSION_TIMED_OUT);
		}
		
		return invoiceService.saveInvoiceDetails(id,billAmount,quantity);
		
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/removeInvoiceEdit.htm", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String,String> removeInvoiceEditDetails(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		String id = request.getParameter("id");
		String billAmount = request.getParameter("billAmount");
		String quantity = request.getParameter("billQuantity");
		

		if (session.getAttribute(ApplicationConstants.LOGGED_IN) == null) {
			return CommonObjectMethods.buildOutObject(ApplicationConstants.SESSION_TIMED_OUT);
		}
		
		return invoiceService.removeInvoiceEditDetails(id,billAmount,quantity);
		
	}
	
}
