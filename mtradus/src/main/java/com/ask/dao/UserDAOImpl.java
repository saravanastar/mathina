/**
 * 
 */
package com.ask.dao;

import org.hibernate.PropertyValueException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ask.constn.CommonConstants;
import com.ask.dbpojo.User;
import com.ask.exception.BusinessException;
import com.ask.pojo.UserPojo;

/**
 * @author 298651
 *
 */
@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	/**
	 * get the user data based on username and password.
	 * @param pojo
	 */
	public User getUserData(UserPojo pojo) {
		Session session = template.getSessionFactory().openSession();
		Query query = session.createQuery("from User where userName = :id and password=:password");
		query.setParameter("id", pojo.getUserName());
		query.setParameter("password", pojo.getPassword());
		User user = (User) query.uniqueResult();
		// = (User) session.get(User.class, pojo.getUserName());
		if (user == null)
			user = new User();
		// TODO Auto-generated method stub
		session.close();
		return user;
	}
	/**
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	@Transactional
	public User getUserData(String userName, String password) {
		Session session = template.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from User where userName = :id and password=:password");
		query.setParameter("id", userName);
		query.setParameter("password", password);
		User user = (User) query.uniqueResult();
		// = (User) session.get(User.class, pojo.getUserName());
		return user;
	}
	
	
	/**
	 * return the User data by username.
	 * @param userName
	 */
	public User getUserDataByName(String userName) {
		Session session = template.getSessionFactory().openSession();
		Query query = session.createQuery("from User where userName = :id");
		query.setParameter("id", userName);
		User user = (User) query.uniqueResult();
		session.close();
		return user;
	}
	
	/**
	 * Registering the new user.
	 * @param user
	 */
	@Transactional
	public boolean addUser(User user) {
		boolean isUserAdded = false;
		Session session = template.getSessionFactory().getCurrentSession();
		try {
			session.save(user.getUserRole());
			session.save(user.getAddress());
			session.save(user);
			isUserAdded = true;
		} catch(PropertyValueException propertyValueException){
			throw new BusinessException(CommonConstants.BAD_REQUEST);
		} catch(Exception e) {
			throw new BusinessException(CommonConstants.INTERNAL_SERVER_ERROR);
		}
		// TODO Auto-generated method stub
		return isUserAdded;
	}
	
/*	public UserType getUserType(String userType) {
		Session session = template.getSessionFactory().openSession();
		Query query = session.createQuery("from UserType where name=:userType");
		query.setString("userType", userType);
		UserType userTypeObj = (UserType)query.uniqueResult();
		return userTypeObj;
		
	}*/
}
