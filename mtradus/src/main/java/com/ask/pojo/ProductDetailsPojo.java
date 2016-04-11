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
public class ProductDetailsPojo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8407265179182626914L;

	int id;

	private String description;
	
	private String name;

	private boolean status;

	private Date expiredOn;

	private Date cretedOn;
	
	private List<ProductCategoryDetailsPojo> categoryDetails;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public List<ProductCategoryDetailsPojo> getCategoryDetails() {
		return categoryDetails;
	}

	public void setCategoryDetails(List<ProductCategoryDetailsPojo> categoryDetails) {
		this.categoryDetails = categoryDetails;
	}

	
}
