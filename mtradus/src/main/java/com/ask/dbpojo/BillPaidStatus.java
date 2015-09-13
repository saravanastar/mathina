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
 * 
 * @author ASK
 *
 */
@Entity
@Table(name = "BILL_PAID_STATUS")
public class BillPaidStatus implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8026443584284857737L;

	@Id
//	@GeneratedValue
	int id;
	
	@Column(name="BILL_ID",nullable=false)
	int billID;
	
	@ManyToOne
	Shops shop;
	
	@Column(name="BILL_AMOUNT")
	int billAmount;
	
	@Column(name="LAST_AMOUNT_PAID")
	int amountPaid;
	
	@Column(name="REMAINING_AMOUNT")
	int remainingAmount;
	
	@Column(name="DISCOUNT_AMOUNT")
	int discountAmount;
	
	@Column(name="STATUS")
	String status;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_PAID_ON")
	Date paidOn;

	
	public int getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(int discountAmount) {
		this.discountAmount = discountAmount;
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

	public int getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}

	public int getRemainingAmount() {
		return remainingAmount;
	}

	public void setRemainingAmount(int remainingAmount) {
		this.remainingAmount = remainingAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getPaidOn() {
		return paidOn;
	}

	public void setPaidOn(Date paidOn) {
		this.paidOn = paidOn;
	}

	public int getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(int billAmount) {
		this.billAmount = billAmount;
	}

	public Shops getShop() {
		return shop;
	}

	public void setShop(Shops shop) {
		this.shop = shop;
	}

	
	
	
}
