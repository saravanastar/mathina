/**
 * 
 */
package com.ask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ask.dbpojo.Shops;
import com.ask.service.ShopService;

/**
 * @author sahar8
 *
 */
@Controller
public class ShopController {
	
	@Autowired
	ShopService shopService;
	
	/**
	 * @return the shopService
	 */
	public ShopService getShopService() {
		return shopService;
	}

	/**
	 * @param shopService the shopService to set
	 */
	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}

	@RequestMapping(value="/shop", method = RequestMethod.POST)
	public void addShop(@RequestBody Shops shop) {
		shopService.addShopData(shop);
	}
	
}
