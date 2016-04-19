/**
 * 
 */
package com.ask.dao;

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
 * @author ASK
 *
 */
@Repository
public class ProductDetailDAOImpl implements ProductDetailDAO {

	@Autowired
	HibernateTemplate hibernateTemplate;
	private Session session;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public List<VendorDetails> listVendors() {
		session = hibernateTemplate.getSessionFactory().getCurrentSession();
		@SuppressWarnings("unchecked")
		List<VendorDetails> vendorLst = session.createQuery("from VendorDetails").list();
		return vendorLst;
	}

	public VendorDetails getVendorById(int vendorId) {
		session = hibernateTemplate.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from VendorDetails where vendorId=:vendorId");
		query.setInteger("vendorId", vendorId);
		VendorDetails vendorDetails = (VendorDetails) query.uniqueResult();
		return vendorDetails;

	}

	public List<ProductCategoryDetails> listCategories() {
		session = hibernateTemplate.getSessionFactory().getCurrentSession();
		@SuppressWarnings("unchecked")
		List<ProductCategoryDetails> cateList = session.createQuery("from ProductCategoryDetails").list();
		return cateList;
	}

	public ProductCategoryDetails getCategoryById(int categoryId) {
		session = hibernateTemplate.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from ProductCategoryDetails where categoryId=:categoryId");
		query.setInteger("categoryId", categoryId);
		ProductCategoryDetails categoryDetails = (ProductCategoryDetails) query.uniqueResult();
		return categoryDetails;
	}

	public List<ProductDetails> listProduct() {
		@SuppressWarnings("unchecked")
		List<ProductDetails> productDetails = session.createQuery("from ProductDetails").list();
		return productDetails;
	}
	
	public ProductCategoryDetails getProductById(int productId) {
		session = hibernateTemplate.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from ProductCategoryDetails where productId=:productId");
		query.setInteger("productId", productId);
		ProductCategoryDetails categoryDetails = (ProductCategoryDetails) query.uniqueResult();
		return categoryDetails;
	}
	
	public List<ProductDetails> listItems() {
		@SuppressWarnings("unchecked")
		List<ProductDetails> productDetails = session.createQuery("from ProductDetails").list();
		return productDetails;
	}
	
	public ProductItemDetails getItemById(int itemId) {
		session = hibernateTemplate.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from ProductCategoryDetails where itemId=:itemId");
		query.setInteger("productId", itemId);
		ProductItemDetails itemDetails = (ProductItemDetails) query.uniqueResult();
		return itemDetails;
	}
	
	@Transactional
	public void addVendorData(VendorDetails vendorDetails) throws Exception {
		session = hibernateTemplate.getSessionFactory().openSession();
		session.save(vendorDetails);
	}

	@Transactional
	public void updateVendorDetails(int vendorId, VendorDetails vendorDetails) {
		session = hibernateTemplate.getSessionFactory().getCurrentSession();
		session.update(vendorDetails);
	}

	@Transactional
	public void deleteVendorDetails(int vendorId) {
		session = hibernateTemplate.getSessionFactory().getCurrentSession();
		VendorDetails details = new VendorDetails();
		details.setVendorId(vendorId);
		session.delete(details);
	}

	public void addCategoryDetails(ProductCategoryDetails categoryDetails) {
		session = hibernateTemplate.getSessionFactory().getCurrentSession();
		session.save(categoryDetails);
	}

	public void updateCategoryDetails(int categoryId,
			ProductCategoryDetails categoryDetails) {
		session = hibernateTemplate.getSessionFactory().getCurrentSession();
		session.update(categoryDetails);
	}

	public void deleteCategoryDetails(ProductCategoryDetails categoryDetails) {
		session = hibernateTemplate.getSessionFactory().getCurrentSession();
		/*VendorDetails details = new VendorDetails();
		details.setVendorId(vendorId);*/
		session.delete(categoryDetails);
	}

	public void addProductDetails(ProductDetails productDetails) {
		session = hibernateTemplate.getSessionFactory().getCurrentSession();
		session.save(productDetails);
	}

	public void updateProductDetails(ProductDetails productDetails) {
		session = hibernateTemplate.getSessionFactory().getCurrentSession();
		session.update(productDetails);
	}

	public void deleteProductDetails(int productId) {
		session = hibernateTemplate.getSessionFactory().getCurrentSession();
		ProductDetails details = new ProductDetails();
		details.setProductId(productId);
		session.delete(details);
	}

	public void addProductItemDetails(ProductItemDetails itemDetails) {
		session = hibernateTemplate.getSessionFactory().getCurrentSession();
		session.save(itemDetails);
	}

	public void updateProductItemDetails(int itemId,
			ProductItemDetails itemDetails) {
		session = hibernateTemplate.getSessionFactory().getCurrentSession();
		session.update(itemDetails);
	}

	public void deleteProductItemDetails(int itemId) {
		session = hibernateTemplate.getSessionFactory().getCurrentSession();
		ProductItemDetails details = new ProductItemDetails();
		details.setItemId(itemId);
		session.delete(details);
	}

}
