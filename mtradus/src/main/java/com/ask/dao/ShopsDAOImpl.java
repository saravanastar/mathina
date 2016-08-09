/**
 * 
 */
package com.ask.dao;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.ask.dbpojo.Shops;

/**
 * @author sahar8
 *
 */
public class ShopsDAOImpl implements ShopsDAO {

	@Autowired
	HibernateTemplate hibernateTemplate;

	@Override
	@Transactional
	public void addShopDetails(Shops shop) {
		// TODO Auto-generated method stub
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.save(shop);
	}
	
	/**
	 * 
	 * @param shop
	 */
	@Transactional
	public void updateShopDetails(Shops shop) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.save(shop);
		
	}
	
	/**
	 * 
	 * @param shopId
	 * @return
	 */
	public Shops getShopDetails(int shopId) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Query query = session.createQuery("from Shops where id = :shopId");
		query.setInteger("shopId", shopId);
		Shops shop = (Shops) query.uniqueResult();
		return shop;
	}
	
	/**
	 * 
	 * @param shopId
	 */
	@Transactional
	public void deleteShopDetails(int shopId) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Query query = session.createQuery("delete from Shops where id = :shopId");
		query.setInteger("shopId", shopId);
		query.executeUpdate();
	}
	
}
