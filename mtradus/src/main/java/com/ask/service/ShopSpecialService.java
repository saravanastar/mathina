/**
 * 
 */
package com.ask.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ask.dao.ShopsSpecialDAOImpl;
import com.ask.pojo.InvoicePojo;
import com.ask.util.CommonObjectMethods;

/**
 * @author 298651
 * 
 */
@Service
public class ShopSpecialService {
	@Autowired
	ShopsSpecialDAOImpl shopSpecialDAO;

	public ShopsSpecialDAOImpl getShopSpecialDAO() {
		return shopSpecialDAO;
	}

	public void setShopSpecialDAO(ShopsSpecialDAOImpl shopSpecialDAO) {
		this.shopSpecialDAO = shopSpecialDAO;
	}
	/**
	 * 
	 * @param pojo
	 * @return
	 */
	public HashMap<String, String> saveEditedShopDetails(InvoicePojo pojo) {
		String responseString = shopSpecialDAO.saveEditedShop(pojo);
		return CommonObjectMethods.buildOutObject(responseString);
	}
	/**
	 * 
	 * @param id
	 * @param productCost
	 * @param prodcutPercentage
	 * @return
	 */
	public HashMap<String, String> saveProductMapCost(String id,
			String productCost, String prodcutPercentage) {
		String responseString = shopSpecialDAO.saveProductMapCost(id,
				productCost, prodcutPercentage);
		return CommonObjectMethods.buildOutObject(responseString);
	}

}
