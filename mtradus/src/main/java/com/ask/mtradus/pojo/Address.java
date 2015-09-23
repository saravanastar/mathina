/**
 * 
 */
package com.ask.mtradus.pojo;

import java.io.Serializable;

/**
 * @author sarav
 *
 */
public class Address implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7139529345208608087L;
	
	private int addressId;

	private String addressLine1;
	
	private String addressLinee2;
	
	private String area;
	
	private String district;
	
	private String state;
	
	private String country;

	
	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLinee2() {
		return addressLinee2;
	}

	public void setAddressLinee2(String addressLinee2) {
		this.addressLinee2 = addressLinee2;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
