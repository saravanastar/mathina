package com.ask.pojo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class UserPojo {

	private String userName;
	@NotNull
	@Min(13)
	private String password;
	

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

}
