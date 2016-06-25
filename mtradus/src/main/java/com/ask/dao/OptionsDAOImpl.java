/**
 * 
 */
package com.ask.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ask.dbpojo.ColorOption;
import com.ask.dbpojo.FlavourOption;
import com.ask.dbpojo.LitreOption;
import com.ask.dbpojo.SizeOption;
import com.ask.dbpojo.WeightOption;

/**
 * @author sahar8
 *
 */
@Repository
public class OptionsDAOImpl implements OptionsDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	/**
	 * @return the hibernateTemplate
	 */
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	/**
	 * @param hibernateTemplate
	 *            the hibernateTemplate to set
	 */
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public void addColorOption(ColorOption colorOption) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.saveOrUpdate(colorOption);
	}
	
	@Override
	public List<ColorOption> getColorOptions() {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<ColorOption> colorOptions = session.createQuery("from ColorOption").list();
		return colorOptions;
	}

	@Override
	public ColorOption getColorOptionById(int colorId) {
		ColorOption colorOption = null;
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Query query = (Query) session.createQuery("from ColorOption where id=:colorId").list();
		query.setInteger("colorId", colorId);
		colorOption = (ColorOption) query.uniqueResult();
		return colorOption;
	}

	@Override
	@Transactional
	public void updateColorOption(ColorOption colorOption) {
		// TODO Auto-generated method stub
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.update(colorOption);
	}

	@Override
	@Transactional
	public int deleteColorOption(int colorId) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Query query = (Query) session.createQuery("from ColorOption where id=:colorId").list();
		query.setInteger("colorId", colorId);
		return query.executeUpdate();

	}

	@Override
	public List<SizeOption> getSizeOptions() {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<SizeOption> sizeOptions = session.createQuery("from SizeOption").list();
		return sizeOptions;
	}

	@Override
	public SizeOption getSizeOptionById(int sizeId) {
		SizeOption sizeOption = null;
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Query query = (Query) session.createQuery("from SizeOption where id=:sizeId").list();
		query.setInteger("sizeId", sizeId);
		sizeOption = (SizeOption) query.uniqueResult();
		return sizeOption;
	}

	@Override
	public void updateSizeOption(SizeOption sizeOption) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.update(sizeOption);
		
	}

	@Override
	public int deleteSizeOption(int sizeId) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Query query = (Query) session.createQuery("from SizeOption where id=:sizeId").list();
		query.setInteger("sizeId", sizeId);
		return query.executeUpdate();
	}

	@Override
	public List<WeightOption> getWeightOptions() {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<WeightOption> weightOptions = session.createQuery("from WeightOption").list();
		return weightOptions;
	}

	@Override
	public WeightOption getWeightOptionById(int weightId) {
		WeightOption weightOption = null;
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Query query = (Query) session.createQuery("from WeightOption where id=:weightId").list();
		query.setInteger("weightId", weightId);
		weightOption = (WeightOption) query.uniqueResult();
		return weightOption;
	}

	@Override
	public void updateWeightOption(WeightOption weightOption) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.update(weightOption);
		
	}

	@Override
	public int deleteWeightOption(int weightId) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Query query = (Query) session.createQuery("from WeightOption where id=:weightId").list();
		query.setInteger("weightId", weightId);
		return query.executeUpdate();
	}

	@Override
	public List<LitreOption> getLitreOptions() {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<LitreOption> litreOptions = session.createQuery("from LitreOption").list();
		return litreOptions;
	}

	@Override
	public LitreOption getLitreOptionById(int litreId) {
		LitreOption litreOption = null;
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Query query = (Query) session.createQuery("from LitreOption where id=:litreId").list();
		query.setInteger("litreId", litreId);
		litreOption = (LitreOption) query.uniqueResult();
		return litreOption;
	}

	@Override
	public void updateLitreOption(LitreOption litreOption) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.update(litreOption);
	}

	@Override
	public int deleteLitreOption(int litreId) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Query query = (Query) session.createQuery("from LitreOption where id=:litreId").list();
		query.setInteger("litreId", litreId);
		return query.executeUpdate();
	}

	@Override
	public List<FlavourOption> getFlavourOptions() {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<FlavourOption> flavourOptions = session.createQuery("from FlavourOption").list();
		return flavourOptions;
	}

	@Override
	public FlavourOption getFlavourOptionById(int flavourId) {
		FlavourOption flavourOption = null;
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Query query = (Query) session.createQuery("from FlavourOption where id=:flavourId").list();
		query.setInteger("flavourId", flavourId);
		flavourOption = (FlavourOption) query.uniqueResult();
		return flavourOption;
	}

	@Override
	public void updateFlavourOption(FlavourOption flavourOption) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.update(flavourOption);
		
	}

	@Override
	public int deleteFlavourOption(int flavourId) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Query query = (Query) session.createQuery("from FlavourOption where id=:flavourId").list();
		query.setInteger("flavourId", flavourId);
		return query.executeUpdate();
	}

	@Override
	public void addSizeOption(SizeOption sizeOption) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.saveOrUpdate(sizeOption);
	}

	@Override
	public void addWeightOption(WeightOption weightOption) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.saveOrUpdate(weightOption);
	}

	@Override
	public void addLitreOption(LitreOption litreOption) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.saveOrUpdate(litreOption);
	}

	@Override
	public void addFlavourOption(FlavourOption flavourOption) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.saveOrUpdate(flavourOption);
	}

}
