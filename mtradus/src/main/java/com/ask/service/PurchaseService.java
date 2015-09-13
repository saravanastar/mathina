/**
 * 
 */
package com.ask.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ask.dao.PurchaseDAOImpl;
import com.ask.pojo.PurchaseData;
import com.ask.util.CommonObjectMethods;

/**
 * @author ASK
 *
 */
@Service
public class PurchaseService {
	
	@Autowired
	PurchaseDAOImpl purchaseDAO;

	public PurchaseDAOImpl getPurchaseDAO() {
		return purchaseDAO;
	}

	public void setPurchaseDAO(PurchaseDAOImpl purchaseDAO) {
		this.purchaseDAO = purchaseDAO;
	}
	/**
	 * 
	 * @param purchaseData
	 * @return
	 */
	public HashMap<String, String> savePurchaseDetails(PurchaseData purchaseData){
		String responseText = purchaseDAO.savePurchaseDetails(purchaseData);
		return CommonObjectMethods.buildOutObject(responseText);
	}
	/**
	 * 
	 * @param id
	 * @param billAmount
	 * @param quantity
	 * @param discountQuantity
	 * @return
	 */
	public HashMap<String, String> savePurchaseEditDetails(String id, String billAmount,
			String quantity,String discountQuantity){
		String responseText = purchaseDAO.savePurchaseEditDetails( id,  billAmount,
				 quantity, discountQuantity);
		return CommonObjectMethods.buildOutObject(responseText);
	}
	/**
	 * 
	 * @param id
	 * @param billAmount
	 * @param quantity
	 * @return
	 */
	public HashMap<String, String> removeInvoiceEditDetails(String id,
			String billAmount, String quantity) {
		String responseText = purchaseDAO.removePurchaseEditDetails(id, billAmount, quantity);
		return CommonObjectMethods.buildOutObject(responseText);
	}

	
	
}