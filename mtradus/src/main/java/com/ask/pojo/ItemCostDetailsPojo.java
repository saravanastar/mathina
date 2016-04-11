/**
 * 
 */
package com.ask.pojo;

import java.io.Serializable;

import com.ask.dbpojo.Discount;

/**
 * @author ASK
 *
 */
public class ItemCostDetailsPojo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2658456569240037865L;
	private int id;
	private String sellType;
	private int quantity;
	private double manufacturePrice;
	private double sellingPrice;
	private Discount discount;
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
