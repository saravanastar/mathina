/**
 * 
 */
package com.ask.process;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.ask.dbpojo.ColorOption;
import com.ask.dbpojo.FlavourOption;
import com.ask.dbpojo.ItemCostDetails;
import com.ask.dbpojo.ItemOptions;
import com.ask.dbpojo.LitreOption;
import com.ask.dbpojo.ProductCategoryDetails;
import com.ask.dbpojo.ProductDetails;
import com.ask.dbpojo.ProductItemDetails;
import com.ask.dbpojo.VendorDetails;
import com.ask.dbpojo.WeightOption;
import com.ask.pojo.ColorOptionsPojo;
import com.ask.pojo.FlavourOptionsPojo;
import com.ask.pojo.ItemCostDetailsPojo;
import com.ask.pojo.ItemDetailsPojo;
import com.ask.pojo.ItemOptionsPojo;
import com.ask.pojo.LitreOptionsPojo;
import com.ask.pojo.ProductCategoryDetailsPojo;
import com.ask.pojo.ProductDetailsPojo;
import com.ask.pojo.VendorDetailsPojo;
import com.ask.pojo.WeightOptionsPojo;

/**
 * @author ASK
 *
 */
@Component
public class ProductDataProcess {

	/**
	 * 
	 * @param sourceVendorDBDetails
	 */
	public VendorDetailsPojo copyToResponseVendor(VendorDetails sourceVendorDBDetails) {
		VendorDetailsPojo detailsPojo = new VendorDetailsPojo();
		// BeanUtils.copyProperties(sourceVendorDBDetails, detailsPojo);
		detailsPojo.setVendorId(sourceVendorDBDetails.getId());
		detailsPojo.setVendorName(sourceVendorDBDetails.getVendorName());
		detailsPojo.setActive(sourceVendorDBDetails.isActive());
//		detailsPojo.setProductDetails(sourceVendorDBDetails.getProductDetails())
		 List<ProductDetails> productDetails =
		 sourceVendorDBDetails.getProductDetails();
		detailsPojo.setProductDetails(copyToResonseProductDetails(productDetails));
		return detailsPojo;
	}

	/**
	 * 
	 * @param productDetails
	 * @return
	 */
	public List<ProductDetailsPojo> copyToResonseProductDetails(List<ProductDetails> productDetails) {
		List<ProductDetailsPojo> productDetailsPojos = new ArrayList<ProductDetailsPojo>();
		for (ProductDetails productDetail : productDetails) {
			ProductDetailsPojo productDetailsPojo = productDetailBasicCopyDB(productDetail);
			productDetailsPojo.setProductCategoryDetails(
					copyToResonseProductCategoryDetails(productDetail.getProductCategoryDetails()));
			productDetailsPojos.add(productDetailsPojo);
		}

		return productDetailsPojos;
	}

	/**
	 * @param productDetail
	 * @return
	 */
	public ProductDetailsPojo productDetailBasicCopyDB(ProductDetails productDetail) {
		ProductDetailsPojo productDetailsPojo = new ProductDetailsPojo();
		productDetailsPojo.setProductId(productDetail.getProductId());
		productDetailsPojo.setProductName(productDetail.getProductName());
		BeanUtils.copyProperties(productDetail, productDetailsPojo);
		return productDetailsPojo;
	}

	/**
	 * @param productDetail
	 * @return
	 */
	public ProductDetails productDetailBasicCopyResponse(ProductDetailsPojo productDetailPojo,
			ProductDetails productDetail) {
		if (productDetail == null) {
			productDetail = new ProductDetails();
		}
		productDetail.setProductId(productDetailPojo.getProductId());
		productDetail.setProductName(productDetailPojo.getProductName());
		productDetail.setVendorId(productDetailPojo.getVendorId());
		productDetail.setStatus(productDetailPojo.isStatus());
		BeanUtils.copyProperties(productDetailPojo, productDetail);
		return productDetail;
	}

	/**
	 * Copy data from response to DB.
	 * 
	 * @param categoryDetailsPojo
	 * @param categoryDetails
	 * @return
	 */
	public ProductCategoryDetails productCategoryDetailsBasicCopyToDB(ProductCategoryDetailsPojo categoryDetailsPojo,
			ProductCategoryDetails categoryDetails) {
		if (categoryDetails == null) {
			categoryDetails = new ProductCategoryDetails();
		}
		categoryDetails.setCategoryId(categoryDetailsPojo.getCategoryId());
		categoryDetails.setCategoryName(categoryDetailsPojo.getCategoryName());
		categoryDetails.setProductId(categoryDetailsPojo.getProductId());
//		BeanUtils.copyProperties(categoryDetailsPojo, categoryDetails);
		return categoryDetails;
	}

	/**
	 * 
	 * @param itemDetailsPojo
	 * @param productItemDetails
	 * @return
	 */
	public ProductItemDetails itemDetailsCopyToDB(ItemDetailsPojo itemDetailsPojo,
			ProductItemDetails productItemDetails) {
		if (productItemDetails == null) {
			productItemDetails = new ProductItemDetails();
		}
		BeanUtils.copyProperties(itemDetailsPojo, productItemDetails);
//		copyToResonseColorOptions(colorOption)
		return productItemDetails;

	}

