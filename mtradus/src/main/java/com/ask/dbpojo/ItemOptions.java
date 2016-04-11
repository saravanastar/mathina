/**
 * 
 */
package com.ask.dbpojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author ASK
 *
 */
@Entity
@Table(name = "ITEM_OPTIONS")
public class ItemOptions {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "OPTION_ID")
	private int optionId;
	
	@Column(name = "SIZE_OPTION")
	private String sizeOption;

	@Column(name = "COLOR_OPTION")
	private String colorOptions;

	@Column(name = "WEIGHT_OPTION")
	private String weightOptions;

	@Column(name = "LITRE_OPTION")
	private String litreOptions;

	@Column(name = "FLAVOUR_OPTION")
	private String flavourOption;
	
	@OneToOne
	private ItemCostDetails itemCostDetails;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOptionId() {
		return optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	public String getSizeOption() {
		return sizeOption;
	}

	public void setSizeOption(String sizeOption) {
		this.sizeOption = sizeOption;
	}

	public String getColorOptions() {
		return colorOptions;
	}

	public void setColorOptions(String colorOptions) {
		this.colorOptions = colorOptions;
	}

	public String getWeightOptions() {
		return weightOptions;
	}

	public void setWeightOptions(String weightOptions) {
		this.weightOptions = weightOptions;
	}

	public String getLitreOptions() {
		return litreOptions;
	}

	public void setLitreOptions(String litreOptions) {
		this.litreOptions = litreOptions;
	}

	public String getFlavourOption() {
		return flavourOption;
	}

	public void setFlavourOption(String flavourOption) {
		this.flavourOption = flavourOption;
	}

	public ItemCostDetails getItemCostDetails() {
		return itemCostDetails;
	}

	public void setItemCostDetails(ItemCostDetails itemCostDetails) {
		this.itemCostDetails = itemCostDetails;
	}

}