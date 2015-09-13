/**
 * 
 */
package com.ask.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.ask.dbpojo.Miscellenous;
import com.ask.pojo.MiscellaneousPojo;
import com.ask.util.ApplicationConstants;
import com.ask.util.CommonObjectMethods;

/**
 * @author ASK
 * 
 */
@Component
public class MiscellaneousDAOImpl implements MiscellaneousDAO {

	@Autowired
	HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/**
	 * 
	 */
	public String saveMiscellaneousData(MiscellaneousPojo pojo) {
		String responseText = ApplicationConstants.SUCCESS_MESSAGE;
		Session session = null;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			int count = CommonObjectMethods.getMaxRow(session, "Miscellenous");
			Miscellenous miscellenous = new Miscellenous();
			miscellenous.setId(++count);
			miscellenous.setCreatedOn(CommonObjectMethods.convertStringToDate(pojo.getDateOfPurchase()));
			miscellenous.setItemName(pojo.getItemName());
			miscellenous.setItemPrice(Integer.parseInt(pojo.getItemPrice()));
			miscellenous.setQuantity(Integer.parseInt(pojo.getItemQuantity()));
			session.beginTransaction();
			session.save(miscellenous);
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

}
