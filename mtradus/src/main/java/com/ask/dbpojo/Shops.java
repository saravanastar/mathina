/**
 * 
 */
package com.ask.dbpojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author 298651
 *
 */
@Entity
@Table(name="SHOP_DETAILS")
public class Shops implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7432908889106089199L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="SHOP_ID", nullable = false)
	int shopID;
	
	@Column(name="SHOP_NAME", nullable = false)
	String shopName;
	
	@ManyToOne
	Address address;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="USER_ID")
	User user;
	

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_ON", nullable = false)
	Date createdOn;


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public int getShopID() {
		return shopID;
	}


	public void setShopID(int shopID) {
		this.shopID = shopID;
	}


	public String getShopName() {
		return shopName;
	}


	public void setShopName(String shopName) {
		this.shopName = shopName;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Date getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	
	
	
}
