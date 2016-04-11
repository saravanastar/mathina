/**
 * 
 */
package com.ask.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author ASK
 *
 */
public class ProductCategoryDetailsPojo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3202847918096117225L;
	
	private int id;
	
	private String name;
	
	private List<ItemDetailsPojo> items;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ItemDetailsPojo> getItems() {
		return items;
	}

	public void setItems(List<ItemDetailsPojo> items) {
		this.items = items;
	}

		
	

}
