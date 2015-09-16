/**
 * 
 */
package com.ask.dbpojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author sarav
 *
 */
@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2287945503704055409L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "area_id", nullable = false)
	@ManyToOne
	private Area area;

	@Column(name = "ADDRESS1")
	private String addressLine1;

	@Column(name = "ADDRESS2")
	private String addressLine2;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_ON", nullable = false)
	private Date createdOn;

	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_UPDATED_ON", nullable = false)
	private Date updatedOn;

	@Column(name = "CREATED_BY")
	private String createdBy;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
