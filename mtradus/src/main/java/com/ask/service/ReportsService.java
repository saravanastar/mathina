/**
 * 
 */
package com.ask.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ask.dao.ReportsDAOImpl;
import com.ask.pojo.InvoicePojo;
import com.ask.util.ApplicationConstants;
import com.google.gson.Gson;

/**
 * @author ASK
 * 
 */
@Service
public class ReportsService {

	@Autowired
	ReportsDAOImpl reportDAO;

	public ReportsDAOImpl getReportDAO() {
		return reportDAO;
	}

	public void setReportDAO(ReportsDAOImpl reportDAO) {
		this.reportDAO = reportDAO;
	}

	public String  getReport(InvoicePojo pojo) {
		List<Object> object;
		Gson gson = new Gson();
		// TODO Auto-generated method stub
		HashMap<String,String> map = new HashMap<String,String>();
		
		if(pojo.getReportId()!=null && !pojo.getReportId().equalsIgnoreCase("")){
			if(pojo.getReportId().equalsIgnoreCase("1")){
				object = reportDAO.loadPaidStatusReport(pojo);
				map.put("Header", ApplicationConstants.PAID_STATUS_REPORT_HEADING);
				map.put("data", gson.toJson(object).toString());
			}
			if(pojo.getReportId().equalsIgnoreCase("2")){
				object = reportDAO.loadProductSalesReport(pojo);
				map.put("Header", ApplicationConstants.PRODCUT_SALES_REPORT_HEADING);
				map.put("data", gson.toJson(object).toString());
			}
			if(pojo.getReportId().equalsIgnoreCase("3")){
				object = reportDAO.loadPCashCollectionReport(pojo);
				map.put("Header", ApplicationConstants.CASH_COLLECTION_REPORT_HEADING);
				map.put("data", gson.toJson(object).toString());
			}
			
			if(pojo.getReportId().equalsIgnoreCase("4")){
				object = reportDAO.getPurchaseData(pojo);
				map.put("Header", ApplicationConstants.PURCHASE_HEADER);
				map.put("data", gson.toJson(object).toString());
			}
			if(pojo.getReportId().equalsIgnoreCase("5")){
				object = reportDAO.getInventoryData(pojo);
				map.put("Header", ApplicationConstants.INVENTORY_HEADER);
				map.put("data", gson.toJson(object).toString());
			}
			if(pojo.getReportId().equalsIgnoreCase("6")){
				object = reportDAO.loadMiscellenousReport(pojo);
				map.put("Header", ApplicationConstants.MISCELLAENOUS_HEADER);
				map.put("data", gson.toJson(object).toString());
			}
			
			
		}
		return gson.toJson(map).toString();
	}

}
