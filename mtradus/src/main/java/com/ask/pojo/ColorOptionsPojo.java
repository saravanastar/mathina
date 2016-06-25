/**
 * 
 */
package com.ask.pojo;

import java.io.Serializable;

/**
 * @author ASK
 *
 */
public class ColorOptionsPojo implements Serializable,OptionsPojoResonse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6547500115958859846L;
	private int id;
	private String type;
	private String description;
	private String colorCode;
	
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
	public String getColorCode() {
		return colorCode;
	}
	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}
	
	
	

}
