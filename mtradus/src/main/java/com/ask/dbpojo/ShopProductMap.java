package com.ask.mtradus.dbpojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author ASK
 *
 */
@Entity
@Table(name="SHOP_PRODUCT_MAP")
public class ShopProductMap implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7690860434271659434L;

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@ManyToOne
//	@JoinColumn(name="PRODUCT_ID")
	ProductItemDetails vendorItemProduct;
	
	@ManyToOne
//	@JoinColumn(name="SHOP_ID")
	Shops shop;
	
	@Column(name="PRODUCT_COST")
	int productCost;

	@Column(name="PERCENTAGE")
	int percentage;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ProductItemDetails getVendorItemProduct() {
		return vendorItemProduct;
	}

	public void setVendorItemProduct(ProductItemDetails vendorItemProduct) {
		this.vendorItemProduct = vendorItemProduct;
	}

	public Shops getShop() {
		return shop;
	}

	public void setShop(Shops shop) {
		this.shop = shop;
	}

	public int getProductCost() {
		return productCost;
	}

	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

			
}
