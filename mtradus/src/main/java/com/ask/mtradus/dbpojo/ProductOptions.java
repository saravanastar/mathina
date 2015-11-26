/**
 * 
 */
package com.ask.mtradus.dbpojo;

import java.io.File;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author ASK
 *
 */
@Entity
@Table(name = "PRODUCT_OPTIONS")
public class ProductOptions {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne
	private SizeOption sizeOption;

	@ManyToOne
	private ColorOption colorOptions;

	@ManyToOne
	private WeightOption weightOption;

	@ManyToOne
	private LitreOption litreOption;

	@ManyToOne
	private FlavourOption flavourOption;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public WeightOption getWeightOption() {
		return weightOption;
	}

	public void setWeightOption(WeightOption weightOption) {
		this.weightOption = weightOption;
	}

	public LitreOption getLitreOption() {
		return litreOption;
	}

	public void setLitreOption(LitreOption litreOption) {
		this.litreOption = litreOption;
	}

	public FlavourOption getFlavourOption() {
		return flavourOption;
	}

	public void setFlavourOption(FlavourOption flavourOption) {
		this.flavourOption = flavourOption;
	}
	public static void main(String[] args) {
		File file =  new File("C:/Users/sarav/git/mathina/mtradus/src/main/java/com/ask/mtradus/dbpojo");
		File[] list = file.listFiles();
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i].getName());
			
		}
	}

}