/**
 * 
 */
package com.ask.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.ask.dbpojo.Area;
import com.ask.dbpojo.BillPaidHistory;
import com.ask.dbpojo.Country;
import com.ask.dbpojo.District;
import com.ask.dbpojo.PurchaseHistory;
import com.ask.dbpojo.ShopBillDetails;
import com.ask.dbpojo.Shops;
import com.ask.dbpojo.States;
import com.ask.dbpojo.VendorDetails;
import com.ask.dbpojo.VendorProductDetails;
import com.ask.dbpojo.VendorProductItemDetails;

/**
 * @author 298651
 * 
 */
@Component
public class DataDAOImpl implements DataDAO {

	@Autowired
	HibernateTemplate hibernateTmeplate;

	public HibernateTemplate getHibernateTmeplate() {
		return hibernateTmeplate;
	}

	public void setHibernateTmeplate(HibernateTemplate hibernateTmeplate) {
		this.hibernateTmeplate = hibernateTmeplate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ask.dao.DataDAO#getAllDistrict()
	 */
	/**
	 * 
	 */
	public List<District> getAllDistrict(String id) {
		// TODO Auto-generated method stub
		Session session = hibernateTmeplate.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		// List<District> districtList =
		// session.createCriteria(District.class).add(Restrictions.eq("districtID",Integer.parseInt(id))).list();
		List<District> districtList = session.createQuery(
				"from District district where district.state.stateID="
						+ Integer.parseInt(id)).list();
		session.close();
		return districtList;
	}

	/**
	 * 
	 * @return
	 */
	public List<Country> getAllCountries() {
		// TODO Auto-generated method stub
		Session session = hibernateTmeplate.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Country> countryList = session.createCriteria(Country.class)
				.list();
		session.close();
		return countryList;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<States> getAllStates(String id) {
		// TODO Auto-generated method stub
		Session session = hibernateTmeplate.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		// List<States> statesList =
		// session.createCriteria(States.class).add(Restrictions.eq(,Integer.parseInt(id))).list();
		List<States> statesList = session.createQuery(
				"from States state where state.country.countryID="
						+ Integer.parseInt(id)).list();
		session.close();
		return statesList;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<Area> getAllAreasById(String id) {
		// TODO Auto-generated method stub
		Session session = hibernateTmeplate.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		// List<Area> areaList =
		// session.createCriteria(Area.class).add(Restrictions.eq("areaId",Integer.parseInt(id))).list();
		List<Area> areaList = session
				.createQuery(
						"from Area area,District district1,States state,Country country  where  area.district.districtID="
								+ Integer.parseInt(id)
								+ " and district1.state.stateID=state.stateID and state.country.countryID = country.countryID")
				.list();

		session.close();
		return areaList;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Shops> getAllShopsById(String id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Session session = hibernateTmeplate.getSessionFactory().openSession();
		String query = "from Shops";
		List<Shops> shopsList = null;
		// List<States> statesList =
		// session.createCriteria(States.class).add(Restrictions.eq(,Integer.parseInt(id))).list();
		if (id != null && !id.equalsIgnoreCase("")) {
			query += " where area.areaId=" + Integer.parseInt(id);
		}
		shopsList = session.createQuery(query).list();

		session.close();
		return shopsList;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Object> getAllCompainesByShopId(String id) {

		Session session = hibernateTmeplate.getSessionFactory().openSession();
		List<Object> vendors;

		// List<States> statesList =
		// session.createCriteria(States.class).add(Restrictions.eq(,Integer.parseInt(id))).list();

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder
				.append("select productDetails.productId,productDetails.productName,vendor.vendorId,vendor.vendorName,productmap.productCost,itemDetails.itemId,itemDetails.itemName,itemDetails.quantity,productmap.id,productmap.shop.shopName,productmap.percentage from ShopProductMap productmap,Shops shop,");
		stringBuilder
				.append("VendorProductDetails productDetails,VendorProductItemDetails itemDetails");
		stringBuilder.append(",VendorDetails vendor where ");
		if (id != null && !id.equalsIgnoreCase("")) {
			stringBuilder
					.append("shop.shopID=" + Integer.parseInt(id) + " and");
		}
		stringBuilder.append("  shop.shopID = productmap.shop.shopID");
		stringBuilder
				.append(" and productmap.vendorItemProduct.itemId = itemDetails.itemId");
		stringBuilder
				.append(" and itemDetails.productDetails.productId = productDetails.productId");
		stringBuilder
				.append(" and productDetails.vendorDetails.vendorId = vendor.vendorId");
		vendors = session.createQuery(stringBuilder.toString()).list();
		session.close();
		return vendors;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<Shops> getAllProductById(String id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Session session = hibernateTmeplate.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		// List<States> statesList =
		// session.createCriteria(States.class).add(Restrictions.eq(,Integer.parseInt(id))).list();
		List<Shops> shopsList = session
				.createQuery(
						"select shop.shopID as shopID,shop.shopName as shopName from Shops shop,Area area1,District district1,States state,Country country  where shop.area.areaId="
								+ Integer.parseInt(id)
								+ "and area1.district.districtID = district1.districtID and district1.state.stateID=state.stateID and state.country.countryID = country.countryID")
				.list();

		session.close();
		return shopsList;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<Object> getAllBillNumbersByShopId(String id) {
		// TODO Auto-generated method stub
		Session session = hibernateTmeplate.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Object> billNumberList = session.createQuery(
				"select id,billID from BillPaidStatus where shop.shopID = "
						+ id).list();
		session.close();
		return billNumberList;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<Object> getSearchedBillNumbersDetails(String id) {
		// TODO Auto-generated method stub
		Session session = hibernateTmeplate.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Object> billNumberList = session
				.createQuery(
						"select status.id,status.billID, shop1.shopID,shop1.shopName,area1.areaId,area1.areaName,district1.districtID,district1.districtName,state1.stateID,state1.stateName,country1.countryID,country1.countryName "
								+ " from BillPaidStatus status,Shops shop1,Area area1,District district1,States state1,Country country1"
								+ " where status.billID = "
								+ id
								+ " and status.shop.shopID = shop1.shopID and shop1.area.areaId=area1.areaId "
								+ "and area1.district.districtID = district1.districtID and district1.state.stateID=state1.stateID and state1.country.countryID = country1.countryID")
				.list();
		session.close();
		return billNumberList;
	}

	/**
	 * 
	 * @return
	 */
	public List<VendorDetails> getVendorList() {
		Session session = null;
		try {
			session = hibernateTmeplate.getSessionFactory().openSession();
			String string = "from VendorDetails";
			@SuppressWarnings("unchecked")
			List<VendorDetails> vendorList = session.createQuery(string).list();
			session.close();
			return vendorList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return null;

	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<VendorProductDetails> getProductByVendor(String id) {
		Session session = null;
		try {
			session = hibernateTmeplate.getSessionFactory().openSession();
			String string = "from VendorProductDetails where vendorDetails.vendorId = "
					+ id;
			@SuppressWarnings("unchecked")
			List<VendorProductDetails> vendorList = session.createQuery(string)
					.list();
			session.close();
			return vendorList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return null;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<VendorProductItemDetails> getItemByProduct(String id) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = hibernateTmeplate.getSessionFactory().openSession();
			String string = "from VendorProductItemDetails";
			if (id != null && !id.equalsIgnoreCase(""))
				string += " where productDetails.productId = " + id;
			@SuppressWarnings("unchecked")
			List<VendorProductItemDetails> vendorList = session.createQuery(
					string).list();
			session.close();
			return vendorList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return null;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<ShopBillDetails> getInvoiceDetails(String id) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = hibernateTmeplate.getSessionFactory().openSession();
			String string = "from ShopBillDetails where billID = " + id;
			@SuppressWarnings("unchecked")
			List<ShopBillDetails> shopBillDetails = session.createQuery(string)
					.list();
			session.close();
			return shopBillDetails;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return null;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<BillPaidHistory> getBillingDetails(String id) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = hibernateTmeplate.getSessionFactory().openSession();
			String string = "from BillPaidHistory where billID = " + id;
			@SuppressWarnings("unchecked")
			List<BillPaidHistory> billPaidHistories = session.createQuery(
					string).list();
			session.close();
			return billPaidHistories;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return null;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<PurchaseHistory> getPurchaseDetails(String id) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = hibernateTmeplate.getSessionFactory().openSession();
			String string = "from PurchaseHistory where invoiceNumber = '" + id
					+ "'";
			@SuppressWarnings("unchecked")
			List<PurchaseHistory> purchaseHistories = session.createQuery(
					string).list();
			session.close();
			return purchaseHistories;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return null;
	}

	public List<VendorProductItemDetails> getItemData(String vendorId,
			String productId, String itemId) {
		Session session = null;
		try {
			session = hibernateTmeplate.getSessionFactory().openSession();
			String queryString = "from VendorProductItemDetails";
			if (itemId != null && !itemId.equalsIgnoreCase("")) {

				queryString += " where itemId = " + itemId;
			} else if (productId != null && !productId.equalsIgnoreCase("")) {
				queryString += " where productDetails.productId = " + productId;

			} else if (vendorId != null && !vendorId.equalsIgnoreCase("")) {
				queryString += " where productDetails.vendorDetails.vendorId = "
						+ vendorId;
			}
			@SuppressWarnings("unchecked")
			List<VendorProductItemDetails> itemDetails = session.createQuery(
					queryString).list();
			return itemDetails;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return null;
	}
}
