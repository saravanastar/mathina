/**
 * 
 */
package com.ask.dbpojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private int id;

	@Column(name = "VENDOR_NAME")
	private String vendorName;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "vendorId")
	private List<ProductDetails> productDetails;

	@Column(name = "IMAGE_LINK")
	private String imageLink;

	@Column(name = "ACTIVE_STATUS")
	private boolean active;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_ON", nullable = false)
	private Date createdOn;

	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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

	public List<ProductDetails> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(List<ProductDetails> productDetails) {
		this.productDetails = productDetails;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}


}
