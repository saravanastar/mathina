/**
 * 
 */
package com.ask.dbpojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author 298651
 *
 */

@Entity
@Table(name="STATES")
public class States implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -483233842776501482L;

	@Id
	int stateID;

	@ManyToOne
	@JoinColumn(name = "COUNTRY_ID")
	Country country;

	@Column(name = "STATE_NAME")
	String stateName;

	public int getStateID() {
		return stateID;
	}

	public void setStateID(int stateID) {
		this.stateID = stateID;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	
	
}
