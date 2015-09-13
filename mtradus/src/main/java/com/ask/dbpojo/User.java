/**
 * 
 */
package com.ask.dbpojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author ASK
 * 
 */
@Entity
@Table(name = "USER")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6308226098632190416L;

	@Id
	int userId;

	@Column(name = "USER_NAME", nullable = false)
	String userName;

	@Column(name = "USER_PASSWORD", nullable = false)
	String password;

	@Column(name = "DOB", nullable = false)
	Date dateOfBirth;

	@Column(name = "USER_EMAIL_ADDRESS", nullable = false)
	String emailAddress;

	@Column(name = "USER_PHONE_NUMBER", nullable = false)
	String phoneNumber;

	@Column(name = "USER_COUNTRY")
	String country;

	@Column(name = "USER_STATE")
	String state;

	@Column(name = "USER_DISTRICT")
	String district;

	@Column(name = "USER_ADDRESS")
	String Address;

	
	@Temporal(TemporalType.DATE)
	@Column(name = "USER_CREATED_ON", nullable = false)
	Date createdOn;

	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_UPDATED_ON", nullable = false)
	Date updatedOn;

	@Column(name = "CREATED_BY")
	String createdBy;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "USER_TYPE_ID")
	UserType type;
	
	@Column(name="SUPERVISOR_ID")
	int superVisorID;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
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

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public int getSuperVisorID() {
		return superVisorID;
	}

	public void setSuperVisorID(int superVisorID) {
		this.superVisorID = superVisorID;
	}

	
}
