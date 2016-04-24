/**
 * 
 */
package com.ask.pojo;

import java.io.Serializable;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

/**
 * @author ASK
 *
 */
public class VendorDetailsPojo extends ResourceSupport implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1976904805329490396L;
	private int vendorId;
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

	/**
	 * @return the vendorId
	 */
	public int getVendorId() {
		return vendorId;
	}
	/**
	 * @param vendorId the vendorId to set
	 */
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	/**
	 * @return the vendorName
	 */
	public String getVendorName() {
		return vendorName;
	}
	/**
	 * @param vendorName the vendorName to set
	 */
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	/**
	 * @return the productDetails
	 */
	public List<ProductDetailsPojo> getProductDetails() {
		return productDetails;
	}
	/**
	 * @param productDetails the productDetails to set
	 */
	public void setProductDetails(List<ProductDetailsPojo> productDetails) {
		this.productDetails = productDetails;
	}
	
	
}
