/**
 * 
 */
package com.ask.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ask.constn.CommonConstants;
import com.ask.dao.ProductDetailDAO;
import com.ask.dbpojo.VendorDetails;
import com.ask.exception.BusinessException;
import com.ask.pojo.VendorDetailsPojo;
import com.ask.process.ProductDataProcess;

/**
 * @author ASK
 *
 */
@Service
public class ProductService {

	@Autowired
	ProductDetailDAO productDetailDAO;

	@Autowired
	ProductDataProcess productDataProcess;

	/**
	 * @return the productDataProcess
	 */
	public ProductDataProcess getProductDataProcess() {
		return productDataProcess;
	}

	/**
	 * @param productDataProcess
	 *            the productDataProcess to set
	 */
	public void setProductDataProcess(ProductDataProcess productDataProcess) {
		this.productDataProcess = productDataProcess;
	}

	public ProductDetailDAO getProductDetailDAO() {
		return productDetailDAO;
	}

	public void setProductDetailDAO(ProductDetailDAO productDetailDAO) {
		this.productDetailDAO = productDetailDAO;
	}

	public void addVendor(VendorDetailsPojo vendorDetailsPojo) {
		try {
			VendorDetails vendorDetails = productDataProcess.copyFromResponseVendorDetails(vendorDetailsPojo);
			productDetailDAO.addVendorData(vendorDetails);
		} catch (Exception exception) {
			throw new BusinessException(CommonConstants.VENDOR_BUSINESS_ERROR);
		}
	}

	public List<VendorDetailsPojo> listAllVendorList() {
		// TODO Auto-generated method stub
		List<VendorDetailsPojo> vendorDetailsPojos = new ArrayList<VendorDetailsPojo>();
		List<VendorDetails> vendorDetails = productDetailDAO.listVendors();
		for (VendorDetails vendorDetail : vendorDetails) {
			VendorDetailsPojo detailsPojo = productDataProcess.copyToResponseVendor(vendorDetail);
			vendorDetailsPojos.add(detailsPojo);

		}
		return vendorDetailsPojos;
	}

}
