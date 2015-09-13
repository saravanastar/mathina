/**
 * 
 */
package com.ask.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ASK
 * 
 */
public class InvoicePojo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7255222549432617608L;

	String areaId;
	String shopId[];
	String billNumber[];
	Date dateOfPurchase;

	String productId[];
	String quantity[];
	String amount[];
	String itemId[];
	String reportId;
	String fromDate;
	String toDate;
	String vendorId;
	String discountPercentage;
	String shopName;

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(String discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String[] getShopId() {
		return shopId;
	}

	public void setShopId(String[] shopId) {
		this.shopId = shopId;
	}

	public String[] getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String[] billNumber) {
		this.billNumber = billNumber;
	}

	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public String[] getProductId() {
		return productId;
	}

	public void setProductId(String[] productId) {
		this.productId = productId;
	}

	public String[] getQuantity() {
		return quantity;
	}

	public void setQuantity(String[] quantity) {
		this.quantity = quantity;
	}

	public String[] getAmount() {
		return amount;
	}

	public void setAmount(String[] amount) {
		this.amount = amount;
	}

	public String[] getItemId() {
		return itemId;
	}

	public void setItemId(String[] itemId) {
		this.itemId = itemId;
	}

	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

}
