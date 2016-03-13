/**
 * 
 */
package com.ask.mtradus.dbpojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author ASK
 *
 */
@Entity
@Table(name = "VENDOR_BILL_DETAILS")
public class VendorBillsDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@ManyToOne
	VendorBill vendorBill;

	@ManyToMany
	List<ProductItemDetails> productItemDetails;

	@Column(name = "quanity")
	int quantity;

	@Column(name = "price")
	double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<ProductItemDetails> getProductItemDetails() {
		return productItemDetails;
	}

	public void setProductItemDetails(
			List<ProductItemDetails> productItemDetails) {
		this.productItemDetails = productItemDetails;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public VendorBill getVendorBill() {
		return vendorBill;
	}

	public void setVendorBill(VendorBill vendorBill) {
		this.vendorBill = vendorBill;
	}

}
