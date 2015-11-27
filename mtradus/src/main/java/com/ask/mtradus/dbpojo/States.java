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
public class States implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -483233842776501482L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stateId;

	@ManyToOne
	private Country country;

	@Column(name = "STATE_NAME")
	private String stateName;

	@Column(name = "STATE_CODE")
	private String stateCode;


	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
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
