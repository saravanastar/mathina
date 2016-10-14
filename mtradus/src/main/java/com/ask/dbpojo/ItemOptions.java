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
	private int totalQuantity;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_UPDATED_ON")
	Date lastUpdatedOn;
	
	@Column(name="LAST_UPDATED_BY")
	String lastUpdatedBy;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the optionId
	 */
	public int getOptionId() {
		return optionId;
	}

	/**
	 * @param optionId the optionId to set
	 */
	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	/**
	 * @return the sizeOption
	 */
	public SizeOption getSizeOption() {
		return sizeOption;
	}

	/**
	 * @param sizeOption the sizeOption to set
	 */
	public void setSizeOption(SizeOption sizeOption) {
		this.sizeOption = sizeOption;
	}

	/**
	 * @return the colorOptions
	 */
	public ColorOption getColorOptions() {
		return colorOptions;
	}

	/**
	 * @param colorOptions the colorOptions to set
	 */
	public void setColorOptions(ColorOption colorOptions) {
		this.colorOptions = colorOptions;
	}

	/**
	 * @return the weightOptions
	 */
	public WeightOption getWeightOptions() {
		return weightOptions;
	}

	/**
	 * @param weightOptions the weightOptions to set
	 */
	public void setWeightOptions(WeightOption weightOptions) {
		this.weightOptions = weightOptions;
	}

	/**
	 * @return the litreOptions
	 */
	public LitreOption getLitreOptions() {
		return litreOptions;
	}

	/**
	 * @param litreOptions the litreOptions to set
	 */
	public void setLitreOptions(LitreOption litreOptions) {
		this.litreOptions = litreOptions;
	}

	/**
	 * @return the flavourOption
	 */
	public FlavourOption getFlavourOption() {
		return flavourOption;
	}

	/**
	 * @param flavourOption the flavourOption to set
	 */
	public void setFlavourOption(FlavourOption flavourOption) {
		this.flavourOption = flavourOption;
	}

	/**
	 * @return the lastUpdatedOn
	 */
	public Date getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	/**
	 * @param lastUpdatedOn the lastUpdatedOn to set
	 */
	public void setLastUpdatedOn(Date lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	/**
	 * @return the lastUpdatedBy
	 */
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	/**
	 * @param lastUpdatedBy the lastUpdatedBy to set
	 */
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	
	
	
}