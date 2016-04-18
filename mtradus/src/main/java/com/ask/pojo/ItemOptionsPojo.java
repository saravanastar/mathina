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
public class ItemOptionsPojo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3611347123029566482L;
	private List<SizeOptionsPojo> sizes;
	private List<LitreOptionsPojo> litres;
	private List<WeightOptionsPojo> weights;
	private List<ColorOptionsPojo> colors;
	private List<FlavourOptionsPojo> flavours;
	private int quantity;
	private double sellingPrice;
	private double originalPrice;
	private double clearnacePrice;
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public double getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}
	public double getClearnacePrice() {
		return clearnacePrice;
	}
	public void setClearnacePrice(double clearnacePrice) {
		this.clearnacePrice = clearnacePrice;
	}
	public List<SizeOptionsPojo> getSizes() {
		return sizes;
	}
	public void setSizes(List<SizeOptionsPojo> sizes) {
		this.sizes = sizes;
	}
	public List<LitreOptionsPojo> getLitres() {
		return litres;
	}
	public void setLitres(List<LitreOptionsPojo> litres) {
		this.litres = litres;
	}
	public List<WeightOptionsPojo> getWeights() {
		return weights;
	}
	public void setWeights(List<WeightOptionsPojo> weights) {
		this.weights = weights;
	}
	public List<ColorOptionsPojo> getColors() {
		return colors;
	}
	public void setColors(List<ColorOptionsPojo> colors) {
		this.colors = colors;
	}
	public List<FlavourOptionsPojo> getFlavours() {
		return flavours;
	}
	public void setFlavours(List<FlavourOptionsPojo> flavours) {
		this.flavours = flavours;
	}
	
	
	
	
	
	

}
