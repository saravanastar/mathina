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
@Table(name="DISCOUNT")
public class Discount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7050959532778209926L;
	
	@Id
	int id;
	
	@ManyToOne
	ProductItemDetails itemDetails;
	
	@Column(name="ITEM_ID")
	int itemId;
	
	@Column(name="OTHER_ITEM")
	String itemName;
	
	@Column(name="DISCOUNT_PER")
	String discountPer;
	
	@Column(name="DISCOUNT_COUNT")
	String discountCount;
	
	@Column(name="amount")
	double amount;
	
	@Column(name="percentage")
	int percentage;
	
	@Column(name="LAST_UPDATED_BY")
	String lastUpdatedBy;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_UPDATED_ON")
	Date lastUpdatedOn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ProductItemDetails getItemDetails() {
		return itemDetails;
	}

	public void setItemDetails(ProductItemDetails itemDetails) {
		this.itemDetails = itemDetails;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDiscountPer() {
		return discountPer;
	}

	public void setDiscountPer(String discountPer) {
		this.discountPer = discountPer;
	}

	public String getDiscountCount() {
		return discountCount;
	}

	public void setDiscountCount(String discountCount) {
		this.discountCount = discountCount;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(Date lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	
}
