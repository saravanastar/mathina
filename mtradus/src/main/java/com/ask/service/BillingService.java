/**
 * 
 */
package com.ask.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ask.dao.BillingDAOImpl;
import com.ask.pojo.InvoicePojo;
import com.ask.util.CommonObjectMethods;

/**
 * @author 298651
 *
 */
@Service
public class BillingService {

	@Autowired
	BillingDAOImpl billingDAO;

	public BillingDAOImpl getBillingDAO() {
		return billingDAO;
	}

	public void setBillingDAO(BillingDAOImpl billingDAO) {
		this.billingDAO = billingDAO;
	}

	public HashMap<String, String> saveBillingDetails(InvoicePojo pojo) {

		String response = billingDAO.saveBillingData(pojo);
		return CommonObjectMethods.buildOutObject(response);
	}
	
	public HashMap<String, String> saveEditedBillingData(String id,String billAmount,String shopId) {
		String response = billingDAO.saveEditedBillingData(id,billAmount,shopId);
		return CommonObjectMethods.buildOutObject(response);
	}
	public HashMap<String, String> removeBillingData(String id,String billAmount,String shopId) {
		String response = billingDAO.removeBillingData(id,billAmount,shopId);
		return CommonObjectMethods.buildOutObject(response);
	}
	
}
