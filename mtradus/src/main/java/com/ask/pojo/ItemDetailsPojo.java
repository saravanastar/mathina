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
	private String itemName;
	private String description;
	private boolean status;
	private String expiredOn;
	private String createdOn;
	private ItemOptionsPojo options;
	
	
	
	
	public ItemOptionsPojo getOptions() {
		return options;
	}
	public void setOptions(ItemOptionsPojo options) {
		this.options = options;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getExpiredOn() {
		return expiredOn;
	}
	public void setExpiredOn(String expiredOn) {
		this.expiredOn = expiredOn;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	
	
	

}
