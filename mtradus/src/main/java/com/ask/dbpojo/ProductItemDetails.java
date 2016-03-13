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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author 298651
 *
 */
@Entity
@Table(name = "PRODUCT_ITEM_DETAILS")
public class ProductItemDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6777829137470785723L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int itemId;

	@ManyToOne
	ProductOptions productOptions;

	@OneToOne
	private ItemCostDetails itemCostDetails;

	@Column(name = "status")
	private boolean status;

	@Temporal(TemporalType.DATE)
	@Column(name = "EXPIRED_ON", nullable = false)
	Date expiredOn;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_ON", nullable = false)
	Date cretedOn;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public ProductOptions getProductOptions() {
		return productOptions;
	}

	public void setProductOptions(ProductOptions productOptions) {
		this.productOptions = productOptions;
	}

	public ItemCostDetails getItemCostDetails() {
		return itemCostDetails;
	}

	public void setItemCostDetails(ItemCostDetails itemCostDetails) {
		this.itemCostDetails = itemCostDetails;
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
