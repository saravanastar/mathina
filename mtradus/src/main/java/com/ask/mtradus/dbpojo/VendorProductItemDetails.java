/**
 * 
 */
package com.ask.mtradus.dbpojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author 298651
 *
 */
@Entity
@Table (name="VENDOR_PRODUCT_ITEM_DETAILS")
public class VendorProductItemDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6777829137470785723L;
	
	@Id
	int itemId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	VendorProductDetails productDetails;
	
	@Column(name = "ITEM_NAME")
	String itemName;

	@Column(name = "ITEM_QUANTITY")
	String quantity;
	
	@Column(name = "ITEM_RETAIL_AMOUNT")
	int retailAmount;
	
	@Column(name = "ITEM_RETAIL_PERCENTAGE")
	int retailPercentage;
	
	@Column(name = "ITEM_MRP")
	int itemMRP;
	
	@Column(name = "ITEM_VAT")
	int itemVate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_ON", nullable = false)
	Date cretedOn;

	
	public int getItemMRP() {
		return itemMRP;
	}

	public void setItemMRP(int itemMRP) {
		this.itemMRP = itemMRP;
	}

	public int getItemVate() {
		return itemVate;
	}

	public void setItemVate(int itemVate) {
		this.itemVate = itemVate;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public VendorProductDetails getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(VendorProductDetails productDetails) {
		this.productDetails = productDetails;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public int getRetailAmount() {
		return retailAmount;
	}

	public void setRetailAmount(int retailAmount) {
		this.retailAmount = retailAmount;
	}

	public int getRetailPercentage() {
		return retailPercentage;
	}

	public void setRetailPercentage(int retailPercentage) {
		this.retailPercentage = retailPercentage;
	}

	public Date getCretedOn() {
		return cretedOn;
	}

	public void setCretedOn(Date cretedOn) {
		this.cretedOn = cretedOn;
	}

	
	
	
	
}
