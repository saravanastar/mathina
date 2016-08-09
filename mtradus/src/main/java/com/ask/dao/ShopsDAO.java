/**
 * 
 */
package com.ask.dao;

import com.ask.dbpojo.Shops;

/**
 * @author sahar8
 *
 */
public interface ShopsDAO {

	public void addShopDetails(Shops shop);

	public Shops getShopDetails(int shopId);

	public void deleteShopDetails(int shopId);

	void updateShopDetails(Shops shop);

}
