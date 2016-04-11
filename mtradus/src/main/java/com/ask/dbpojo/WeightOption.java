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
@Table (name = "WEIGHT_OPTION")
public class WeightOption {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name  = "WEIGHT_TYPE")
	private String type;
	
	@Column(name= "WEIGHT_VALUE")
	private String value;
	
	@Column( name = "DESCRIPTION")
	private String description;
	
	@OneToOne
	private ItemCostDetails itemCostDetails;
	
	

	public ItemCostDetails getItemCostDetails() {
		return itemCostDetails;
	}

	public void setItemCostDetails(ItemCostDetails itemCostDetails) {
		this.itemCostDetails = itemCostDetails;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
