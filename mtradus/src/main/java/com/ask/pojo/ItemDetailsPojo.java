/**
 * 
 */
package com.ask.pojo;

import java.io.Serializable;

/**
 * @author ASK
 *
 */
public class ItemDetailsPojo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6511460258636223038L;
	
	private int itemId;
	private int categoryId;
	private String itemName;
	private String description;
	private boolean status;
	private String expiredOn;
	private String createdOn;
	private ItemOptionsPojo options;
	private ItemCostDetailsPojo price;
	private int totalQuantity;
	
	
	
	
	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @return the itemId
	 */
	public int getItemId() {
		return itemId;
	}
	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	/**
	 * @return the expiredOn
	 */
	public String getExpiredOn() {
		return expiredOn;
	}
	/**
	 * @param expiredOn the expiredOn to set
	 */
	public void setExpiredOn(String expiredOn) {
		this.expiredOn = expiredOn;
	}
	/**
	 * @return the createdOn
	 */
	public String getCreatedOn() {
		return createdOn;
	}
	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	/**
	 * @return the options
	 */
	public ItemOptionsPojo getOptions() {
		return options;
	}
	/**
	 * @param options the options to set
	 */
	public void setOptions(ItemOptionsPojo options) {
		this.options = options;
	}
	/**
	 * @return the price
	 */
	public ItemCostDetailsPojo getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(ItemCostDetailsPojo price) {
		this.price = price;
	}
	/**
	 * @return the totalQuantity
	 */
	public int getTotalQuantity() {
		return totalQuantity;
	}
	/**
	 * @param totalQuantity the totalQuantity to set
	 */
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	
	
}
