/**
 * 
 */
package com.ask.mtradus.dbpojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 298651
 * 
 */

@Entity
@Table(name = "USER_TYPE")
public class UserType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3615387256567590608L;

	@Id
	int id;

	@Column(name = "USER_TYPE_NAME")
	String userType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
