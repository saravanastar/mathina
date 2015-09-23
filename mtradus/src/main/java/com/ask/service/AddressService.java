/**
 * 
 */
package com.ask.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ask.constn.UrlDetailsContants;
import com.ask.dao.AddressDAO;
import com.ask.dbpojo.Address;
import com.ask.dbpojo.Country;
import com.ask.dbpojo.District;
import com.ask.dbpojo.States;
import com.ask.exception.BusinessException;

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

	/**
	 * 
	 * @param id
	 * @param type
	 * @return
	 */
	public Object getAddressDetails(int id, String type) {
		Object object = null;
		switch (type) {
		case UrlDetailsContants.COUNTRY:
			if (id == 0) {
				object = addressDAO.getCountries();
			} else {
				object = addressDAO.getCountryById(id);
			}
			break;
		case UrlDetailsContants.STATE:
			if (id == 0) {
				object = addressDAO.getStates();
			} else {
				object = addressDAO.getStateById(id);
			}
			break;
		case UrlDetailsContants.DISTRICT:
			if (id == 0) {
				object = addressDAO.getDistricts();
			} else {
				object = addressDAO.getDistrictById(id);
			}
			break;
		case UrlDetailsContants.ADDRESS:
			if (id != 0) {
				object = addressDAO.getAddressDetailsById(id);
			}
			break;

		}
		return object;
	}

	/**
	 * 
	 * @param name
	 * @param type
	 * @return
	 */
	public Object getAddressDetailsByName(String name, String type) {
		Object object = null;
		switch (type) {
		case "country":
			if (name == null) {
				object = addressDAO.getCountries();
			} else {
				object = addressDAO.getCountryByName(name);
			}
			break;
		case "state":
			if (name == null) {
				object = addressDAO.getStates();
			} else {
				object = addressDAO.getStateByName(name);
			}
			break;
		case "district":
			if (name == null) {
				object = addressDAO.getDistricts();
			} else {
				object = addressDAO.getDistrictByName(name);
			}
			break;

		}
		return object;
	}

	public void addCountryDetails(Country country) {
		addressDAO.addCountry(country);
	}
	
	/**
	 * 
	 */
	public void updateCountryDetails(Country country, String countryId) {
		if (countryId == null) {
			throw new BusinessException();
		}
		country.setCountryID(Integer.parseInt(countryId));
		addressDAO.addCountry(country);
	}

	/**
	 * 
	 * @param countryId
	 */
	public void removeCountryDetails(String countryId) {
		if (countryId == null) {
			throw new BusinessException();
		}
		addressDAO.removeCountryDetails(countryId);
	}

	/**
	 * 
	 * @param state
	 */
	public void addStateDetails(States state) {
		if (state.getStateID() != 0 && state.getCountry().getCountryID() == 0) {
			throw new BusinessException();
		}
		addressDAO.addState(state);

	}

	/**
	 * 
	 * @param stateId
	 * @param state
	 */
	public void updateStateDetails(String stateId, States state) {
		// TODO Auto-generated method stub
		if (stateId == null) {
			throw new BusinessException();
		}
		state.setStateID(Integer.parseInt(stateId));
		addressDAO.addState(state);
	}
	
	public void removeStateDetails(String stateId) {
		if (stateId == null) {
			throw new BusinessException();
		}
		addressDAO.removeStateDetails(stateId);
	}
	
	public void removeDistrictDetails(String districtID) {
		if (districtID == null) {
			throw new BusinessException();
		}
		addressDAO.removeDistrictDetails(districtID);
	}

	public void addDistrictDetails(District district) {
		// TODO Auto-generated method stub
		
		if (district.getState().getStateID() != 0 && district.getState().getCountry().getCountryID() == 0) {
			throw new BusinessException();
		}
		addressDAO.addDistrict(district);
		
	}

	/**
	 * 
	 * @param districtId
	 * @param district
	 */
	public void updateDistrictDetails(String districtId, District district) {
		// TODO Auto-generated method stub
		if (districtId == null) {
			throw new BusinessException();
		}
		district.setDistrictID(Integer.parseInt(districtId));
		addressDAO.addDistrict(district);
		
	}

	public void addAddressDetails(Address address) {
		// TODO Auto-generated method stub
		address.setCreatedOn(new Date());
		address.setUpdatedOn(new Date());
		addressDAO.addAddressDetails(address);
		
	}

	public void updateAddressDetails(String addressId, Address address) {
		// TODO Auto-generated method stub
		if (addressId == null) {
			throw new BusinessException();
		}
		address.setId(Integer.parseInt(addressId));
		addressDAO.addAddressDetails(address);
		
	}

	public void removeAddressDetails(String addressId) {
		// TODO Auto-generated method stub
		if (addressId == null) {
			throw new BusinessException();
		}
		addressDAO.removeAddressDetails(addressId);
		
	}
}
