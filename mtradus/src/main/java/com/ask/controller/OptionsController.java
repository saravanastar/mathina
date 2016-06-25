/**
 * 
 */
package com.ask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ask.pojo.ColorOptionsPojo;
import com.ask.pojo.LitreOptionsPojo;
import com.ask.pojo.SizeOptionsPojo;
import com.ask.pojo.WeightOptionsPojo;
import com.ask.service.OptionService;

/**
 * @author ASK
 *
 */
@Controller
@RequestMapping("/options")
public class OptionsController {

	@Autowired
	OptionService optionService;

	/**
	 * @return the optionService
	 */
	public OptionService getOptionService() {
		return optionService;
	}

	/**
	 * @param optionService
	 *            the optionService to set
	 */
	public void setOptionService(OptionService optionService) {
		this.optionService = optionService;
	}

	/**
	 * 
	 * @param colorOption
	 */
	@RequestMapping(value = "/color", method = RequestMethod.POST)
	private void addColorOption(@RequestBody ColorOptionsPojo colorOption) {
		optionService.addColorOption(colorOption);
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/colors", method = RequestMethod.GET)
	@ResponseBody
	private List<ColorOptionsPojo> getColorOptions() {
		return optionService.getColorOptions();
	}

	/**
	 * 
	 * @param colorId
	 * @return
	 */
	@RequestMapping(value = "/color/{colorId}", method = RequestMethod.GET)
	@ResponseBody
	private ColorOptionsPojo getColorOptionById(@PathVariable int colorId) {
		return optionService.getColorOptionById(colorId);

	}

	/**
	 * 
	 * @param colorId
	 */
	@RequestMapping(value = "/color/{colorId}", method = RequestMethod.PUT)
	@ResponseBody
	private void updateColorOption(@PathVariable int colorId) {
		optionService.updateColorOption(colorId);
	}

	/**
	 * 
	 * @param colorId
	 */
	@RequestMapping(value = "/color/{colorId}", method = RequestMethod.DELETE)
	@ResponseBody
	private void deleteColorOption(@PathVariable int colorId) {
		optionService.deleteColorOption(colorId);
	}

	/**
	 * 
	 * @param colorOption
	 */
	@RequestMapping(value = "/size", method = RequestMethod.POST)
	private void addSizeOption(@RequestBody SizeOptionsPojo sizeOption) {
		optionService.addSizeOption(sizeOption);
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/sizes", method = RequestMethod.GET)
	@ResponseBody
	private List<SizeOptionsPojo> getSizeOptions() {
		return optionService.getSizeOptions();
	}

	/**
	 * 
	 * @param sizeId
	 * @return
	 */
	@RequestMapping(value = "/size/{sizeId}", method = RequestMethod.GET)
	@ResponseBody
	private SizeOptionsPojo getSizeOptionById(@PathVariable int sizeId) {
		return optionService.getSizeOptionById(sizeId);

	}

	/**
	 * 
	 * @param sizeId
	 */
	@RequestMapping(value = "/size/{sizeId}", method = RequestMethod.PUT)
	@ResponseBody
	private void updateSizeOption(@PathVariable int sizeId) {
		optionService.updateSizeOption(sizeId);
	}

	/**
	 * 
	 * @param sizeId
	 */
	@RequestMapping(value = "/size/{sizeId}", method = RequestMethod.DELETE)
	@ResponseBody
	private void deleteSizeOption(@PathVariable int sizeId) {
		optionService.deleteSizeOption(sizeId);
	}

	/**
	 * 
	 * @param colorOption
	 */
	@RequestMapping(value = "/weight", method = RequestMethod.POST)
	private void addWeightOption(@RequestBody WeightOptionsPojo weightOption) {
		optionService.addWeightOption(weightOption);
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/weights", method = RequestMethod.GET)
	@ResponseBody
	private List<WeightOptionsPojo> getWeightOptions() {
		return optionService.getWeightOptions();
	}

	/**
	 * 
	 * @param weightId
	 * @return
	 */
	@RequestMapping(value = "/weight/{weightId}", method = RequestMethod.GET)
	@ResponseBody
	private WeightOptionsPojo getWeightOptionById(@PathVariable int weightId) {
		return optionService.getWeightOptionById(weightId);

	}

	/**
	 * 
	 * @param weightId
	 */
	@RequestMapping(value = "/weight/{weightId}", method = RequestMethod.PUT)
	@ResponseBody
	private void updateWeightOption(@PathVariable int weightId) {
		optionService.updateWeightOption(weightId);
	}

	/**
	 * 
	 * @param weightId
	 */
	@RequestMapping(value = "/weight/{weightId}", method = RequestMethod.DELETE)
	@ResponseBody
	private void deleteWeightOption(@PathVariable int weightId) {
		optionService.deleteWeightOption(weightId);
	}
	
	/**
	 * 
	 * @param colorOption
	 */
	@RequestMapping(value = "/litre", method = RequestMethod.POST)
	private void addLitreOption(@RequestBody LitreOptionsPojo litreOption) {
		optionService.addLitreOption(litreOption);
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/litres", method = RequestMethod.GET)
	@ResponseBody
	private List<LitreOptionsPojo> getLitreOptions() {
		return optionService.getLitreOptions();
	}

	/**
	 * 
	 * @param litreId
	 * @return
	 */
	@RequestMapping(value = "/litre/{litreId}", method = RequestMethod.GET)
	@ResponseBody
	private LitreOptionsPojo getLitreOptionById(@PathVariable int litreId) {
		return optionService.getLitreOptionById(litreId);

	}

	/**
	 * 
	 * @param litreId
	 */
	@RequestMapping(value = "/litre/{litreId}", method = RequestMethod.PUT)
	@ResponseBody
	private void updateLitreOption(@PathVariable int litreId) {
		optionService.updateLitreOption(litreId);
	}

	/**
	 * 
	 * @param litreId
	 */
	@RequestMapping(value = "/litre/{litreId}", method = RequestMethod.DELETE)
	@ResponseBody
	private void deleteLitreOption(@PathVariable int litreId) {
		optionService.deleteLitreOption(litreId);
	}
}
