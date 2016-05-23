/**
 * 
 */
package com.ask.dbpojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author 298651
 * 
 */
@Entity
@Table(name = "VENDOR_CATEGORY_DETAILS")
public class ProductCategoryDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2792048758471944077L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CAT_ID")
	int categoryId;
	
	@Column(name = "PRODUCT_ID", nullable = false)
	int productId;

	@ManyToOne
	@JoinColumn(name = "VENDOR_ID")
	VendorDetails vendorDetails;
	
	@OneToMany
	List<ProductItemDetails> productItemDetails;

	@Column(name = "CATEGORY_NAME")
	String categoryName;

	
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_ON", nullable = false)
	Date cretedOn;

	@Column(name = "IMAGE_LINK")
	private String imageLink;
	
	

	/**
	 * @return the imageLink
	 */
	public String getImageLink() {
		return imageLink;
	}


	/**
	 * @param imageLink the imageLink to set
	 */
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public VendorDetails getVendorDetails() {
		return vendorDetails;
	}


	public void setVendorDetails(VendorDetails vendorDetails) {
		this.vendorDetails = vendorDetails;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public Date getCretedOn() {
		return cretedOn;
	}


	public void setCretedOn(Date cretedOn) {
		this.cretedOn = cretedOn;
	}


	public List<ProductItemDetails> getProductItemDetails() {
		return productItemDetails;
	}


	public void setProductItemDetails(List<ProductItemDetails> productItemDetails) {
		this.productItemDetails = productItemDetails;
	}


	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}


	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	
}
