/**
 * 
 */
package com.ask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ask.dao.AddressDAO;

/**
 * @author ASK
 *
 */
@Service
public class AddressService {

	@Autowired
	AddressDAO addressDAO;

	public AddressDAO getAddressDAO() {
		return addressDAO;
	}

	public void setAddressDAO(AddressDAO addressDAO) {
		this.addressDAO = addressDAO;
	}
	
	public Object getAddressDetailsById(String id, String type) {
		switch(type) {
		
		}
		return addressDAO;
		
	}
}
