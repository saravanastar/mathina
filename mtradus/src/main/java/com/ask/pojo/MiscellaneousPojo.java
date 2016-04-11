/**
 * 
 */
package com.ask.pojo;

import java.io.Serializable;

/**
 * @author ASK
 *
 */
public class MiscellaneousPojo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4551597794899442493L;
	String itemName;
	String itemQuantity;
	String itemPrice;
	String dateOfPurchase;
	
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(String itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getDateOfPurchase() {
		return dateOfPurchase;
	}
	public void setDateOfPurchase(String dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	
	
	
}
