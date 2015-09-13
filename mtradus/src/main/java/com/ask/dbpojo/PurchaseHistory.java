/**
 * 
 */
package com.ask.dbpojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author ASK
 *
 */
@Entity
@Table(name = "PURCHASE_HISTORY")
public class PurchaseHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8990699947874304700L;

	@Id
	int id;

	@Column(name="INVOICE_NO")
	String invoiceNumber;
	
	@ManyToOne
	VendorProductItemDetails itemDetails;


	
	@Column(name = "PURCHASED_QUANTITY")
	int quantity;
	
	@Column(name = "DISCOUNT_QUQNTITY")
	int discountQuantity;
	
	@Column(name="AMOUNT")
	int amount;
	
	@Column(name="PAID_STATUS")
	String status;
	
	@Column(name="DISCOUNT")
	String discountStatus;
	
	@Column(name="LAST_UPDATED_BY")
	String lastUpdatedBy;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "PURCHASED_ON")
	Date purchasedOn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public VendorProductItemDetails getItemDetails() {
		return itemDetails;
	}

	public void setItemDetails(VendorProductItemDetails itemDetails) {
		this.itemDetails = itemDetails;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getDiscountQuantity() {
		return discountQuantity;
	}

	public void setDiscountQuantity(int discountQuantity) {
		this.discountQuantity = discountQuantity;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDiscountStatus() {
		return discountStatus;
	}

	public void setDiscountStatus(String discountStatus) {
		this.discountStatus = discountStatus;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getPurchasedOn() {
		return purchasedOn;
	}

	public void setPurchasedOn(Date purchasedOn) {
		this.purchasedOn = purchasedOn;
	}

	
}
