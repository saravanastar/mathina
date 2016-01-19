/**
 * 
 */
package com.ask.mtradus.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author ASK
 *
 */
public class ProductDetailsPojo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6511460258636223038L;
	
	private int prodcutId;
	
	private String description;
	private List<ProductCategoryDetailsPojo> productCategoryDetailsList;
	private boolean status;
	private String expiredOn;
	private String createdOn;
	

}
