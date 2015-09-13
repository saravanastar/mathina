/**
 * 
 */
package com.ask.dbpojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="SHOP_BILLDETAILS")
public class ShopBillDetails implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7664154254307083506L;


	@Id
//	@GeneratedValue
	int id;
	
	@Column(name="BILL_ID",nullable=false)
	int billID;
	
	@ManyToOne
	Shops shop;
	
	@ManyToOne
	VendorProductItemDetails productItemDetails;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DELIVERY_DATE", nullable = false)
	Date deliveryDate;
	
	@Column(name="QUANTITY_DELIVERED")
	int quantityDelivered;
	
	@Column(name="BILL_AMOUNT")
	int billAmount;
	
	@Column(name="LAST_UPDATED_BY")
	String lastUpdatedBy;

	public String toString(){
		return "id:"+this.id+"billID:"+"";
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBillID() {
		return billID;
	}

	public void setBillID(int billID) {
		this.billID = billID;
	}

	public Shops getShop() {
		return shop;
	}

	public void setShop(Shops shop) {
		this.shop = shop;
	}

	public VendorProductItemDetails getProductItemDetails() {
		return productItemDetails;
	}

	public void setProductItemDetails(VendorProductItemDetails productItemDetails) {
		this.productItemDetails = productItemDetails;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public int getQuantityDelivered() {
		return quantityDelivered;
	}

	public void setQuantityDelivered(int quantityDelivered) {
		this.quantityDelivered = quantityDelivered;
	}

	public int getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(int billAmount) {
		this.billAmount = billAmount;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	
	
	}
