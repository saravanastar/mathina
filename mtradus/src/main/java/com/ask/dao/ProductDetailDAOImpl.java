package com.ask.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
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

	public List<ProductDetails> listProduct() {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		@SuppressWarnings("unchecked")
		List<ProductDetails> productDetails = session.createQuery("from ProductDetails").list();
		return productDetails;
	}

	public ProductCategoryDetails getProductById(int productId) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from ProductCategoryDetails where productId=:productId");
		query.setInteger("productId", productId);
		ProductCategoryDetails categoryDetails = (ProductCategoryDetails) query.uniqueResult();
		return categoryDetails;
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
	public void updateVendorDetails(int vendorId, VendorDetails vendorDetails) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		session.update(vendorDetails);
	}

	@Transactional
	public void deleteVendorDetails(int vendorId) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		VendorDetails details = new VendorDetails();
		details.setId(vendorId);
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

	public void addProductDetails(ProductDetails productDetails) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		session.save(productDetails);
	}

	public void updateProductDetails(ProductDetails productDetails) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		session.update(productDetails);
	}

	public void deleteProductDetails(int productId) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		ProductDetails details = new ProductDetails();
		details.setProductId(productId);
		session.delete(details);
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
