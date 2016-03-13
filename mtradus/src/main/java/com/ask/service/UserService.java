/**
 * 
 */
package com.ask.mtradus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ask.mtradus.dao.UserDAO;
import com.ask.mtradus.dbpojo.User;
import com.ask.mtradus.exception.BusinessException;
import com.ask.mtradus.pojo.UserPojo;
import com.ask.mtradus.process.UserDataProcess;
import com.ask.mtradus.util.UserConstants;

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

	public User getUser(UserPojo pojo) {
		return userDao.getUserData(pojo);
	}

	/**
	 * 
	 * @param userPojo
	 * @return
	 */
	public boolean addUser(UserPojo userPojo) {
		boolean isUserAdded = false;
		if (userDao.getUserDataByName(userPojo.getUserName()) != null) {
			throw new BusinessException(UserConstants.USER_NOT_FOUND);
		}
		User user = userDataProcess.copyObject(userPojo, null);
		isUserAdded = userDao.addUser(user);
		return isUserAdded;
	}
}
