/**
 * 
 */
package com.ask.mtradus.dbpojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author ASK
 * 
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6308226098632190416L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	@Column(name = "USER_NAME", nullable = false)
	private String userName;

	@Column(name = "USER_PASSWORD", nullable = false)
	private String password;

	@Column(name = "DOB", nullable = false)
	private Date dateOfBirth;

	@Column(name = "USER_EMAIL_ADDRESS", nullable = false)
	private String emailAddress;

	@Column(name = "USER_PHONE_NUMBER", nullable = false)
	private String phoneNumber;

	@Column(name = "ADDRESS_ID")
	private Address address;

	@Temporal(TemporalType.DATE)
	@Column(name = "USER_CREATED_ON", nullable = false)
	private Date createdOn;

	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_UPDATED_ON", nullable = false)
	private Date updatedOn;

	@Column(name = "CREATED_BY")
	private String createdBy;

/*	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "USER_TYPE_ID")
	private UserType type;*/

	@Column(name = "SUPERVISOR_ID")
	private int superVisorID;

	@Column(name = "attempts")
	private int attempts;

	@Column(name = "status")
	private String status;

	@Column(name = "image")
	private String imagePath;

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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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

	public int getSuperVisorID() {
		return superVisorID;
	}

	public void setSuperVisorID(int superVisorID) {
		this.superVisorID = superVisorID;
	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	
}
