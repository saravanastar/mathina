/**
 * 
 */
package com.ask.mtradus.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ask.mtradus.dbpojo.ProductCategoryDetails;
import com.ask.mtradus.dbpojo.ProductDetails;
import com.ask.mtradus.dbpojo.ProductItemDetails;
import com.ask.mtradus.dbpojo.VendorDetails;

/**
 * @author ASK
 *
 */
@Controller
@RequestMapping("/product")
public class ProductDetailsController {

	@RequestMapping(value = "/vendors", method = RequestMethod.GET)
	@ResponseBody
	public List<VendorDetails> listVendors() {
		return null;

	}
	
	
	@RequestMapping(value = "/vendor/{vendorId}", method = RequestMethod.GET)
	@ResponseBody
	public VendorDetails getVendor(@PathVariable int vendorId) {
		return null;

	}
	
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	@ResponseBody
	public List<ProductCategoryDetails> listCategories() {
		return null;

	}
	
	@RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET)
	@ResponseBody
	public ProductCategoryDetails getCategory(@PathVariable int categoryId) {
		return null;

	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	@ResponseBody
	public List<ProductDetails> listProduct() {
		return null;

	}

	@RequestMapping(value = "/vendors", method = RequestMethod.POST)
	@ResponseBody
	public void addVendorData(@RequestBody VendorDetails vendorDetails) {

	}

	@RequestMapping(value = "/vendors/{vendorId}", method = RequestMethod.PUT)
	@ResponseBody
	public void updateVendorDetails(@PathVariable int vendorId, @RequestBody VendorDetails vendorDetails) {

	}

	@RequestMapping(value = "/vendors/{vendorId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteVendorDetails(@PathVariable int vendorId) {

	}

	public void addCategoryDetails(
			@RequestBody ProductCategoryDetails categoryDetails) {

	}

	public void updateCategoryDetails(
			@RequestBody ProductCategoryDetails categoryDetails) {

	}
	
	public void deleteCategoryDetails(
			@RequestBody ProductCategoryDetails categoryDetails) {

	}
	
	public void addProductDetails(
			@RequestBody ProductDetails productDetails) {

	}
	
	public void updateProductDetails(
			@RequestBody ProductDetails productDetails) {

	}
	
	public void deleteProductDetails(
			@RequestBody ProductDetails productDetails) {

	}
	
	public void addProductItemDetails(
			@RequestBody ProductItemDetails itemDetails) {

	}
	
	public void updateProductItemDetails(
			@RequestBody ProductItemDetails itemDetails) {

	}
	
	public void deleteProductItemDetails(
			@RequestBody ProductItemDetails itemDetails) {

	}
}
