/**
 * 
 */
package com.ask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ask.dao.UserDAO;
import com.ask.dao.UserDAOImpl;
import com.ask.dbpojo.User;
import com.ask.exception.BusinessException;
import com.ask.pojo.UserPojo;
import com.ask.util.UserConstants;

/**
 * @author ASK
 *
 */

@Service
public class UserService {
	
	@Autowired
	UserDAO userDao;

	
	
	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	@Transactional
	public boolean addDefaultData(){
		return userDao.addDefaultData();
	}
	
	public User getUser(UserPojo pojo){
		return userDao.getUserData(pojo);
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public boolean addUser(User user) {
		boolean isUserAdded = false;
		if(userDao.getUserDataByName(user.getUserName()) == null) {
			throw new BusinessException(UserConstants.USER_NOT_FOUND);
		}
		isUserAdded = userDao.addUser(user);
		return isUserAdded;
	}
}
