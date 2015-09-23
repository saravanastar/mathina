/**
 * 
 */
package com.ask.mtradus.dbpojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "VENDOR_PRODCUT_DETAILS")
public class VendorProductDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2792048758471944077L;

	@Id
//	@GeneratedValue
//	@Column(name = "PRODUCT_ID")
	int productId;

	@ManyToOne
	@JoinColumn(name = "VENDOR_ID")
	VendorDetails vendorDetails;

	@Column(name = "PRODUCT_NAME")
	String productName;

	
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_ON", nullable = false)
	Date cretedOn;


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public VendorDetails getVendorDetails() {
		return vendorDetails;
	}


	public void setVendorDetails(VendorDetails vendorDetails) {
		this.vendorDetails = vendorDetails;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public Date getCretedOn() {
		return cretedOn;
	}


	public void setCretedOn(Date cretedOn) {
		this.cretedOn = cretedOn;
	}

	
	
	
	
}
