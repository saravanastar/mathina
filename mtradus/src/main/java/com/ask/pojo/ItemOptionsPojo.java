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
	private ItemCostDetailsPojo price;
	private int totalQuantity;
	
	
	
	/**
	 * @return the price
	 */
	public ItemCostDetailsPojo getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(ItemCostDetailsPojo price) {
		this.price = price;
	}
	/**
	 * @return the totalQuantity
	 */
	public int getTotalQuantity() {
		return totalQuantity;
	}
	/**
	 * @param totalQuantity the totalQuantity to set
	 */
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	/**
	 * @return the sizes
	 */
	public List<SizeOptionsPojo> getSizes() {
		return sizes;
	}
	/**
	 * @param sizes the sizes to set
	 */
	public void setSizes(List<SizeOptionsPojo> sizes) {
		this.sizes = sizes;
	}
	/**
	 * @return the litres
	 */
	public List<LitreOptionsPojo> getLitres() {
		return litres;
	}
	/**
	 * @param litres the litres to set
	 */
	public void setLitres(List<LitreOptionsPojo> litres) {
		this.litres = litres;
	}
	/**
	 * @return the weights
	 */
	public List<WeightOptionsPojo> getWeights() {
		return weights;
	}
	/**
	 * @param weights the weights to set
	 */
	public void setWeights(List<WeightOptionsPojo> weights) {
		this.weights = weights;
	}
	/**
	 * @return the colors
	 */
	public List<ColorOptionsPojo> getColors() {
		return colors;
	}
	/**
	 * @param colors the colors to set
	 */
	public void setColors(List<ColorOptionsPojo> colors) {
		this.colors = colors;
	}
	/**
	 * @return the flavours
	 */
	public List<FlavourOptionsPojo> getFlavours() {
		return flavours;
	}
	/**
	 * @param flavours the flavours to set
	 */
	public void setFlavours(List<FlavourOptionsPojo> flavours) {
		this.flavours = flavours;
	}
	
	
	}
