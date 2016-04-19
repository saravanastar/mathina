/**
 * 
 */
package com.ask.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author ASK
 *
 */
public class VendorDetailsPojo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1976904805329490396L;
	private String vendorId;
	private String vendorName;
	private List<ProductDetailsPojo> productDetails;
	private String imageLink;
	private boolean active;

	
	/**
	 * @return the imageLink
	 */
	public String getImageLink() {
		return imageLink;
	}
	/**
	 * @param imageLink the imageLink to set
	 */
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public List<ProductDetailsPojo> getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(List<ProductDetailsPojo> productDetails) {
		this.productDetails = productDetails;
	}
	
	
	
	
}
