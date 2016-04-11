/**
 * 
 */
package com.ask.process;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.ask.dbpojo.ProductCategoryDetails;
import com.ask.dbpojo.ProductDetails;
import com.ask.dbpojo.ProductItemDetails;
import com.ask.dbpojo.VendorDetails;
import com.ask.pojo.ItemDetailsPojo;
import com.ask.pojo.ProductCategoryDetailsPojo;
import com.ask.pojo.ProductDetailsPojo;
import com.ask.pojo.VendorDetailsPojo;

/**
 * @author ASK
 *
 */
public class ProductDataService {

	/**
	 * 
	 * @param sourceVendorDBDetails
	 */
	public void copyToResponseVendor(VendorDetails sourceVendorDBDetails) {
		VendorDetailsPojo detailsPojo = new VendorDetailsPojo();
		BeanUtils.copyProperties(sourceVendorDBDetails, detailsPojo);
		List<ProductDetails> productDetails = sourceVendorDBDetails.getProductDetails();
		detailsPojo.setProductDetails(copyToResonseProductDetails(productDetails));
	}

	/**
	 * 
	 * @param productDetails
	 * @return
	 */
	public List<ProductDetailsPojo> copyToResonseProductDetails(List<ProductDetails> productDetails) {
		List<ProductDetailsPojo> productDetailsPojos = new ArrayList<ProductDetailsPojo>();
		for (ProductDetails productDetail : productDetails) {
			ProductDetailsPojo productDetailsPojo = new ProductDetailsPojo();
			productDetailsPojo.setId(productDetail.getProductId());
			productDetailsPojo.setName(productDetail.getProductName());
			productDetailsPojo
					.setCategoryDetails(copyToResonseProductCategoryDetails(productDetail.getProductCategoryDetails()));
			productDetailsPojos.add(productDetailsPojo);
		}

		return productDetailsPojos;
	}

	/**
	 * 
	 * @param categoryDetails
	 * @return
	 */
	public List<ProductCategoryDetailsPojo> copyToResonseProductCategoryDetails(
			List<ProductCategoryDetails> categoryDetails) {
		List<ProductCategoryDetailsPojo> categoryDetailsPojos = new ArrayList<ProductCategoryDetailsPojo>();
		for (ProductCategoryDetails productCategoryDetails : categoryDetails) {
			ProductCategoryDetailsPojo categoryDetailsPojo = new ProductCategoryDetailsPojo();
			categoryDetailsPojo.setId(productCategoryDetails.getCategoryId());
			categoryDetailsPojo.setName(productCategoryDetails.getCategoryName());
			List<ProductItemDetails> itemDetails = productCategoryDetails.getProductItemDetails();
			categoryDetailsPojo.setItems(copyToResonseProductItemDetails(itemDetails));
			categoryDetailsPojos.add(categoryDetailsPojo);
		}

		return categoryDetailsPojos;
	}

	/**
	 * 
	 * @param productItemDetails
	 * @return
	 */
	public List<ItemDetailsPojo> copyToResonseProductItemDetails(List<ProductItemDetails> productItemDetails) {
		List<ItemDetailsPojo> itemDetailsPojos = new ArrayList<ItemDetailsPojo>();
		for (ProductItemDetails productItemDetail : productItemDetails) {

			ItemDetailsPojo itemDetailsPojo = new ItemDetailsPojo();
			BeanUtils.copyProperties(productItemDetail, itemDetailsPojo);
			copyToResonseItemCostDetails(productItemDetail.getItemCostDetails());
			itemDetailsPojos.add(itemDetailsPojo);
		}

		return itemDetailsPojos;
	}
	
	public List<ItemDetailsPojo> copyToResonseItemCostDetails(List<ProductItemDetails> productItemDetails) {
		List<ItemDetailsPojo> itemDetailsPojos = new ArrayList<ItemDetailsPojo>();
		for (ProductItemDetails productItemDetail : productItemDetails) {

			ItemDetailsPojo itemDetailsPojo = new ItemDetailsPojo();
			BeanUtils.copyProperties(productItemDetail, itemDetailsPojo);
			
			itemDetailsPojos.add(itemDetailsPojo);
		}

		return itemDetailsPojos;
	}
}
