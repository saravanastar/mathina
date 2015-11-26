/**
 * 
 */
package com.ask.mtradus.dbpojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author 298651
 * 
 */
@Entity
@Table(name = "VENDOR_DETAILS")
public class VendorDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7447539658702815472L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "VENDOR_ID")
	private int vendorId;

	@Column(name = "VENDOR_NAME")
	private String vendorName;

	@OneToMany
	private List<ProductCategoryDetails> vendorDetails;

	@Column(name = "IMAGE_LINK")
	private String imageLink;

	@Column(name = "ACTIVE_STATUS")
	private boolean active;

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

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public List<ProductCategoryDetails> getVendorDetails() {
		return vendorDetails;
	}

	public void setVendorDetails(List<ProductCategoryDetails> vendorDetails) {
		this.vendorDetails = vendorDetails;
	}

}
