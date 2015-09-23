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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author 298651
 * 
 */
@Entity
@Table(name = "VENDOR_DETAILS")
public class VendorDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7447539658702815472L;

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	@Column(name = "VENDOR_ID")
	private int vendorId;

	@Column(name = "VENDOR_NAME")
	private String vendorName;

	@Column(name = "VENDOR_STATUS")
	private boolean status;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_ON", nullable = false)
	private Date createdOn;

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	
}
