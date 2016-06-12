/**
 * 
 */
package com.ask.service;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import com.ask.constn.CommonConstants;
import com.ask.controller.ProductDetailsController;
import com.ask.dao.ProductDetailDAO;
import com.ask.dbpojo.ProductCategoryDetails;
import com.ask.dbpojo.ProductDetails;
import com.ask.dbpojo.VendorDetails;
import com.ask.exception.BusinessException;
import com.ask.pojo.ProductCategoryDetailsPojo;
import com.ask.pojo.ProductDetailsPojo;
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
			VendorDetails vendorDetails = productDataProcess.copyFromResponseVendorDetails(vendorDetailsPojo, null);
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
			Link detail = linkTo(methodOn(ProductDetailsController.class).getVendor(detailsPojo.getVendorId()))
					.withSelfRel();
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

	public List<ProductDetailsPojo> listProduct() {
		// TODO Auto-generated method stub
		List<ProductDetails> productDetails = productDetailDAO.listProduct();
		return productDataProcess.copyToResonseProductDetails(productDetails);
	}

	public void addProductDetails(ProductDetailsPojo productDetails) {
		// TODO Auto-generated method stub
		ProductDetails productDetail = productDataProcess.productDetailBasicCopyResponse(productDetails, null);
		productDetail.setCretedOn(new Date());
		productDetail.setExpiredOn(new Date());
		if (productDetailDAO.getVendorById(productDetails.getVendorId()) == null) {
			log.error("VEndor Details not exists to add the product");
			throw new BusinessException(CommonConstants.BAD_REQUEST);
		}
		productDetailDAO.addProductDetails(productDetail);

	}

	public void updateVendor(VendorDetailsPojo vendorDetailsPojo, int vendorId) {
		try {
			VendorDetails vendor = productDetailDAO.getVendorById(vendorId);
			if (vendor == null) {
				log.error("Vendor Data not found for the Id");
				throw new BusinessException(CommonConstants.BAD_REQUEST);
			}
			VendorDetails vendorDetails = productDataProcess.copyFromResponseVendorDetails(vendorDetailsPojo, vendor);
			productDetailDAO.updateVendorDetails(vendorDetails);
		} catch (Exception exception) {
			log.error(exception.getMessage());
			throw new BusinessException(CommonConstants.VENDOR_BUSINESS_ERROR);
		}

	}

	public void deleteVendorData(int vendorId) {
		VendorDetails vendorDetails = productDetailDAO.getVendorById(vendorId);
		if (vendorDetails == null) {
			log.error("Vendor Data not found for the Id");
			throw new BusinessException(CommonConstants.BAD_REQUEST);
		}
		productDetailDAO.deleteVendorDetails(vendorDetails);

	}

	public void updateProductDetails(int productId, ProductDetailsPojo productDetailsPojo) {
		try {
			ProductDetails productDetail = productDetailDAO.getProductById(productId);
			if (productDetail == null) {
				log.error("Vendor Data not found for the Id");
				throw new BusinessException(CommonConstants.BAD_REQUEST);
			}
			productDetailsPojo.setProductId(productId);
			ProductDetails productToUpdate = productDataProcess.productDetailBasicCopyResponse(productDetailsPojo,
					productDetail);
			productDetailDAO.updateProductDetails(productToUpdate);
		} catch (Exception exception) {
			log.error(exception.getMessage());
			throw new BusinessException(CommonConstants.VENDOR_BUSINESS_ERROR);
		}

	}

	public void deleteProductDetails(int productId) {
		// TODO Auto-generated method stub
		try {
			ProductDetails productDetail = productDetailDAO.getProductById(productId);
			if (productDetail == null) {
				log.error("Product Data not found for the Id");
				throw new BusinessException(CommonConstants.BAD_REQUEST);
			}
			productDetailDAO.deleteProductDetails(productDetail);
		} catch (Exception exception) {
			log.error(exception.getMessage());
			throw new BusinessException(CommonConstants.VENDOR_BUSINESS_ERROR);
		}

	}

	/**
	 * get product Details by Product Id.
	 * 
	 * @param productId
	 * @return
	 */
	public ProductDetailsPojo getProductDetail(int productId) {
		ProductDetailsPojo productDetailPojo = null;
		try {
			ProductDetails productDetail = productDetailDAO.getProductById(productId);
			if (productDetail == null) {
				log.error("Product Data not found for the Id");
				throw new BusinessException(CommonConstants.BAD_REQUEST);
			}
			productDetailPojo = productDataProcess.productDetailBasicCopyDB(productDetail);
		} catch (Exception exception) {
			log.error(exception.getMessage());
			throw new BusinessException(CommonConstants.VENDOR_BUSINESS_ERROR);
		}
		return productDetailPojo;
	}

	/**
	 * Add the category Details.
	 * 
	 * @param categoryDetailsPojo
	 */
	public void addCategoryDetails(ProductCategoryDetailsPojo categoryDetailsPojo) {
		// TODO Auto-generated method stub
		if (categoryDetailsPojo != null && categoryDetailsPojo.getProductId() == 0) {
			log.info("Product id must be there to add the category details");
			throw new BusinessException(CommonConstants.BAD_REQUEST);
		}
		ProductCategoryDetails productCategoryDetails = productDataProcess
				.productCategoryDetailsBasicCopyToDB(categoryDetailsPojo, null);
		productCategoryDetails.setCretedOn(new Date());
		productDetailDAO.addCategoryDetails(productCategoryDetails);
	}

	/**
	 * Get all categories listed.
	 * 
	 * @return
	 */
	public List<ProductCategoryDetailsPojo> listCategories() {
		List<ProductCategoryDetailsPojo> categoryDetailsPojos = new ArrayList<ProductCategoryDetailsPojo>();
		List<ProductCategoryDetails> categoryDetails = productDetailDAO.listCategories();
		for (ProductCategoryDetails categoryDetail : categoryDetails) {
			ProductCategoryDetailsPojo detailsPojo = productDataProcess
					.productCategoryDetailsBasicCopyToResponse(categoryDetail, null);
			Link detailCategoryId = linkTo(
					methodOn(ProductDetailsController.class).getCategoryByCategoryId(detailsPojo.getCategoryId()))
							.withSelfRel();
			Link detailProductId = linkTo(
					methodOn(ProductDetailsController.class).getProductDetail(detailsPojo.getProductId()))
							.withSelfRel();
			detailsPojo.add(detailCategoryId);
			detailsPojo.add(detailProductId);
			categoryDetailsPojos.add(detailsPojo);

		}
		return categoryDetailsPojos;
	}
	
	/**
	 * Get the category details by Category Id.
	 * @param categoryId
	 * @return
	 */
	public ProductCategoryDetailsPojo getCategoryByCategoryId(int categoryId) {
		// TODO Auto-generated method stub
		ProductCategoryDetails categoryDetail = productDetailDAO.getCategoryById(categoryId);
		ProductCategoryDetailsPojo detailsPojo = productDataProcess
				.productCategoryDetailsBasicCopyToResponse(categoryDetail, null);
		Link detailCategoryId = linkTo(
				methodOn(ProductDetailsController.class).getCategoryByCategoryId(detailsPojo.getCategoryId()))
						.withSelfRel();
		Link detailProductId = linkTo(
				methodOn(ProductDetailsController.class).getProductDetail(detailsPojo.getProductId())).withRel("");
		detailsPojo.add(detailCategoryId);
		detailsPojo.add(detailProductId);
		return detailsPojo;
	}

	/**
	 * Get the category details by Product Id.
	 * @param categoryId
	 * @return
	 */
	public ProductCategoryDetailsPojo getCategoryByProductId(int productId) {
		ProductCategoryDetails categoryDetail = productDetailDAO.getCategoryByProductId(productId);
		ProductCategoryDetailsPojo detailsPojo = productDataProcess
				.productCategoryDetailsBasicCopyToResponse(categoryDetail, null);
		Link detailCategoryId = linkTo(
				methodOn(ProductDetailsController.class).getCategoryByCategoryId(detailsPojo.getCategoryId()))
						.withSelfRel();
		Link detailProductId = linkTo(
				methodOn(ProductDetailsController.class).getProductDetail(detailsPojo.getProductId())).withSelfRel();
		detailsPojo.add(detailCategoryId);
		detailsPojo.add(detailProductId);
		return detailsPojo;
	}

	/**
	 * update category Details by categoryId.
	 * @param categoryId
	 * @param categoryDetailsPojo
	 */
	public void updateCategoryDetails(int categoryId, ProductCategoryDetailsPojo categoryDetailsPojo) {
		
		ProductCategoryDetails productCategoryDetails = productDetailDAO.getCategoryById(categoryId);
		productCategoryDetails = productDataProcess
				.productCategoryDetailsBasicCopyToDB(categoryDetailsPojo, productCategoryDetails);
		productDetailDAO.updateCategoryDetails(categoryId, productCategoryDetails);
		
		
	}

	/**
	 * Deleting the category by categoy Id.
	 * @param categoryId
	 */
	public void deleteCategoyDetail(int categoryId) {
		// TODO Auto-generated method stub
		ProductCategoryDetails productCategoryDetails = productDetailDAO.getCategoryById(categoryId);
		productDetailDAO.deleteCategoryDetails(productCategoryDetails);
		
	}

}