	/**
	 * copy the data from DB to Response.
	 * 
	 * @param categoryDetails
	 * @param categoryDetailsPojo
	 * @return
	 */
	public ProductCategoryDetailsPojo productCategoryDetailsBasicCopyToResponse(ProductCategoryDetails categoryDetails,
			ProductCategoryDetailsPojo categoryDetailsPojo) {
		if (categoryDetailsPojo == null) {
			categoryDetailsPojo = new ProductCategoryDetailsPojo();
		}
		categoryDetailsPojo.setCategoryId(categoryDetails.getCategoryId());

		categoryDetailsPojo.setCategoryName(categoryDetails.getCategoryName());
		categoryDetailsPojo.setProductId(categoryDetails.getProductId());
		BeanUtils.copyProperties(categoryDetails, categoryDetailsPojo);
		return categoryDetailsPojo;
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
			categoryDetailsPojo.setCategoryId(productCategoryDetails.getCategoryId());
			categoryDetailsPojo.setCategoryName(productCategoryDetails.getCategoryName());
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
			itemDetailsPojo.setOptions(copyToResonseItemDetailsData(productItemDetail.getItemOptions()));
			itemDetailsPojo.setPrice(copyToResponseCostDetails(productItemDetail.getItemCostDetails()));
			itemDetailsPojos.add(itemDetailsPojo);
		}

		return itemDetailsPojos;
	}

	/**
	 * 
	 * @param itemOption
	 * @return
	 */
	public ItemOptionsPojo copyToResonseItemDetailsData(ItemOptions itemOption) {

		List<ColorOptionsPojo> colorOptionsPojos = new ArrayList<ColorOptionsPojo>();
		List<WeightOptionsPojo> weightOptionsPojos = new ArrayList<WeightOptionsPojo>();
		List<LitreOptionsPojo> litreOptionsPojos = new ArrayList<LitreOptionsPojo>();
		List<FlavourOptionsPojo> flavourOptionsPojos = new ArrayList<FlavourOptionsPojo>();

		ItemOptionsPojo itemOptionsPojo = new ItemOptionsPojo();

			if (itemOption.getColorOptions() != null) {
				ColorOptionsPojo colorOption = copyToResonseColorOptions(itemOption.getColorOptions());
				colorOptionsPojos.add(colorOption);
			}
			if (itemOption.getWeightOptions() != null) {
				WeightOptionsPojo weightOptionsPojo = copyToResonseweightOption(itemOption.getWeightOptions());
				weightOptionsPojos.add(weightOptionsPojo);
			}
			if (itemOption.getLitreOptions() != null) {
				LitreOptionsPojo litreOptionsPojo = copyToResonseLitreOptionsPojo(itemOption.getLitreOptions());
				litreOptionsPojos.add(litreOptionsPojo);
			}
			if (itemOption.getFlavourOption() != null) {
				FlavourOptionsPojo flavourOptionsPojo = copyToResonseFlavourOption(itemOption.getFlavourOption());
				flavourOptionsPojos.add(flavourOptionsPojo);
			}


		itemOptionsPojo.setColors(colorOptionsPojos);
		itemOptionsPojo.setFlavours(flavourOptionsPojos);
		itemOptionsPojo.setWeights(weightOptionsPojos);
		itemOptionsPojo.setLitres(litreOptionsPojos);

		return itemOptionsPojo;
	}

	/**
	 * 
	 * @param itemCostDetails
	 * @return
	 */
	private ItemCostDetailsPojo copyToResponseCostDetails(ItemCostDetails itemCostDetails) {
		// TODO Auto-generated method stub
		ItemCostDetailsPojo itemCostDetailsPojo = new ItemCostDetailsPojo();
		BeanUtils.copyProperties(itemCostDetails, itemCostDetailsPojo);
		return itemCostDetailsPojo;
	}

	/**
	 * 
	 * @param colorOption
	 * @return
	 */
	public ColorOptionsPojo copyToResonseColorOptions(ColorOption colorOption) {
		ColorOptionsPojo colorOptionsPojo = new ColorOptionsPojo();
		BeanUtils.copyProperties(colorOption, colorOptionsPojo);
		return colorOptionsPojo;

	}

	/**
	 * 
	 * @param weightOption
	 * @return
	 */
	public WeightOptionsPojo copyToResonseweightOption(WeightOption weightOption) {
		WeightOptionsPojo weightOptionsPojo = new WeightOptionsPojo();
		BeanUtils.copyProperties(weightOption, weightOptionsPojo);
		return weightOptionsPojo;

	}

	/**
	 * 
	 * @param litreOption
	 * @return
	 */
	public LitreOptionsPojo copyToResonseLitreOptionsPojo(LitreOption litreOption) {
		LitreOptionsPojo litreOptionsPojo = new LitreOptionsPojo();
		BeanUtils.copyProperties(litreOption, litreOptionsPojo);
		return litreOptionsPojo;

	}

	/**
	 * 
	 * @param flavourOption
	 * @return
	 */
	public FlavourOptionsPojo copyToResonseFlavourOption(FlavourOption flavourOption) {
		FlavourOptionsPojo flavourOptionsPojo = new FlavourOptionsPojo();
		BeanUtils.copyProperties(flavourOption, flavourOptionsPojo);
		return flavourOptionsPojo;

	}

	public VendorDetails copyFromResponseVendorDetails(VendorDetailsPojo vendorDetailsPojo,
			VendorDetails vendorDetails) {
		if (vendorDetails == null) {
			vendorDetails = new VendorDetails();
		}
		BeanUtils.copyProperties(vendorDetailsPojo, vendorDetails);
		return vendorDetails;
	}
}
