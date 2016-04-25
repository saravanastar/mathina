package com.ask.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.StaleStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ask.dbpojo.ProductCategoryDetails;
import com.ask.dbpojo.ProductDetails;
import com.ask.dbpojo.ProductItemDetails;
import com.ask.dbpojo.VendorDetails;

/**
 * 
 * 
 * 
 * @author ASK
 *
 */
@Repository
public class ProductDetailDAOImpl implements ProductDetailDAO {
	
	private static final Logger log = Logger.getLogger(ProductDetailDAOImpl.class);

	@Autowired
	HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public List<VendorDetails> listVendors() {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		@SuppressWarnings("unchecked")
		List<VendorDetails> vendorLst = session.createQuery("from VendorDetails").list();
		return vendorLst;
	}

	@Transactional
	public VendorDetails getVendorById(int vendorId) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from VendorDetails where id=:id");
		query.setInteger("id", vendorId);
		VendorDetails vendorDetails = (VendorDetails) query.uniqueResult();
		return vendorDetails;

	}

	public List<ProductCategoryDetails> listCategories() {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		@SuppressWarnings("unchecked")
		List<ProductCategoryDetails> cateList = session.createQuery("from ProductCategoryDetails").list();
		return cateList;
	}

	public ProductCategoryDetails getCategoryById(int categoryId) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from ProductCategoryDetails where categoryId=:categoryId");
		query.setInteger("categoryId", categoryId);
		ProductCategoryDetails categoryDetails = (ProductCategoryDetails) query.uniqueResult();
		return categoryDetails;
	}

	@Transactional
	public List<ProductDetails> listProduct() {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		@SuppressWarnings("unchecked")
		List<ProductDetails> productDetails = session.createQuery("from ProductDetails").list();
		return productDetails;
	}

	@Transactional
	public ProductDetails getProductById(int productId) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from ProductDetails where productId=:productId");
		query.setInteger("productId", productId);
		ProductDetails productDetails = (ProductDetails) query.uniqueResult();
		return productDetails;
	}

	public List<ProductDetails> listItems() {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		@SuppressWarnings("unchecked")
		List<ProductDetails> productDetails = session.createQuery("from ProductDetails").list();
		return productDetails;
	}

	/**
	 * 
	 * @param itemId
	 * @return
	 */
	public ProductItemDetails getItemById(int itemId) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from ProductCategoryDetails where itemId=:itemId");
		query.setInteger("productId", itemId);
		ProductItemDetails itemDetails = (ProductItemDetails) query.uniqueResult();
		return itemDetails;
	}

	@Transactional
	public void addVendorData(VendorDetails vendorDetails) throws Exception {

		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		vendorDetails.setCreatedOn(new Date());
		session.saveOrUpdate(vendorDetails);
	}

	@Transactional
	public void updateVendorDetails(VendorDetails vendorDetails) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		session.update(vendorDetails);
	}

	@Transactional
	public void deleteVendorDetails(VendorDetails details) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		session.delete(details);
	}

	public void addCategoryDetails(ProductCategoryDetails categoryDetails) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		session.save(categoryDetails);
	}

	public void updateCategoryDetails(int categoryId, ProductCategoryDetails categoryDetails) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		session.update(categoryDetails);
	}

	public void deleteCategoryDetails(ProductCategoryDetails categoryDetails) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		/*
		 * VendorDetails details = new VendorDetails();
		 * details.setVendorId(vendorId);
		 */
		session.delete(categoryDetails);
	}

	@Transactional
	public void addProductDetails(ProductDetails productDetails) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		session.save(productDetails);
	}

	@Transactional
	public void updateProductDetails(ProductDetails productDetails) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		try {
		session.update(productDetails);
		} catch (StaleStateException staleStateException) {
			log.error(staleStateException.fillInStackTrace());
		}
	}

	/**
	 * deleting the product Details.
	 * 
	 */
	@Transactional
	public void deleteProductDetails(ProductDetails productDetails) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		session.delete(productDetails);
	}

	public void addProductItemDetails(ProductItemDetails itemDetails) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		session.save(itemDetails);
	}

	public void updateProductItemDetails(int itemId, ProductItemDetails itemDetails) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		session.update(itemDetails);
	}

	public void deleteProductItemDetails(int itemId) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		ProductItemDetails details = new ProductItemDetails();
		details.setItemId(itemId);
		session.delete(details);
	}

}
