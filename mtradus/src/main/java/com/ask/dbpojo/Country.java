package com.ask.dbpojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COUNTRY")
public class Country {
	
	@Id
	int countryID;


	@Column(name = "COUNTRY_NAME")
	String countryName;


	public int getCountryID() {
		return countryID;
	}


	public void setCountryID(int countryID) {
		this.countryID = countryID;
	}


	public String getCountryName() {
		return countryName;
	}


	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	
	
}
