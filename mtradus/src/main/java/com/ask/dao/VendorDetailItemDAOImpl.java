package com.ask.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.ask.dbpojo.VendorDetails;
import com.ask.dbpojo.VendorProductDetails;
import com.ask.dbpojo.VendorProductItemDetails;
import com.ask.pojo.VendorDetailsPojo;
import com.ask.util.ApplicationConstants;
import com.ask.util.CommonObjectMethods;

/**
 * 
 * @author ASK
 * 
 */
@Component
public class VendorDetailItemDAOImpl implements VendorDetailItemDAO {

	@Autowired
	HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public String saveVendorDetailsItem(VendorDetailsPojo pojo) {
		// TODO Auto-generated method stub
		String responseText = ApplicationConstants.SUCCESS_MESSAGE;
		Session session = hibernateTemplate.getSessionFactory()
				.openSession();
		try {
			
			session.beginTransaction();
			if (pojo.getItemId() != null && pojo.getItemName() != null) {
				VendorProductItemDetails item = new VendorProductItemDetails();
				VendorProductDetails product = new VendorProductDetails();
				VendorDetails vendor = new VendorDetails();
				@SuppressWarnings("unchecked")
				List<VendorProductItemDetails> itemList = session.createQuery("from VendorProductItemDetails where itemName = '"+pojo.getItemName()+"' and quantity = '"+pojo.getItemQuanity()+"'").list();
				if(itemList!=null && itemList.size()>0)
					return ApplicationConstants.DATA_PROBLEM_MESSAGE;
				item.setItemId(Integer.parseInt(pojo.getItemId()));
				item.setItemName(pojo.getItemName());
				product.setProductId(Integer.parseInt(pojo.getProductId()));
				vendor.setVendorId(Integer.parseInt(pojo.getVendorId()));
				item.setQuantity(pojo.getItemQuanity());
				item.setRetailAmount(Integer.parseInt(pojo.getRetailAmount()));
				item.setCretedOn(new Date());
				product.setVendorDetails(vendor);
				item.setProductDetails(product);

				if (pojo.getItemId().equalsIgnoreCase("0")) {
					int count = CommonObjectMethods.getMaxRow(session,
							"VendorProductItemDetails");
					item.setItemId(++count);
					item.setCretedOn(new Date());
				}
				session.saveOrUpdate(item);
			} else if (pojo.getProductId() != null
					&& pojo.getProductName() != null) {
				VendorProductDetails product = new VendorProductDetails();
				VendorDetails vendor = new VendorDetails();
				
				@SuppressWarnings("unchecked")
				List<VendorProductItemDetails> itemList = session.createQuery("from VendorProductDetails where productName = '"+pojo.getProductName()+"'").list();
				if(itemList!=null && itemList.size()>0)
					return ApplicationConstants.DATA_PROBLEM_MESSAGE;
				
				product.setProductId(Integer.parseInt(pojo.getProductId()));
				vendor.setVendorId(Integer.parseInt(pojo.getVendorId()));
				product.setProductName(pojo.getProductName());
				product.setVendorDetails(vendor);

				if (pojo.getProductId().equalsIgnoreCase("0")) {
					int count = CommonObjectMethods.getMaxRow(session,
							"VendorProductDetails");
					product.setProductId(++count);
					product.setCretedOn(new Date());
				}
				session.saveOrUpdate(product);
			} else if (pojo.getVendorId() != null
					&& pojo.getVendorName() != null) {

				VendorDetails vendor = new VendorDetails();
				
				@SuppressWarnings("unchecked")
				List<VendorProductItemDetails> itemList = session.createQuery("from VendorDetails where vendorName = '"+pojo.getVendorName()+"'").list();
				if(itemList!=null && itemList.size()>0)
					return ApplicationConstants.DATA_PROBLEM_MESSAGE;
				
				vendor.setVendorName(pojo.getVendorName());
				vendor.setVendorId(Integer.parseInt(pojo.getVendorId()));
				
				if (pojo.getVendorId().equalsIgnoreCase("0")) {
					int count = CommonObjectMethods.getMaxRow(session,
							"VendorDetails");
					vendor.setVendorId(++count);
					vendor.setCreatedOn(new Date());
				}
				session.saveOrUpdate(vendor);
			}
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			responseText = ApplicationConstants.FAILURE_MESSAGE;
			
		}finally{
			if(session!=null && session.isOpen()){
				session.close();
			}
		}
		return responseText;
	}

	public String saveRateEdit(VendorDetailsPojo pojo) {
		String responseText = ApplicationConstants.SUCCESS_MESSAGE;
		Session session = hibernateTemplate.getSessionFactory()
				.openSession();
		try {
			
			
			VendorProductItemDetails productItemDetails = new VendorProductItemDetails();
			if(pojo.getItemId()==null){
				 return "Problem with Item Id"; 
			}
			if(pojo.getItemId().equalsIgnoreCase("")){
				return "Problem with Item Id"; 
			}else{
				@SuppressWarnings("unchecked")
				List<VendorProductItemDetails> list = session.createQuery("from VendorProductItemDetails where itemId="+pojo.getItemId()).list();
				productItemDetails = list.get(0);
				productItemDetails.setItemId(Integer.parseInt(pojo.getItemId()));
				if(pojo.getItemMrp()!=null && !pojo.getItemMrp().equalsIgnoreCase(""))
					productItemDetails.setItemMRP(Integer.parseInt(pojo.getItemMrp()));
				if(pojo.getItemVat()!=null && !pojo.getItemVat().equalsIgnoreCase(""))
					productItemDetails.setItemVate(Integer.parseInt(pojo.getItemVat()));
				session.beginTransaction();
				session.update(productItemDetails);
				session.getTransaction().commit();
			}
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			responseText = ApplicationConstants.FAILURE_MESSAGE;
			
		}finally{
			if(session!=null && session.isOpen()){
				session.close();
			}
		}
		return responseText;
	}

}
