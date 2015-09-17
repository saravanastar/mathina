/**
 * 
 */
package com.ask.dao;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ask.dbpojo.Area;
import com.ask.dbpojo.Country;
import com.ask.dbpojo.District;
import com.ask.dbpojo.ShopProductMap;
import com.ask.dbpojo.Shops;
import com.ask.dbpojo.States;
import com.ask.dbpojo.User;
import com.ask.dbpojo.UserType;
import com.ask.dbpojo.VendorDetails;
import com.ask.dbpojo.VendorProductDetails;
import com.ask.dbpojo.VendorProductItemDetails;
import com.ask.exception.BusinessException;
import com.ask.pojo.UserPojo;

/**
 * @author 298651
 *
 */
@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public boolean addDefaultData() {

		Session session = template.getSessionFactory().openSession();
		UserType type = new UserType();
		User user = new User();
		type.setId(1);
		type.setUserType("Admin");

		user.setUserId(1);
		user.setUserName("ASK");
		user.setPassword("ask");
		user.setDateOfBirth(new Date());
		user.setEmailAddress("saravanastar@gmail.com");
		user.setPhoneNumber("9788074454");
		user.setCreatedBy("Sytem");
		user.setCreatedOn(new Date());
		user.setType(type);
		user.setUpdatedOn(new Date());
		// user.set
		// user.set
		UserType type2 = new UserType();
		User user2 = new User();
		type.setId(2);
		type.setUserType("Agent");

		user2.setUserId(2);
		user2.setUserName("Ismail");
		user2.setPassword("Ismail");
		user2.setDateOfBirth(new Date());
		user2.setEmailAddress("saravanastar@gmail.com");
		user2.setPhoneNumber("9788074454");
		user2.setCreatedBy("Sytem");
		user2.setCreatedOn(new Date());
		user2.setType(type2);
		user2.setUpdatedOn(new Date());

		Area area = new Area();
		area.setAreaId(1);
		area.setAreaName("Ashok Nagar");

		District district = new District();
		district.setDistrictID(1);
		district.setDistrictName("Pudukkottai");

		States state = new States();
		state.setStateID(1);
		state.setStateName("Tamil Nadu");

		Country country = new Country();
		country.setCountryID(1);
		country.setCountryName("India");

		state.setCountry(country);
		district.setState(state);
		area.setDistrict(district);

		Shops shop = new Shops();
		Shops shop1 = new Shops();
		VendorDetails vendorDetails = new VendorDetails();
		VendorDetails vendorDetails1 = new VendorDetails();
		VendorProductDetails productDetails = new VendorProductDetails();
		VendorProductDetails productDetails1 = new VendorProductDetails();
		VendorProductItemDetails productItemDetails = new VendorProductItemDetails();
		VendorProductItemDetails productItemDetails1 = new VendorProductItemDetails();
		ShopProductMap productMap = new ShopProductMap();
		ShopProductMap productMap1 = new ShopProductMap();

		shop.setShopID(1);
		shop.setCreatedOn(new Date());
		shop.setArea(area);
		shop.setShopName("Muthu SHop");
		shop.setUser(user2);

		shop1.setShopID(1);
		shop1.setCreatedOn(new Date());
		shop1.setArea(area);
		shop1.setShopName("Muthu SHop");
		shop1.setUser(user2);

		vendorDetails.setVendorId(1);
		vendorDetails.setVendorName("Annai Dates");
		vendorDetails.setCreatedOn(new Date());

		vendorDetails1.setVendorId(1);
		vendorDetails1.setVendorName("Annai Dates");
		vendorDetails1.setCreatedOn(new Date());

		productDetails.setProductId(1);
		productDetails.setCretedOn(new Date());
		productDetails.setProductName("Dates");
		productDetails.setVendorDetails(vendorDetails);

		productDetails1.setProductId(1);
		productDetails1.setCretedOn(new Date());
		productDetails1.setProductName("Dates");
		productDetails1.setVendorDetails(vendorDetails1);

		productItemDetails.setCretedOn(new Date());
		productItemDetails.setItemId(1);
		productItemDetails.setItemName("Seed Dates");
		productItemDetails.setProductDetails(productDetails);

		productItemDetails.setQuantity("100");
		productItemDetails.setRetailAmount(100);
		productItemDetails.setRetailPercentage(10);

		productItemDetails1.setCretedOn(new Date());
		productItemDetails1.setItemId(2);
		productItemDetails1.setItemName("Seed Dates");
		productItemDetails1.setProductDetails(productDetails1);

		productItemDetails1.setQuantity("200");
		productItemDetails1.setRetailAmount(100);
		productItemDetails1.setRetailPercentage(10);

		productMap.setId(1);
		productMap.setPercentage(8);
		productMap.setProductCost(108);
		productMap.setShop(shop);
		productMap.setVendorItemProduct(productItemDetails);

		productMap1.setId(2);
		productMap1.setPercentage(8);
		productMap1.setProductCost(208);
		productMap1.setShop(shop1);
		productMap1.setVendorItemProduct(productItemDetails1);

		session.beginTransaction();
		session.saveOrUpdate(country);
		session.saveOrUpdate(state);
		session.saveOrUpdate(district);
		session.saveOrUpdate(area);
		session.saveOrUpdate(type);
		session.saveOrUpdate(type2);
		session.saveOrUpdate(user);
		session.saveOrUpdate(user2);
		session.saveOrUpdate(shop);
		session.saveOrUpdate(vendorDetails);
		// session.saveOrUpdate(vendorDetails1);
		session.saveOrUpdate(productDetails);
		session.saveOrUpdate(productItemDetails);
		// session.saveOrUpdate(productDetails1);
		session.saveOrUpdate(productItemDetails1);

		session.saveOrUpdate(productMap);
		session.saveOrUpdate(productMap1);
		session.getTransaction().commit();
		session.close();
		return true;

	}

	public User getUserData(UserPojo pojo) {
		Session session = template.getSessionFactory().openSession();
		Query query = session.createQuery("from User where userName = :id and password=:password");
		query.setParameter("id", pojo.getUserName());
		query.setParameter("password", pojo.getPassword());
		User user = (User) query.uniqueResult();
		// = (User) session.get(User.class, pojo.getUserName());
		if (user == null)
			user = new User();
		// TODO Auto-generated method stub
		session.close();
		return user;
	}

	public User getUserDataByName(String userName) {
		Session session = template.getSessionFactory().openSession();
		Query query = session.createQuery("from User where userName = :id");
		query.setParameter("id", userName);
		User user = (User) query.uniqueResult();
		session.close();
		return user;
	}

	@Transactional
	public boolean addUser(User user) {
		boolean isUserAdded = false;
		Session session = template.getSessionFactory().openSession();
		try {
			session.save(user);
			isUserAdded = true;
		} catch(Exception e) {
			throw new BusinessException();
		}
		// TODO Auto-generated method stub
		return isUserAdded;
	}

}
