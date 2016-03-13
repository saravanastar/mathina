/**
 * 
 */
package com.ask.mtradus.pojo;

import java.io.Serializable;

/**
 * @author ASK
 *
 */
public class PurchaseData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9073751319214271475L;
	
	String vendorId;
	String productId[];
	String itemId[];
	String quantity[];
	String cost[];
	String discountId[];
	String discountPer[];
	String discountItem[];
	String discountItemId[];
	String otherItem[];
	String discountStatus[];
	String amountPaid[];
	String billNumber[];
	String discountQuantity[];
	
	
	
	public String[] getDiscountQuantity() {
		return discountQuantity;
	}
	public void setDiscountQuantity(String[] discountQuantity) {
		this.discountQuantity = discountQuantity;
	}
	public String[] getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(String[] billNumber) {
		this.billNumber = billNumber;
	}
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	public String[] getProductId() {
		return productId;
	}
	public void setProductId(String[] productId) {
		this.productId = productId;
	}
	public String[] getItemId() {
		return itemId;
	}
	public void setItemId(String[] itemId) {
		this.itemId = itemId;
	}
	public String[] getQuantity() {
		return quantity;
	}
	public void setQuantity(String[] quantity) {
		this.quantity = quantity;
	}
	public String[] getCost() {
		return cost;
	}
	public void setCost(String[] cost) {
		this.cost = cost;
	}
	public String[] getDiscountId() {
		return discountId;
	}
	public void setDiscountId(String[] discountId) {
		this.discountId = discountId;
	}
	public String[] getDiscountPer() {
		return discountPer;
	}
	public void setDiscountPer(String[] discountPer) {
		this.discountPer = discountPer;
	}
	public String[] getDiscountItem() {
		return discountItem;
	}
	public void setDiscountItem(String[] discountItem) {
		this.discountItem = discountItem;
	}
	public String[] getDiscountItemId() {
		return discountItemId;
	}
	public void setDiscountItemId(String[] discountItemId) {
		this.discountItemId = discountItemId;
	}
	public String[] getOtherItem() {
		return otherItem;
	}
	public void setOtherItem(String[] otherItem) {
		this.otherItem = otherItem;
	}
	public String[] getDiscountStatus() {
		return discountStatus;
	}
	public void setDiscountStatus(String[] discountStatus) {
		this.discountStatus = discountStatus;
	}
	public String[] getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(String[] amountPaid) {
		this.amountPaid = amountPaid;
	}
	
	
	}
