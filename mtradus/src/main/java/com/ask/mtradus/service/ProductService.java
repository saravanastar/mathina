/**
 * 
 */
package com.ask.mtradus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ask.mtradus.dao.ProductDetailDAO;
import com.ask.mtradus.dbpojo.VendorDetails;

/**
 * @author ASK
 *
 */
@Service
public class ProductService {

	@Autowired
	ProductDetailDAO productDetailDAO;
	
	public ProductDetailDAO getProductDetailDAO() {
		return productDetailDAO;
	}


	public void setProductDetailDAO(ProductDetailDAO productDetailDAO) {
		this.productDetailDAO = productDetailDAO;
	}


	public void addVendor(VendorDetails vendorDetails) {
		productDetailDAO.addVendorData(vendorDetails);
	}

}
