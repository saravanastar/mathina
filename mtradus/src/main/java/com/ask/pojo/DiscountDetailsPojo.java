/**
 * 
 */
package com.ask.pojo;

import java.io.Serializable;

/**
 * @author ASK
 *
 */
public class DiscountDetailsPojo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7069773775868882342L;
	private int id;
	private int itemId;
	private String itemName;
	private String discountPer;
	private String discountCount;
	private double amount;
	private int percentage;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
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
