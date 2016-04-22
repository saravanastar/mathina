/**
 * 
 */
package com.ask.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.ask.constn.CommonConstants;
import com.ask.exception.BusinessException;
import com.ask.pojo.UserPojo;
import com.ask.service.UserService;

/**
 * @author ASK
 *
 */
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	UserService userSerice;

	/**
	 * @return the userSerice
	 */
	public UserService getUserSerice() {
		return userSerice;
	}

	/**
	 * @param userSerice
	 *            the userSerice to set
	 */
	public void setUserSerice(UserService userSerice) {
		this.userSerice = userSerice;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userName = authentication.getName();
		String password = (String) authentication.getCredentials();

		UserPojo user = userSerice.getUser(userName, password);
		if (user == null || !user.getUserName().equalsIgnoreCase(userName)) {
			throw new BusinessException(CommonConstants.USER_NAME_NOT_FOUND);
		}
		return userSerice.getUserAuthentication(user);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
