/**
 * 
 */
package com.ask.pojo;

import java.io.Serializable;

/**
 * @author ASK
 *
 */
public class WeightOptionsPojo implements Serializable, OptionsPojoResonse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 99768500610016287L;
	private int id;
	private String type;
	private String value;
	private String description;
	
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
