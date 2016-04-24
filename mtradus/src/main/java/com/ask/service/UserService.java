/**
 * 
 */
package com.ask.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.ask.dao.UserDAO;
import com.ask.dbpojo.User;
import com.ask.dbpojo.UserRoles;
import com.ask.exception.BusinessException;
import com.ask.pojo.UserPojo;
import com.ask.process.UserDataProcess;
import com.ask.util.UserConstants;

/**
 * @author ASK
 *
 */

@Service
public class UserService {

	@Autowired
	UserDAO userDao;

	@Autowired
	UserDataProcess userDataProcess;

	public UserDataProcess getUserDataProcess() {
		return userDataProcess;
	}

	public void setUserDataProcess(UserDataProcess userDataProcess) {
		this.userDataProcess = userDataProcess;
	}

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	/**
	 * 
	 * @param pojo
	 * @return
	 */
	public User getUser(UserPojo pojo) {
		return userDao.getUserData(pojo);
	}

	/**
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public UserPojo getUser(String userName, String password) throws BusinessException {
		User user = userDao.getUserData(userName, password);
		if (user == null) {
			throw new BusinessException(UserConstants.INVALID_USER_CREDENTAILS);
		}
		UserPojo userPojo = userDataProcess.copyToResponseUserObject(user, null);
		return userPojo;
	}

	
	public void getRoleList(User user) {

	}
	/**
	 * 
	 * @param userPojo
	 * @return
	 */
	public boolean addUser(UserPojo userPojo) throws BusinessException {
		boolean isUserAdded = false;
		User user = null;
		try {
			if (userDao.getUserDataByName(userPojo.getUserName()) != null) {
				throw new BusinessException(UserConstants.USER_NOT_FOUND);
			}
			user = userDataProcess.copyFromResponseUserData(userPojo, null);
			user.setCreatedOn(new Date());
			user.setUpdatedOn(new Date());
			user.setAttempts(0);
			user.setStatus("ACTIVE");
			UserRoles userRole = new UserRoles();
			userRole.setRoleName("ROLE_USER");
			userRole.setCreatedOn(new Date());
			userRole.setUpdatedOn(new Date());
			user.setUserRole(userRole);
			isUserAdded = userDao.addUser(user);
		} catch (BusinessException businessException) {
			throw new BusinessException(businessException.getMessageKey());
		}
		return isUserAdded;
	}

	public Authentication getUserAuthentication(UserPojo user) {
		// TODO Auto-generated method stub
		List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
		grantedAuths.add(new SimpleGrantedAuthority(user.getUserRole()));
		Authentication auth = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword(), grantedAuths);
		return auth;
	}
}
