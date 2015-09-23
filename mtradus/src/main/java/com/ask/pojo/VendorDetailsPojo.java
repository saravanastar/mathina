/**
 * 
 */
package com.ask.pojo;

import java.io.Serializable;

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
	String productId;
	String productName;
	String itemId;
	String itemName;
	String itemQuanity;
	String retailAmount;
	String itemMrp;
	String itemVat;
	
	
	
	public String getItemMrp() {
		return itemMrp;
	}
	public void setItemMrp(String itemMrp) {
		this.itemMrp = itemMrp;
	}
	public String getItemVat() {
		return itemVat;
	}
	public void setItemVat(String itemVat) {
		this.itemVat = itemVat;
	}
	public String getItemQuanity() {
		return itemQuanity;
	}
	public void setItemQuanity(String itemQuanity) {
		this.itemQuanity = itemQuanity;
	}
	public String getRetailAmount() {
		return retailAmount;
	}
	public void setRetailAmount(String retailAmount) {
		this.retailAmount = retailAmount;
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
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

}
