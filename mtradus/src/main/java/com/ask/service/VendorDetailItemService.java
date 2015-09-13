/**
 * 
 */
package com.ask.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ask.dao.VendorDetailItemDAOImpl;
import com.ask.pojo.VendorDetailsPojo;
import com.ask.util.CommonObjectMethods;

/**
 * @author ASK
 *
 */
@Service
public class VendorDetailItemService {

	@Autowired
	VendorDetailItemDAOImpl vendorDetailItemDAOImpl;
	
	
	
	public VendorDetailItemDAOImpl getVendorDetailItemDAOImpl() {
		return vendorDetailItemDAOImpl;
	}



	public void setVendorDetailItemDAOImpl(
			VendorDetailItemDAOImpl vendorDetailItemDAOImpl) {
		this.vendorDetailItemDAOImpl = vendorDetailItemDAOImpl;
	}



	public HashMap<String, String> saveVendorItemDetails(VendorDetailsPojo pojo){
		String response = vendorDetailItemDAOImpl.saveVendorDetailsItem(pojo);
		HashMap<String, String> map = CommonObjectMethods.buildOutObject(response);
		return map;
		
	}



	public HashMap<String, String> saveRateEdit(VendorDetailsPojo pojo) {
		// TODO Auto-generated method stub
		String response = vendorDetailItemDAOImpl.saveRateEdit(pojo);
		HashMap<String, String> map = CommonObjectMethods.buildOutObject(response);
		return map;
	}
}
