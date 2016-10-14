/**
 * 
 */
package com.ask.dbpojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author 298651
 *
 */
@Entity
@Table(name = "PRODUCT_ITEM_DETAILS")
public class ProductItemDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6777829137470785723L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int itemId;

	@Column(name = "CATEGORY_ID")
	int categoryId;

	@Column(name = "ITEM_NAME")
	private String itemName;

	@ManyToOne
	@JoinColumn(name = "optionId")
	ItemOptions itemOptions;

	@Column(name = "status")
	private boolean status;
	
	
	
	
	

	@Temporal(TemporalType.DATE)
	@Column(name = "EXPIRED_ON", nullable = false)
	private Date expiredOn;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_ON", nullable = false)
	private Date cretedOn;
	
	

	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId
	 *            the categoryId to set
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
	 * @param itemId
	 *            the itemId to set
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
	 * @param itemName
	 *            the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return the itemOptions
	 */
	public ItemOptions getItemOptions() {
		return itemOptions;
	}

	/**
	 * @param itemOptions the itemOptions to set
	 */
	public void setItemOptions(ItemOptions itemOptions) {
		this.itemOptions = itemOptions;
	}



	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return the expiredOn
	 */
	public Date getExpiredOn() {
		return expiredOn;
	}

	/**
	 * @param expiredOn
	 *            the expiredOn to set
	 */
	public void setExpiredOn(Date expiredOn) {
		this.expiredOn = expiredOn;
	}

	/**
	 * @return the cretedOn
	 */
	public Date getCretedOn() {
		return cretedOn;
	}

	/**
	 * @param cretedOn
	 *            the cretedOn to set
	 */
	public void setCretedOn(Date cretedOn) {
		this.cretedOn = cretedOn;
	}

}
