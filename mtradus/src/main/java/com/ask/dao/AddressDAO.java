/**
 * 
 */
package com.ask.mtradus.dao;

import java.util.List;

import com.ask.mtradus.dbpojo.Address;
import com.ask.mtradus.dbpojo.Country;
import com.ask.mtradus.dbpojo.District;
import com.ask.mtradus.dbpojo.States;

/**
 * @author ASK
 *
 */
public interface AddressDAO {
	public List<Country> getCountries();

	public List<States> getStates();

	public List<District> getDistricts();

	public Country getCountryById(int id);

	public States getStateById(int id);

	public District getDistrictById(int id);

	public Country getCountryByName(String countryName);

	public States getStateByName(String stateName);

	public District getDistrictByName(String districtName);

	public Address getAddressDetailsById(int addressId);

	public boolean addCountry(Country country);

	public void removeCountryDetails(String countryId);

	public boolean addState(States state);

	public void removeStateDetails(String stateId);

	public void removeDistrictDetails(String districtID);

	public boolean addDistrict(District district);

	public boolean addAddressDetails(Address address);

	public void removeAddressDetails(String addressId);
}
