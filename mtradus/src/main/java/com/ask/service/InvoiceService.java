/**
 * 
 */
package com.ask.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ask.dao.InvoiceDAOImpl;
import com.ask.pojo.InvoicePojo;
import com.ask.util.CommonObjectMethods;

/**
 * @author ASK
 *
 */
@Service
public class InvoiceService {
	
	@Autowired
	InvoiceDAOImpl invoiceDAO;

	public InvoiceDAOImpl getInvoiceDAO() {
		return invoiceDAO;
	}

	public void setInvoiceDAO(InvoiceDAOImpl invoiceDAO) {
		this.invoiceDAO = invoiceDAO;
	}
	/**
	 * 
	 * @param pojo
	 * @return
	 */
	public HashMap<String,String> saveInvoiceDetails(InvoicePojo pojo){
		String response = invoiceDAO.saveInvoiceDetails(pojo);
		HashMap<String, String> map = CommonObjectMethods.buildOutObject(response);
		return map;
	}
	/**
	 * 
	 * @param id
	 * @param billAmount
	 * @param quantity
	 * @return
	 */
	public HashMap<String, String> saveInvoiceDetails(String id,
			String billAmount, String quantity) {
		// TODO Auto-generated method stub
		String response = invoiceDAO.saveInvoiceEditDetails(id,billAmount,quantity);
		HashMap<String, String> map = CommonObjectMethods.buildOutObject(response);
		return map;
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
		// TODO Auto-generated method stub
		String response = invoiceDAO.removeInvoiceEditDetails(id,billAmount,quantity);
		HashMap<String, String> map = CommonObjectMethods.buildOutObject(response);
		return map;
	}
	

}
