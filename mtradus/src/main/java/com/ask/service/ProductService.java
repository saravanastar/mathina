/**
 * 
 */
package com.ask.service;

import java.util.ArrayList;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import com.ask.constn.CommonConstants;
import com.ask.controller.ProductDetailsController;
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
	
	private static final Logger log = Logger.getLogger(ProductService.class);

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

	/**
	 * 
	 * @return
	 */
	public ProductDetailDAO getProductDetailDAO() {
		return productDetailDAO;
	}

	/**
	 * 
	 * @param productDetailDAO
	 */
	public void setProductDetailDAO(ProductDetailDAO productDetailDAO) {
		this.productDetailDAO = productDetailDAO;
	}

	/**
	 * 
	 * @param vendorDetailsPojo
	 */
	public void addVendor(VendorDetailsPojo vendorDetailsPojo) {
		try {
			VendorDetails vendorDetails = productDataProcess.copyFromResponseVendorDetails(vendorDetailsPojo);
			productDetailDAO.addVendorData(vendorDetails);
		} catch (Exception exception) {
			log.error(exception.getMessage());
			throw new BusinessException(CommonConstants.VENDOR_BUSINESS_ERROR);
		}
	}

	/**
	 * 
	 * @return
	 */
	public List<VendorDetailsPojo> listAllVendorList() {
		// TODO Auto-generated method stub
		List<VendorDetailsPojo> vendorDetailsPojos = new ArrayList<VendorDetailsPojo>();
		List<VendorDetails> vendorDetails = productDetailDAO.listVendors();
		for (VendorDetails vendorDetail : vendorDetails) {
			VendorDetailsPojo detailsPojo = productDataProcess.copyToResponseVendor(vendorDetail);
			Link detail = linkTo(ProductDetailsController.class).slash("vendor").slash(detailsPojo.getVendorId()).withSelfRel();
			detailsPojo.add(detail);
			vendorDetailsPojos.add(detailsPojo);

		}
		return vendorDetailsPojos;
	}

	public VendorDetailsPojo listVendorById(int vendorId) {
		VendorDetails vendorDetail = productDetailDAO.getVendorById(vendorId);
		VendorDetailsPojo detailsPojo = productDataProcess.copyToResponseVendor(vendorDetail);
		return detailsPojo;
	}

}
