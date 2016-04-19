/**
 * 
 */
package com.ask.pojo;

import java.io.Serializable;

import com.ask.dbpojo.Discount;

/**
 * @author ASK
 *
 */
public class ItemCostDetailsPojo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2658456569240037865L;
	private int id;
	private String sellType;
	private int quantity;
	private double manufacturePrice;
	private double sellingPrice;
	private double clearancePrice;
	private double salesTax;
	private Discount discount;
	private double wholePrice;
	private int wholeQuantity;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the sellType
	 */
	public String getSellType() {
		return sellType;
	}
	/**
	 * @param sellType the sellType to set
	 */
	public void setSellType(String sellType) {
		this.sellType = sellType;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the manufacturePrice
	 */
	public double getManufacturePrice() {
		return manufacturePrice;
	}
	/**
	 * @param manufacturePrice the manufacturePrice to set
	 */
	public void setManufacturePrice(double manufacturePrice) {
		this.manufacturePrice = manufacturePrice;
	}
	/**
	 * @return the sellingPrice
	 */
	public double getSellingPrice() {
		return sellingPrice;
	}
	/**
	 * @param sellingPrice the sellingPrice to set
	 */
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	/**
	 * @return the clearancePrice
	 */
	public double getClearancePrice() {
		return clearancePrice;
	}
	/**
	 * @param clearancePrice the clearancePrice to set
	 */
	public void setClearancePrice(double clearancePrice) {
		this.clearancePrice = clearancePrice;
	}
	/**
	 * @return the salesTax
	 */
	public double getSalesTax() {
		return salesTax;
	}
	/**
	 * @param salesTax the salesTax to set
	 */
	public void setSalesTax(double salesTax) {
		this.salesTax = salesTax;
	}
	/**
	 * @return the discount
	 */
	public Discount getDiscount() {
		return discount;
	}
	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
	/**
	 * @return the wholePrice
	 */
	public double getWholePrice() {
		return wholePrice;
	}
	/**
	 * @param wholePrice the wholePrice to set
	 */
	public void setWholePrice(double wholePrice) {
		this.wholePrice = wholePrice;
	}
	/**
	 * @return the wholeQuantity
	 */
	public int getWholeQuantity() {
		return wholeQuantity;
	}
	/**
	 * @param wholeQuantity the wholeQuantity to set
	 */
	public void setWholeQuantity(int wholeQuantity) {
		this.wholeQuantity = wholeQuantity;
	}

}
