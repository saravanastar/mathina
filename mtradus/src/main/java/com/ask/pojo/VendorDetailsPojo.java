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
	String vendorId;
	String vendorName;
	List<ProductDetailsPojo> productDetails;
	
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
