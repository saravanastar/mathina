/**
 * 
 */
package com.ask.mtradus.dbpojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * @author ASK
 *
 */
@Entity
@Table(name="STOCK_MAINTANENCE")
public class StockMaintanence implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4126434190904665958L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	int id;
	
	@OneToOne(fetch = FetchType.LAZY)
	ProductItemDetails itemDetails;
	
	@OneToOne(fetch = FetchType.LAZY)
	@NotFound(action=NotFoundAction.IGNORE)
	Discount discount;
	
	@Column(name = "STOCK_QUQNTITY")
	int quantity;
	
	@Column(name = "DISCOUNT_QUANTITY")
	int discountQuantity;
	
	@Column(name="DISCOUNT_STATUS")
	String discountStatus;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_UPDATED_ON")
	Date lastUpdatedOn;
	
	@Column(name="LAST_UPDATED_BY")
	String lastUpdatedBy;

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

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getDiscountQuantity() {
		return discountQuantity;
	}

	public void setDiscountQuantity(int discountQuantity) {
		this.discountQuantity = discountQuantity;
	}

	public String getDiscountStatus() {
		return discountStatus;
	}

	public void setDiscountStatus(String discountStatus) {
		this.discountStatus = discountStatus;
	}

	public Date getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(Date lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	
	
	
}
