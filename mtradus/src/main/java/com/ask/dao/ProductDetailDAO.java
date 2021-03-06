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
	
	public List<ProductCategoryDetails> getCategoryByProductId(int productId);

	public List<ProductDetails> listProduct();

	public void addVendorData(VendorDetails vendorDetails) throws Exception;

	public void updateVendorDetails(VendorDetails vendorDetails);

	public void deleteVendorDetails(VendorDetails vendorDetails);

	public void addCategoryDetails(ProductCategoryDetails categoryDetails);

	public void updateCategoryDetails(int categoryId,
			ProductCategoryDetails categoryDetails);

	public void deleteCategoryDetails(ProductCategoryDetails categoryDetails);

	public void addProductDetails(ProductDetails productDetails);

	public void updateProductDetails(ProductDetails productDetails);

	public void deleteProductDetails(ProductDetails productDetails);

	public void addProductItemDetails(ProductItemDetails itemDetails);

	public void updateProductItemDetails(int itemId,
			ProductItemDetails itemDetails);

	public void deleteProductItemDetails(int itemId);

	public ProductDetails getProductById(int productId);

	public VendorDetails getVendorByName(String vendorName);

	public List<ProductItemDetails> getItemByCategoryId(int categoryId);
}
