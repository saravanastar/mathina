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
@Table(name = "STATES")
public class States implements Serializable, RootPojo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -483233842776501482L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stateID;

	@ManyToOne
	private Country country;

	@Column(name = "STATE_NAME")
	private String stateName;

	@Column(name = "STATE_CODE")
	private String stateCode;

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
