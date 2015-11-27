/**
 * 
 */
package com.ask.mtradus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ask.mtradus.constn.UrlDetailsContants;
import com.ask.mtradus.dbpojo.Address;
import com.ask.mtradus.dbpojo.Country;
import com.ask.mtradus.dbpojo.District;
import com.ask.mtradus.dbpojo.States;
import com.ask.mtradus.service.AddressService;

/**
 * @author ASK
 *
 */
@Controller
@RequestMapping("/location")
public class LocationController {

	@Autowired
	AddressService addressService;

	public AddressService getAddressService() {
		return addressService;
	}

	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/countries", method = RequestMethod.GET)
	@ResponseBody
	public List<Country> listCountries() {
		return (List<Country>) addressService.getAddressDetails(0,
				UrlDetailsContants.COUNTRY);
	}

	@RequestMapping(value = "/country/{countryId}", method = RequestMethod.GET)
	@ResponseBody
	public Country getCountryById(@PathVariable int countryId) {
		Country country = (Country) addressService.getAddressDetails(countryId, UrlDetailsContants.COUNTRY);
		return country;
	}

	@RequestMapping(value = "/country", method = RequestMethod.POST)
	@ResponseBody
	public void addCountry(@RequestBody Country country) {
		addressService.addCountryDetails(country);
		System.out.println("country" + country);

	}

	@RequestMapping(value = "/country/{countryId}", method = RequestMethod.PUT)
	@ResponseBody
	public void updateCountry(@RequestBody Country country,
			@PathVariable String countryId) {
		addressService.updateCountryDetails(country, countryId);

	}

	@RequestMapping(value = "/country/{countryId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteCountry(@PathVariable("countryId") String countryId) {
		addressService.removeCountryDetails(countryId);
	}

	@RequestMapping(value = "/states", method = RequestMethod.GET)
	@ResponseBody
	public List<States> listStates() {
		@SuppressWarnings("unchecked")
		List<States> stateList = (List<States>) addressService.getAddressDetails(0, UrlDetailsContants.STATE);
		return stateList;
	}

	@RequestMapping(value = "/state/{stateId}", method = RequestMethod.GET)
	@ResponseBody
	public States getState(@PathVariable int stateId) {
		States states = (States) addressService.getAddressDetails(stateId, UrlDetailsContants.STATE);
		return states;
	}

	@RequestMapping(value = "/state", method = RequestMethod.POST)
	@ResponseBody
	public void addState(@RequestBody States state) {
		addressService.addStateDetails(state);
	}

	@RequestMapping(value = "/state/{stateId}", method = RequestMethod.PUT)
	@ResponseBody
	public void udpateState(@RequestBody States state,
			@PathVariable String stateId) {
		addressService.updateStateDetails(stateId, state);
	}

	@RequestMapping(value = "/state/{stateId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteState(@PathVariable String stateId) {
		addressService.removeStateDetails(stateId);
	}
	
	@RequestMapping(value = "/districts", method = RequestMethod.GET)
	@ResponseBody
	public List<District> listDistricts() {
		@SuppressWarnings("unchecked")
		List<District> districts = (List<District>) addressService.getAddressDetails(0, UrlDetailsContants.DISTRICT);
		return districts;
	}

	@RequestMapping(value = "/district/{districtId}", method = RequestMethod.GET)
	@ResponseBody
	public District getDistrictById(@PathVariable int districtId) {
		District district = (District) addressService.getAddressDetails(districtId, UrlDetailsContants.DISTRICT);
		return district;
	}

	@RequestMapping(value = "/district", method = RequestMethod.POST)
	@ResponseBody
	public void addDistrict(@RequestBody District district) {
		addressService.addDistrictDetails(district);
	}

	@RequestMapping(value = "/district/{districtId}", method = RequestMethod.PUT)
	@ResponseBody
	public void udpateDistrict(@RequestBody District district,
			@PathVariable String districtId) {
		addressService.updateDistrictDetails(districtId, district);
	}

	@RequestMapping(value = "/district/{districtId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteDistrict(@PathVariable String districtId) {
		addressService.removeDistrictDetails(districtId);
	}
	
	@RequestMapping(value = "/address/{addressId}", method = RequestMethod.GET)
	@ResponseBody
	public Address getAddressById(@PathVariable int addressId) {
		Address address = (Address) addressService.getAddressDetails(addressId, UrlDetailsContants.ADDRESS);
		return address;
	}

	@RequestMapping(value = "/address", method = RequestMethod.POST)
	@ResponseBody
	public void addAddress(@RequestBody Address address) {
		addressService.addAddressDetails(address);
	}

	@RequestMapping(value = "/address/{addressId}", method = RequestMethod.PUT)
	@ResponseBody
	public void udpateAddress(@RequestBody Address address,
			@PathVariable String addressId) {
		addressService.updateAddressDetails(addressId, address);
	}

	@RequestMapping(value = "/address/{addressId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteAddress(@PathVariable String addressId) {
		addressService.removeAddressDetails(addressId);
	}
}
