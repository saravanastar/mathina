/**
 * 
 */
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
 * @author 298651
 * 
 */
@Entity
@Table(name = "DISTRICT")
public class District implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5612744760453923578L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int districtID;

	@ManyToOne
	States state;

	@Column(name = "DISTRICT_NAME")
	String districtName;
	
	@Column(name= "DISTRICT_CODE")
	private String districtCode;

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public int getDistrictID() {
		return districtID;
	}

	public void setDistrictID(int districtID) {
		this.districtID = districtID;
	}

	public States getState() {
		return state;
	}

	public void setState(States state) {
		this.state = state;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

}
