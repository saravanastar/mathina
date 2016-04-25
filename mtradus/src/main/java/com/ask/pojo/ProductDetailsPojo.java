/**
 * 
 */
package com.ask.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author ASK
 *
 */
public class ProductDetailsPojo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8407265179182626914L;

	int productId;

	int vendorId;

	List<ProductCategoryDetailsPojo> productCategoryDetails;

	private String productName;

	private String description;

	private boolean status;

	private Date expiredOn;

	private String imageLink;

	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * @return the vendorId
	 */
	public int getVendorId() {
		return vendorId;
	}

	/**
	 * @param vendorId
	 *            the vendorId to set
	 */
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	/**
	 * @return the productCategoryDetails
	 */
	public List<ProductCategoryDetailsPojo> getProductCategoryDetails() {
		return productCategoryDetails;
	}

	/**
	 * @param productCategoryDetails the productCategoryDetails to set
	 */
	public void setProductCategoryDetails(List<ProductCategoryDetailsPojo> productCategoryDetails) {
		this.productCategoryDetails = productCategoryDetails;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName
	 *            the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return the expiredOn
	 */
	public Date getExpiredOn() {
		return expiredOn;
	}

	/**
	 * @param expiredOn
	 *            the expiredOn to set
	 */
	public void setExpiredOn(Date expiredOn) {
		this.expiredOn = expiredOn;
	}

	/**
	 * @return the imageLink
	 */
	public String getImageLink() {
		return imageLink;
	}

	/**
	 * @param imageLink
	 *            the imageLink to set
	 */
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
}
