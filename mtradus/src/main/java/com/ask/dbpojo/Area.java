/**
 * 
 */
package com.ask.mtradus.dbpojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author 298651
 * 
 */
@Entity
@Table(name = "AREA")
public class Area implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9055570602824528287L;

	@Id
	int areaId;

	@ManyToOne(fetch = FetchType.EAGER)
	District district;

	@Column(name = "AREA_NAME")
	String areaName;

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

}
