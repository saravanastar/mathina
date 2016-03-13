/**
 * 
 */
package com.ask.mtradus.dbpojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ASK
 *
 */
@Entity
@Table (name = "COLOR_OPTIONS")
public class ColorOption {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "COLOR_TYPE")
	private String type;
	
	@Column(name = "description")
	private String description;
	
	
	
	

}
