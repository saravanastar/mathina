/**
 * 
 */
package com.ask.dbpojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	
	@ManyToOne
	private SizeOption sizeOption;
	
	@ManyToOne
	private ColorOption colorOptions;

	@ManyToOne
	private WeightOption weightOptions;

	@ManyToOne
	private LitreOption litreOptions;

	@ManyToOne
	private FlavourOption flavourOption;
	
	@OneToOne
	private ItemCostDetails itemCostDetails;
	
	@Column(name = "STOCK_QUANTITY")
	int quantity;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_UPDATED_ON")
	Date lastUpdatedOn;
	
	@Column(name="LAST_UPDATED_BY")
	String lastUpdatedBy;
	
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public Date getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(Date lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

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

	public SizeOption getSizeOption() {
		return sizeOption;
	}

	public void setSizeOption(SizeOption sizeOption) {
		this.sizeOption = sizeOption;
	}

	public ColorOption getColorOptions() {
		return colorOptions;
	}

	public void setColorOptions(ColorOption colorOptions) {
		this.colorOptions = colorOptions;
	}

	public WeightOption getWeightOptions() {
		return weightOptions;
	}

	public void setWeightOptions(WeightOption weightOptions) {
		this.weightOptions = weightOptions;
	}

	public LitreOption getLitreOptions() {
		return litreOptions;
	}

	public void setLitreOptions(LitreOption litreOptions) {
		this.litreOptions = litreOptions;
	}

	public FlavourOption getFlavourOption() {
		return flavourOption;
	}

	public void setFlavourOption(FlavourOption flavourOption) {
		this.flavourOption = flavourOption;
	}

	public ItemCostDetails getItemCostDetails() {
		return itemCostDetails;
	}

	public void setItemCostDetails(ItemCostDetails itemCostDetails) {
		this.itemCostDetails = itemCostDetails;
	}

	
}