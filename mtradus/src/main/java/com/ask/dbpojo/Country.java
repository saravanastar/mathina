package com.ask.dbpojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRY")
public class Country implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3784928094387828150L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int countryId;

	@Column(name = "COUNTRY_NAME")
	private String countryName;

	@Column(name = "COUNTRY_CODE")
	private String countryCode;

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}
