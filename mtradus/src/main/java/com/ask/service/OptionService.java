/**
 * 
 */
package com.ask.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ask.dao.OptionsDAO;
import com.ask.dbpojo.ColorOption;
import com.ask.dbpojo.LitreOption;
import com.ask.dbpojo.SizeOption;
import com.ask.dbpojo.WeightOption;
import com.ask.pojo.ColorOptionsPojo;
import com.ask.pojo.LitreOptionsPojo;
import com.ask.pojo.SizeOptionsPojo;
import com.ask.pojo.WeightOptionsPojo;

/**
 * @author sahar8
 *
 */
@Service
public class OptionService {

	@Autowired
	OptionsDAO optionsDAO;

	/**
	 * @return the optionsDAO
	 */
	public OptionsDAO getOptionsDAO() {
		return optionsDAO;
	}

	/**
	 * @param optionsDAO
	 *            the optionsDAO to set
	 */
	public void setOptionsDAO(OptionsDAO optionsDAO) {
		this.optionsDAO = optionsDAO;
	}

	/**
	 * 
	 * @param colorOption
	 */
	public void addColorOption(ColorOptionsPojo colorOption) {
		ColorOption colorOptionDB = new ColorOption();
		BeanUtils.copyProperties(colorOption, colorOptionDB);
		optionsDAO.addColorOption(colorOptionDB);
	}

	/**
	 * 
	 * @return
	 */
	public List<ColorOptionsPojo> getColorOptions() {
		List<ColorOptionsPojo> colorOptionsPojos = new ArrayList<>();
		List<ColorOption> colorOptions = optionsDAO.getColorOptions();
		for (ColorOption colorOption : colorOptions) {
			ColorOptionsPojo colorOptionpojo = new ColorOptionsPojo();
			BeanUtils.copyProperties(colorOption, colorOptionpojo);
			colorOptionsPojos.add(colorOptionpojo);
		}
		return colorOptionsPojos;
	}

	/**
	 * 
	 * @param colorId
	 * @return
	 */
	public ColorOptionsPojo getColorOptionById(int colorId) {
		ColorOption colorOption = optionsDAO.getColorOptionById(colorId);
		ColorOptionsPojo colorOptionpojo = new ColorOptionsPojo();
		BeanUtils.copyProperties(colorOption, colorOptionpojo);
		return colorOptionpojo;
	}

	/**
	 * 
	 * @param colorId
	 */
	public void updateColorOption(int colorId) {
		ColorOption colorOption = optionsDAO.getColorOptionById(colorId);
		if (colorOption != null) {
			optionsDAO.updateColorOption(colorOption);
		}
	}

	/**
	 * 
	 * @param colorId
	 */
	public void deleteColorOption(int colorId) {
		optionsDAO.deleteColorOption(colorId);
	}

	/**
	 * 
	 * @param sizeOption
	 */
	public void addSizeOption(SizeOptionsPojo sizeOption) {
		SizeOption sizeOptionDB = new SizeOption();
		BeanUtils.copyProperties(sizeOption, sizeOptionDB);
		optionsDAO.addSizeOption(sizeOptionDB);
	}

	/**
	 * 
	 * @return
	 */
	public List<SizeOptionsPojo> getSizeOptions() {
		List<SizeOptionsPojo> sizeOptionsPojos = new ArrayList<>();
		List<SizeOption> colorOptions = optionsDAO.getSizeOptions();
		for (SizeOption sizeOption : colorOptions) {
			SizeOptionsPojo sizeOptionpojo = new SizeOptionsPojo();
			BeanUtils.copyProperties(sizeOption, sizeOptionpojo);
			sizeOptionsPojos.add(sizeOptionpojo);
		}
		return sizeOptionsPojos;
	}

	/**
	 * 
	 * @param sizeId
	 * @return
	 */
	public SizeOptionsPojo getSizeOptionById(int sizeId) {
		SizeOption sizeOption = optionsDAO.getSizeOptionById(sizeId);
		SizeOptionsPojo sizeOptionpojo = new SizeOptionsPojo();
		BeanUtils.copyProperties(sizeOption, sizeOptionpojo);
		return sizeOptionpojo;
	}

