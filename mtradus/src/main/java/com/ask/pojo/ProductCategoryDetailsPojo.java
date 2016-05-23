/**
 * 
 */
package com.ask.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author ASK
 *
 */
public class ProductCategoryDetailsPojo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 858069248949586976L;
	/**
	 * 
	 */
	private int categoryId;
	private int productId;
	private String categoryName;
	private Date cretedOn;
	private List<ItemDetailsPojo> items;
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
	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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
	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/**
	 * @return the cretedOn
	 */
	public Date getCretedOn() {
		return cretedOn;
	}
	/**
	 * @param cretedOn the cretedOn to set
	 */
	public void setCretedOn(Date cretedOn) {
		this.cretedOn = cretedOn;
	}
	/**
	 * @return the items
	 */
	public List<ItemDetailsPojo> getItems() {
		return items;
	}
	/**
	 * @param items the items to set
	 */
	public void setItems(List<ItemDetailsPojo> items) {
		this.items = items;
	}

}
