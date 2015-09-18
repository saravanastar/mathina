/**
 * 
 */
package com.ask.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ask.dbpojo.Country;
import com.ask.dbpojo.District;
import com.ask.dbpojo.States;

/**
 * @author ASK
 *
 */
@Repository
public class AddressDAOImpl implements AddressDAO {

	@Autowired
	HibernateTemplate hibernateTemplate;
	private Session session;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Country> getCountries() {
		session = null;
		List<Country> countries = null;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			countries = (List<Country>) session.createQuery("from Country")
					.list();
		} catch (Exception e) {

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return countries;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Country getCountryById(String id) {
		session = null;
		Country country = null;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			Query query = (Query) session
					.createQuery("from Country where countryID=:id");
			query.setParameter("id", Integer.parseInt(id));
			country = (Country) query.uniqueResult();
		} catch (Exception e) {

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return country;
	}

	/**
	 * 
	 * @param countryName
	 * @return
	 */
	public Country getCountryByName(String countryName) {
		session = null;
		Country country = null;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			Query query = (Query) session
					.createQuery("from Country where countryName=:countryName");
			query.setParameter("countryName", countryName);
			country = (Country) query.uniqueResult();
		} catch (Exception e) {

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return country;
	}

	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<States> getStates() {
		session = null;
		List<States> states = null;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			states = (List<States>) session.createQuery("from States").list();
		} catch (Exception e) {

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return states;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public States getStateById(String id) {
		session = null;
		States state = null;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			Query query = (Query) session
					.createQuery("from States where stateID=:id");
			query.setParameter("id", Integer.parseInt(id));
			state = (States) query.uniqueResult();
		} catch (Exception e) {

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return state;
	}

	/**
	 * 
	 * @param stateName
	 * @return
	 */
	public States getStateByName(String stateName) {
		session = null;
		States state = null;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			Query query = (Query) session
					.createQuery("from Country where stateName=:stateName");
			query.setParameter("stateName", stateName);
			state = (States) query.uniqueResult();
		} catch (Exception e) {

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return state;
	}

	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<District> getDistricts() {
		session = null;
		List<District> districts = null;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			districts = (List<District>) session.createQuery("from District")
					.list();
		} catch (Exception e) {

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return districts;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public District getDistrictById(String id) {
		session = null;
		District district = null;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			Query query = (Query) session
					.createQuery("from District where districtID=:id");
			query.setParameter("districtID", Integer.parseInt(id));
			district = (District) query.uniqueResult();
		} catch (Exception e) {

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return district;
	}

	/**
	 * 
	 * @param stateName
	 * @return
	 */
	public District getDistrictByName(String districtName) {
		session = null;
		District district = null;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			Query query = (Query) session
					.createQuery("from Country where stateName=:stateName");
			query.setParameter("districtName", districtName);
			district = (District) query.uniqueResult();
		} catch (Exception e) {

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return district;
	}

	/**
	 * 
	 * @param id
	 * @param newValue
	 * @param type
	 * @param srcObject
	 * @return
	 */
	@Transactional
	public boolean addLocation(String id, String newValue, String type,
			Object srcObject) {
		boolean isUpdated = false;
		try {
			Session session = hibernateTemplate.getSessionFactory()
					.openSession();
			switch (type) {
			case "country":
				Country country = getCountryById(id);
				if (country != null) {
					country.setCountryName(newValue);
					session.saveOrUpdate(country);
					break;
				}
				country = new Country();
				country.setCountryName(newValue);
				break;
			case "state":
				States state = getStateById(id);
				if (state != null) {
					state.setStateName(newValue);
					session.saveOrUpdate(state);
					break;
				}
				state = new States();
				state.setStateName(newValue);
				state.setCountry((Country) srcObject);
				break;
			case "district":
				District district = getDistrictById(id);
				if (district != null) {
					district.setDistrictName(newValue);
					session.saveOrUpdate(district);
					break;
				}
				district = new District();
				district.setDistrictName(newValue);
				district.setState((States) srcObject);
				break;
			}
			isUpdated = true;
		} catch (Exception e) {

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return isUpdated;

	}
}
