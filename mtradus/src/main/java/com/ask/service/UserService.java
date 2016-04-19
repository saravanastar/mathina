/**
 * 
 */
package com.ask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ask.dao.UserDAO;
import com.ask.dbpojo.User;
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

	public User getUser(UserPojo pojo) {
		return userDao.getUserData(pojo);
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
			user = userDataProcess.copyObject(userPojo, null);
			isUserAdded = userDao.addUser(user);
		} catch (BusinessException businessException) {
			throw new BusinessException(businessException.getMessageKey());
		}
		return isUserAdded;
	}
}
