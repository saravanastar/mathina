/**
 * 
 */
package com.ask.mtradus.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ask.mtradus.dbpojo.Address;
import com.ask.mtradus.dbpojo.Country;
import com.ask.mtradus.dbpojo.District;
import com.ask.mtradus.dbpojo.States;
import com.ask.mtradus.exception.BusinessException;

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
	public Country getCountryById(int id) {
		session = null;
		Country country = null;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			Query query = (Query) session
					.createQuery("from Country where countryID=:id");
			query.setParameter("id", id);
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
	public States getStateById(int id) {
		session = null;
		States state = null;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			Query query = (Query) session
					.createQuery("from States where stateID=:id");
			query.setParameter("id", id);
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
					.createQuery("from States where stateName=:stateName");
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
	public District getDistrictById(int id) {
		session = null;
		District district = null;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			Query query = (Query) session
					.createQuery("from District where districtID=:id");
			query.setParameter("id", id);
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
					.createQuery("from District where districtName=:districtName");
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
	 */
	@Transactional
	public boolean addCountry(Country country) {
		Session session = null;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			session.saveOrUpdate(country);
		} catch (Exception e) {
			throw new BusinessException();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
	}

	@Transactional
	public boolean addAddressDetails(Address address) {
		Session session = null;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			session.saveOrUpdate(address);
		} catch (Exception e) {
			throw new BusinessException();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
	}
	
	/**
	 * 
	 */
	@Transactional
	public boolean addState(States state) {
		Session session = null;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			session.saveOrUpdate(state);
		} catch (ConstraintViolationException violationException) {

		} catch (Exception e) {
			throw new BusinessException();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
	}

	/**
	 * 
	 */
	@Transactional
	public boolean addDistrict(District district) {
		Session session = null;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			session.saveOrUpdate(district);
		} catch (Exception e) {
			throw new BusinessException();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
	}

	@Override
	public Address getAddressDetailsById(int addressId) {
		session = null;
		Address address = null;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			Query query = (Query) session
					.createQuery("from Address where id=:id");
			query.setParameter("id", addressId);
			address = (Address) query.uniqueResult();
		} catch (Exception e) {

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return address;
	}

	@Override
	public void removeCountryDetails(String countryId) {
		Session session = null;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			Query query = session
					.createQuery("delete from Country where countryID = :countryID");
			query.setInteger("countryID", Integer.parseInt(countryId));
			query.executeUpdate();
		} catch (Exception e) {

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void removeAddressDetails(String addressId) {
		Session session = null;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			Query query = session
					.createQuery("delete from Address where id = :addressId");
			query.setInteger("addressId", Integer.parseInt(addressId));
			query.executeUpdate();
		} catch (Exception e) {

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Address> getAddressesArea() {
		session = null;
		List<Address> addressDetails = null;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			addressDetails = (List<Address>) session
					.createQuery("from Address").list();
		} catch (Exception e) {

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return addressDetails;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Address getAddressById(int id) {
		session = null;
		Address address = null;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			Query query = (Query) session
					.createQuery("from Address where id=:id");
			query.setParameter("id", id);
			address = (Address) query.uniqueResult();
		} catch (Exception e) {

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return address;
	}

	/**
	 * 
	 * @param areaName
	 * @return
	 */
	public Address getAddressByName(String areaName) {
		session = null;
		Address address = null;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			Query query = (Query) session
					.createQuery("from Address where areaName=:areaName");
			query.setParameter("areaName", areaName);
			address = (Address) query.uniqueResult();
		} catch (Exception e) {

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return address;
	}

	@Override
	public void removeStateDetails(String stateId) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			Query query = session
					.createQuery("delete from States where stateID = :stateId");
			query.setInteger("stateId", Integer.parseInt(stateId));
			query.executeUpdate();
		} catch (Exception e) {

		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	@Override
	public void removeDistrictDetails(String districtID) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			Query query = session
					.createQuery("delete from District where districtID = :districtID");
			query.setInteger("districtID", Integer.parseInt(districtID));
			query.executeUpdate();
		} catch (Exception e) {

		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

}
