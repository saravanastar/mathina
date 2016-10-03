/**
 * 
 */
package com.ask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ask.dbpojo.ProductItemDetails;
import com.ask.exception.BusinessException;
import com.ask.pojo.ItemDetailsPojo;
import com.ask.pojo.ProductCategoryDetailsPojo;
import com.ask.pojo.ProductDetailsPojo;
import com.ask.pojo.VendorDetailsPojo;
import com.ask.service.ProductService;

/**
 * @author ASK
 *
 */
@Controller
@RequestMapping("/data")
public class ProductDetailsController {

	@Autowired
	ProductService productService;

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(value = "/vendor", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void addNewVendor(@RequestBody VendorDetailsPojo vendorDetailsPojo) throws BusinessException {
		productService.addVendor(vendorDetailsPojo);
	}

	@RequestMapping(value = "/vendors", method = RequestMethod.GET)
	@ResponseBody
	public List<VendorDetailsPojo> listVendors() throws BusinessException {
		return productService.listAllVendorList();

	}

	@RequestMapping(value = "/vendor/{vendorId}", method = RequestMethod.GET)
	@ResponseBody
	public VendorDetailsPojo getVendor(@PathVariable int vendorId) throws BusinessException {
		return productService.listVendorById(vendorId);
	}

	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	@ResponseBody
	public List<ProductCategoryDetailsPojo> listCategories() {
		return productService.listCategories();

	}

	@RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET)
	@ResponseBody
	public ProductCategoryDetailsPojo getCategoryByCategoryId(@PathVariable int categoryId) {
		return productService.getCategoryByCategoryId(categoryId);
	}

	@RequestMapping(value = "/category/product/{productId}", method = RequestMethod.GET)
	@ResponseBody
	public List<ProductCategoryDetailsPojo> getCategoryByProductId(@PathVariable int productId) {
		return productService.getCategoryByProductId(productId);
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	@ResponseBody
	public List<ProductDetailsPojo> listProduct() {
		return productService.listProduct();

	}

	@RequestMapping(value = "/vendor/{vendorId}", method = RequestMethod.PUT)
	@ResponseBody
	public void updateVendorDetails(@PathVariable int vendorId, @RequestBody VendorDetailsPojo vendorDetails) {
		productService.updateVendor(vendorDetails, vendorId);
	}

	@RequestMapping(value = "/vendor/{vendorId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteVendorDetails(@PathVariable int vendorId) {
		productService.deleteVendorData(vendorId);
	}

	@RequestMapping(value = "/category", method = RequestMethod.POST)
	@ResponseBody
	public void addCategoryDetails(@RequestBody ProductCategoryDetailsPojo categoryDetails) {
		productService.addCategoryDetails(categoryDetails);
	}

	@RequestMapping(value = "/category/{categoryId}", method = RequestMethod.PUT)
	@ResponseBody
	public void updateCategoryDetails(@PathVariable int categoryId,
			@RequestBody ProductCategoryDetailsPojo categoryDetails) {
		productService.updateCategoryDetails(categoryId, categoryDetails);

	}

	@RequestMapping(value = "/category/{categoryId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteCategoryDetails(@PathVariable int categoryId) {
		productService.deleteCategoyDetail(categoryId);
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	@ResponseBody
	public void addProductDetails(@RequestBody ProductDetailsPojo productDetails) {
		productService.addProductDetails(productDetails);

	}

	@RequestMapping(value = "/product/{productId}", method = RequestMethod.PUT)
	@ResponseBody
	public void updateProductDetails(@PathVariable int productId, @RequestBody ProductDetailsPojo productDetails) {
		productService.updateProductDetails(productId, productDetails);

	}

	@RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
	@ResponseBody
	public ProductDetailsPojo getProductDetail(@PathVariable int productId) {
		return productService.getProductDetail(productId);
	}

	@RequestMapping(value = "/product/{productId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteProductDetails(@PathVariable int productId) {
		productService.deleteProductDetails(productId);

	}

	@RequestMapping(value = "/item}", method = RequestMethod.POST)
	@ResponseBody
	public void addProductItemDetails(@RequestBody ItemDetailsPojo itemDetails) {
		productService.addProductItem(itemDetails);

	}

	@RequestMapping(value = "/item/{itemId}", method = RequestMethod.PUT)
	@ResponseBody
	public void updateProductItemDetails(@PathVariable int itemId, @RequestBody ProductItemDetails itemDetails) {

	}

	@RequestMapping(value = "/item/{itemId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteProductItemDetails(@PathVariable int itemId) {

	}
}
