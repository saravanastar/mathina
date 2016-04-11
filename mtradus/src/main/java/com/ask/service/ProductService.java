/**
 * 
 */
package com.ask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ask.dao.ProductDetailDAO;
import com.ask.dbpojo.VendorDetails;

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
