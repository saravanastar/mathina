/**
 * 
 */
package com.ask.dbpojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ASK
 *
 */
@Entity
@Table (name = "ITEM_COST_DETAILS")
public class ItemCostDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "ITEM_SELL_TYPE")
	private String sellType;

	@Column(name = "ITEM_QUANTITY")	
	private int quantity;
	
	@Column(name = "ORIGINAL_PRICE")
	private double manufacturePrice;
	
	@Column(name = "SELLING_PRICE")
	private double sellingPrice;
	
	@Column(name = "CLEARNCE_PRICE")
	private double clearancePrice;
	
	@Column(name = "DISCOUNT_DETAILS")
	private Discount discount;
	
	
	public double getClearancePrice() {
		return clearancePrice;
	}

	public void setClearancePrice(double clearancePrice) {
		this.clearancePrice = clearancePrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSellType() {
		return sellType;
	}

	public void setSellType(String sellType) {
		this.sellType = sellType;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getManufacturePrice() {
		return manufacturePrice;
	}

	public void setManufacturePrice(double manufacturePrice) {
		this.manufacturePrice = manufacturePrice;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
	
}
