/**
 * 
 */
package com.ask.dao;

import java.util.List;

import com.ask.dbpojo.ColorOption;
import com.ask.dbpojo.FlavourOption;
import com.ask.dbpojo.LitreOption;
import com.ask.dbpojo.SizeOption;
import com.ask.dbpojo.WeightOption;

/**
 * @author sahar8
 *
 */
public interface OptionsDAO {

	public void addColorOption(ColorOption colorOption);
	
	public List<ColorOption> getColorOptions();

	ColorOption getColorOptionById(int colorId);

	void updateColorOption(ColorOption colorOption);

	int deleteColorOption(int colorId);

	/**
	 * SizeOptions Methods
	 * 
	 * @return
	 */
	public void addSizeOption(SizeOption sizeOption);
	
	public List<SizeOption> getSizeOptions();

	SizeOption getSizeOptionById(int sizeId);

	void updateSizeOption(SizeOption sizeOption);

	int deleteSizeOption(int sizeId);

	/**
	 * WeightOptions Methods
	 * 
	 * @return
	 */
	public void addWeightOption(WeightOption weightOption);
	
	public List<WeightOption> getWeightOptions();

	WeightOption getWeightOptionById(int weightId);

	void updateWeightOption(WeightOption weightOption);

	int deleteWeightOption(int weightId);
	
	/**
	 * LitreOptions Methods
	 * 
	 * @return
	 */
	public void addLitreOption(LitreOption litreOption);
	
	public List<LitreOption> getLitreOptions();

	LitreOption getLitreOptionById(int litreId);

	void updateLitreOption(LitreOption leightOption);

	int deleteLitreOption(int litreId);
	
	/**
	 * FlavourOption Methods
	 * 
	 * @return
	 */
	public void addFlavourOption(FlavourOption flavourOption);
	
	public List<FlavourOption> getFlavourOptions();

	FlavourOption getFlavourOptionById(int flavourId);

	void updateFlavourOption(FlavourOption flavourOption);

	int deleteFlavourOption(int flavourId);

}
