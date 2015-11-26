/**
 * 
 */
package com.ask.mtradus.dbpojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

	@ManyToOne
	ProductCategoryDetails productDetails;

	@OneToMany
	ProductItemDetails productItemDetails;

	@Column(name = "status")
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

	public ProductCategoryDetails getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(ProductCategoryDetails productDetails) {
		this.productDetails = productDetails;
	}

	public ProductItemDetails getProductItemDetails() {
		return productItemDetails;
	}

	public void setProductItemDetails(ProductItemDetails productItemDetails) {
		this.productItemDetails = productItemDetails;
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

}
