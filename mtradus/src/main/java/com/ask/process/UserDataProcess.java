/**
 * 
 */
package com.ask.process;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ask.dao.AddressDAO;
import com.ask.dbpojo.Address;
import com.ask.dbpojo.User;
import com.ask.exception.BusinessException;
import com.ask.pojo.AddressPojo;
import com.ask.pojo.UserPojo;
import com.ask.util.CommonObjectMethods;

/**
 * @author ASK
 *
 */
@Component
public class UserDataProcess {

	@Autowired
	AddressDAO addressDAO;

	public AddressDAO getAddressDAO() {
		return addressDAO;
	}

	public void setAddressDAO(AddressDAO addressDAO) {
		this.addressDAO = addressDAO;
	}

	/**
	 * Copies request payload to the db object.
	 * 
	 * @param userPojo
	 * @param userPersistanceObject
	 * @return
	 */
	public User copyFromResponseUserData(UserPojo userPojo, User userPersistanceObject) throws BusinessException {
		try {
			if (userPersistanceObject == null) {
				userPersistanceObject = new User();
			}
			BeanUtils.copyProperties(userPojo, userPersistanceObject);
			userPersistanceObject.setDateOfBirth(CommonObjectMethods.convertStringToDate(userPojo.getDateOfBirth()));
//			userPersistanceObject.setCreatedOn(new Date());
//			userPersistanceObject.setUpdatedOn(new Date());
			Address address = copyFromResposneAddressDetails(userPojo);
			userPersistanceObject.setAttempts(userPojo.getUserAttempts());
			userPersistanceObject.setStatus(userPojo.getStatus());
			userPersistanceObject.setAddress(address);
		} catch (BusinessException businessException) {
			throw new BusinessException(businessException.getMessageKey());
		}
		return userPersistanceObject;

	}

	/**
	 * 
	 * @param userPojo
	 * @return
	 */
	private Address copyFromResposneAddressDetails(UserPojo userPojo) {
		Address address = new Address();
		address.setAddressLine1(userPojo.getAddress().getAddressLine1());
		address.setAddressLine2(userPojo.getAddress().getAddressLinee2());
		address.setAreaName((userPojo.getAddress().getArea()));
		address.setCreatedOn(new Date());
		address.setUpdatedOn(new Date());
		return address;
	}

	/**
	 * 
	 * @param src
	 * @param userPojo
	 * @return
	 */
	public UserPojo copyToResponseUserObject(User userPersistanceObject, UserPojo userPojo) {
		try {
			if (userPojo == null) {
				userPojo = new UserPojo();
			}
			BeanUtils.copyProperties(userPersistanceObject, userPojo);
			userPojo.setDateOfBirth(CommonObjectMethods.convertDateToString(userPersistanceObject.getDateOfBirth()));
			userPojo.setUserAttempts(userPersistanceObject.getAttempts());
			userPojo.setStatus(userPersistanceObject.getStatus());
			userPojo.setAddress(copyToResponseAddressObject(userPersistanceObject));
			userPojo.setUserRole(userPersistanceObject.getUserRole().getRoleName());
		} catch (BusinessException businessException) {
			throw new BusinessException(businessException.getMessageKey());
		}
		return userPojo;

	}

	public AddressPojo copyToResponseAddressObject(User userPersistanceObject) {
		AddressPojo addressPojo = new AddressPojo();
		Address address = userPersistanceObject.getAddress();
		BeanUtils.copyProperties(address, addressPojo);
		return addressPojo;
	}

}
