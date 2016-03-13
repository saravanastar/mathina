/**
 * 
 */
package com.ask.mtradus.dbpojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author ASK
 *
 */
@Entity
@Table(name="VENDOR_PAY_HISTORY")
public class VendorPaymentHistory {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	VendorBill bill;
	
	@Column(name = "AMOUNT_PAID")
	private int amountPaid;
	
	@Column(name = "PAYMENT_TYPE")
	private String paymentType;
	
	@Column(name = "CARD_NUMBER")
	private long cardNumber;
	
	@Column(name = "RECEIPT_NUMBER")
	private String receiptNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public VendorBill getBill() {
		return bill;
	}

	public void setBill(VendorBill bill) {
		this.bill = bill;
	}

	public int getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getReceiptNumber() {
		return receiptNumber;
	}

	public void setReceiptNumber(String receiptNumber) {
		this.receiptNumber = receiptNumber;
	}
	
}