	/**
	 * 
	 * @param sizeId
	 */
	public void updateSizeOption(int sizeId) {
		SizeOption sizeOption = optionsDAO.getSizeOptionById(sizeId);
		if (sizeOption != null) {
			optionsDAO.updateSizeOption(sizeOption);
		}
	}

	/**
	 * 
	 * @param sizeId
	 */
	public void deleteSizeOption(int sizeId) {
		optionsDAO.deleteSizeOption(sizeId);
	}

	/**
	 * 
	 * @param weightOption
	 */
	public void addWeightOption(WeightOptionsPojo weightOption) {
		SizeOption sizeOptionDB = new SizeOption();
		BeanUtils.copyProperties(weightOption, sizeOptionDB);
		optionsDAO.addSizeOption(sizeOptionDB);
	}

	/**
	 * 
	 * @return
	 */
	public List<WeightOptionsPojo> getWeightOptions() {
		List<WeightOptionsPojo> weightOptionsPojos = new ArrayList<>();
		List<WeightOption> weightOptions = optionsDAO.getWeightOptions();
		for (WeightOption weightOption : weightOptions) {
			WeightOptionsPojo weightOptionpojo = new WeightOptionsPojo();
			BeanUtils.copyProperties(weightOption, weightOptionpojo);
			weightOptionsPojos.add(weightOptionpojo);
		}
		return weightOptionsPojos;
	}

	/**
	 * 
	 * @param weightId
	 * @return
	 */
	public WeightOptionsPojo getWeightOptionById(int weightId) {
		WeightOption weightOption = optionsDAO.getWeightOptionById(weightId);
		WeightOptionsPojo weightOptionpojo = new WeightOptionsPojo();
		BeanUtils.copyProperties(weightOption, weightOptionpojo);
		return weightOptionpojo;
	}

	/**
	 * 
	 * @param weightId
	 */
	public void updateWeightOption(int weightId) {
		WeightOption weightOption = optionsDAO.getWeightOptionById(weightId);
		if (weightOption != null) {
			optionsDAO.updateWeightOption(weightOption);
		}
	}

	/**
	 * 
	 * @param weightId
	 */
	public void deleteWeightOption(int weightId) {
		optionsDAO.deleteWeightOption(weightId);
	}
	
	/**
	 * 
	 * @param weightOption
	 */
	public void addLitreOption(LitreOptionsPojo litreOption) {
		LitreOption litreOptionDB = new LitreOption();
		BeanUtils.copyProperties(litreOption, litreOptionDB);
		optionsDAO.addLitreOption(litreOptionDB);
	}

	/**
	 * 
	 * @return
	 */
	public List<LitreOptionsPojo> getLitreOptions() {
		List<LitreOptionsPojo> litreOptionsPojos = new ArrayList<>();
		List<LitreOption> litreOptions = optionsDAO.getLitreOptions();
		for (LitreOption litreOption : litreOptions) {
			LitreOptionsPojo litreOptionpojo = new LitreOptionsPojo();
			BeanUtils.copyProperties(litreOption, litreOptionpojo);
			litreOptionsPojos.add(litreOptionpojo);
		}
		return litreOptionsPojos;
	}

	/**
	 * 
	 * @param litreId
	 * @return
	 */
	public LitreOptionsPojo getLitreOptionById(int litreId) {
		LitreOption litreOption = optionsDAO.getLitreOptionById(litreId);
		LitreOptionsPojo litreOptionpojo = new LitreOptionsPojo();
		BeanUtils.copyProperties(litreOption, litreOptionpojo);
		return litreOptionpojo;
	}

	/**
	 * 
	 * @param litreId
	 */
	public void updateLitreOption(int litreId) {
		LitreOption litreOption = optionsDAO.getLitreOptionById(litreId);
		if (litreOption != null) {
			optionsDAO.updateLitreOption(litreOption);
		}
	}

	/**
	 * 
	 * @param litreId
	 */
	public void deleteLitreOption(int litreId) {
		optionsDAO.deleteLitreOption(litreId);
	}


}
