/**
 * 
 */
package com.ask.actions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ask.dbpojo.Country;
import com.ask.dbpojo.States;

/**
 * @author ASK
 *
 */
@Controller
@RequestMapping("/location")
public class LocationController {

	@RequestMapping(value = "/countries", method = RequestMethod.GET)
	@ResponseBody
	public void listCountries() {

	}

	@RequestMapping(value = "/country/{countryId}", method = RequestMethod.GET)
	@ResponseBody
	public void getCountry(@PathVariable String countryId) {

	}

	@RequestMapping(value = "/country", method = RequestMethod.POST)
	@ResponseBody
	public void addCountry(@RequestBody Country country) {

	}

	@RequestMapping(value = "/country/{countryId}", method = RequestMethod.PUT)
	@ResponseBody
	public void updateCountry(@RequestBody Country country,
			@PathVariable String countryId) {

	}

	@RequestMapping(value = "/country/{countryId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteCountry(@PathVariable String countryId) {

	}
	
	@RequestMapping(value = "/states", method = RequestMethod.GET)
	@ResponseBody
	public void listStates() {

	}

	@RequestMapping(value = "/state/{stateId}", method = RequestMethod.GET)
	@ResponseBody
	public void getState(@PathVariable String stateId) {

	}
	
	@RequestMapping(value = "/state", method = RequestMethod.POST)
	@ResponseBody
	public void addState(@RequestBody States state) {

	}

	@RequestMapping(value = "/state/{stateId}", method = RequestMethod.PUT)
	@ResponseBody
	public void udpateState(@RequestBody States state,
			@PathVariable String stateId) {

	}

	@RequestMapping(value = "/state/{stateId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteState(@PathVariable String stateId) {

	}
}
