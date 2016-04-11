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
@Table(name = "FLAVOUR_OPTIONS")
public class FlavourOption {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "FLAVOUR_TYPE")
	private String type;

	@Column(name = "Description")
	private String description;

	@Column(name = "name")
	private String name;
	
	@OneToOne
	private ItemCostDetails itemCostDetails;
	
	

	public ItemCostDetails getItemCostDetails() {
		return itemCostDetails;
	}

	public void setItemCostDetails(ItemCostDetails itemCostDetails) {
		this.itemCostDetails = itemCostDetails;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
