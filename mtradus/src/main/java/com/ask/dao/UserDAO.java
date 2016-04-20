/**
 * 
 */
package com.ask.dao;

import com.ask.dbpojo.User;
import com.ask.pojo.UserPojo;

/**
 * @author 298651
 *
 */

public interface UserDAO {
	
	public User getUserData(UserPojo pojo);
	
	public User getUserData(String userName,String password);

	public User getUserDataByName(String userName);

	public boolean addUser(User user);

}
