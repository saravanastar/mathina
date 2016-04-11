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
	 * @param src
	 * @param dest
	 * @return
	 */
	public User copyObject(UserPojo src, User dest) {
		if (dest == null)
			dest = new User();
		BeanUtils.copyProperties(src, dest);
		dest.setDateOfBirth(CommonObjectMethods.convertStringToDate(src
				.getDateofBirth()));
		dest.setCreatedOn(new Date());
		dest.setUpdatedOn(new Date());
		Address address = copyAddressDetails(src);
		dest.setAttempts(0);
		dest.setStatus("ACTIVE");
		dest.setAddress(address);
		return dest;

	}

	/**
	 * 
	 * @param src
	 * @return
	 */
	private Address copyAddressDetails(UserPojo src) {
		Address address = new Address();
		address.setAddressLine1(src.getAddress().getAddressLine1());
		address.setAddressLine2(src.getAddress().getAddressLinee2());
		address.setAreaName((src.getAddress().getArea()));
		return address;
	}

	/**
	 * 
	 * @param src
	 * @param dest
	 * @return
	 */
	public UserPojo copyObject(User src, UserPojo dest) {
		return dest;

	}

}
