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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author ASK
 *
 */
/**
 * @author ASK
 *
 */
@Entity
@Table(name = "PRODUCT_DETAILS")
public class ProductDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 440273232869839452L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int productId;

	@OneToMany
	List<ProductCategoryDetails> productCategoryDetails;

	@Column(name = "PRODUCT_NAME")
	private String productName;
	
	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "STATUS")
	private boolean status;

	@Temporal(TemporalType.DATE)
	@Column(name = "EXPIRED_ON", nullable = false)
	Date expiredOn;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_ON", nullable = false)
	Date cretedOn;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public List<ProductCategoryDetails> getProductCategoryDetails() {
		return productCategoryDetails;
	}

	public void setProductCategoryDetails(List<ProductCategoryDetails> productCategoryDetails) {
		this.productCategoryDetails = productCategoryDetails;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getExpiredOn() {
		return expiredOn;
	}

	public void setExpiredOn(Date expiredOn) {
		this.expiredOn = expiredOn;
	}

	public Date getCretedOn() {
		return cretedOn;
	}

	public void setCretedOn(Date cretedOn) {
		this.cretedOn = cretedOn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
}
