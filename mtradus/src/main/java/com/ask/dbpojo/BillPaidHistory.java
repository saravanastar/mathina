package com.ask.dbpojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "BILL_PAID_HISTORY")
public class BillPaidHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8026443584284857737L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@Column(name="BILL_ID",nullable=false)
	int billID;

	@Column(name = "AMOUNT_PAID")
	int amountPaid;
	
	@ManyToOne
	Shops shop;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "PAID_ON", nullable = false)
	Date paidOn;
	
	

	public Shops getShop() {
		return shop;
	}

	public void setShop(Shops shop) {
		this.shop = shop;
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

	public Date getPaidOn() {
		return paidOn;
	}

	public void setPaidOn(Date paidOn) {
		this.paidOn = paidOn;
	}

	
	
	}
