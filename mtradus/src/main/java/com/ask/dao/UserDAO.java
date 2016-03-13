/**
 * 
 */
package com.ask.mtradus.dao;

import com.ask.mtradus.dbpojo.User;
import com.ask.mtradus.pojo.UserPojo;

/**
 * @author 298651
 *
 */

public interface UserDAO {
	
	public User getUserData(UserPojo pojo);

	public User getUserDataByName(String userName);

	public boolean addUser(User user);

}
