/**
 * 
 */
package com.ask.dao;

import java.util.List;

import com.ask.dbpojo.ProductCategoryDetails;
import com.ask.dbpojo.ProductDetails;
import com.ask.dbpojo.ProductItemDetails;
import com.ask.dbpojo.VendorDetails;

/**
 * @author ASK
 *
 */
public interface ProductDetailDAO {

	public List<VendorDetails> listVendors();

	public VendorDetails getVendorById(int vendorId);

	public List<ProductCategoryDetails> listCategories();

	public ProductCategoryDetails getCategoryById(int categoryId);

	public List<ProductDetails> listProduct();

	public void addVendorData(VendorDetails vendorDetails);

	public void updateVendorDetails(int vendorId, VendorDetails vendorDetails);

	public void deleteVendorDetails(int vendorId);

	public void addCategoryDetails(ProductCategoryDetails categoryDetails);

	public void updateCategoryDetails(int categoryId,
			ProductCategoryDetails categoryDetails);

	public void deleteCategoryDetails(ProductCategoryDetails categoryDetails);

	public void addProductDetails(ProductDetails productDetails);

	public void updateProductDetails(ProductDetails productDetails);

	public void deleteProductDetails(int productId);

	public void addProductItemDetails(ProductItemDetails itemDetails);

	public void updateProductItemDetails(int itemId,
			ProductItemDetails itemDetails);

	public void deleteProductItemDetails(int itemId);
}
