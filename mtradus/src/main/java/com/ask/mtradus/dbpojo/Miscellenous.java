/**
 * 
 */
package com.ask.mtradus.dbpojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author ASK
 *
 */
@Entity
@Table(name="Miscellenous")
public class Miscellenous implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4122188146437649775L;

	@Id
	int id;
	
	@Column(name="ITEM_NAME")
	String itemName;
	
	@Column(name="ITEM_QUANTITY")
	int quantity;
	
	@Column(name="ITEM_PRICE")
	int itemPrice;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_ON", nullable = false)
	Date createdOn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	
	
	
}
