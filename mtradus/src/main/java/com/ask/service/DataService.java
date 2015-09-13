package com.ask.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ask.dao.DataDAOImpl;
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
import com.google.gson.JsonElement;

@Service
public class DataService {

	@Autowired
	DataDAOImpl dataDao;

	public DataDAOImpl getDataDao() {
		return dataDao;
	}
	/**
	 * 
	 * @param dataDao
	 */
	public void setDataDao(DataDAOImpl dataDao) {
		this.dataDao = dataDao;
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<District> getAllDistrictById(String id) {
		return dataDao.getAllDistrict(id);
	}
	/**
	 * 
	 * @return
	 */
	public List<Country> getAllCountries() {
		return dataDao.getAllCountries();
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<States> getAllStatesById(String id) {
		return dataDao.getAllStates(id);
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<Area> getAllAreasById(String id) {
		return dataDao.getAllAreasById(id);
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<Shops> getAllShopsById(String id) {
		// TODO Auto-generated method stub
		return dataDao.getAllShopsById(id);
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<Object> getAllCompainesByShopId(String id) {
		// TODO Auto-generated method stub
		return dataDao.getAllCompainesByShopId(id);
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<Object> getAllBillNumbersByShopId(String id) {
		// TODO Auto-generated method stub
		return dataDao.getAllBillNumbersByShopId(id);
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<Object> getSearchedBillNumbersDetails(String id) {
		// TODO Auto-generated method stub
		return dataDao.getSearchedBillNumbersDetails(id);
	}
	/**
	 * 
	 * @return
	 */
	public List<VendorDetails> getVendorList(){
		return dataDao.getVendorList();
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<VendorProductDetails> getProductByVendor(String id) {
		// TODO Auto-generated method stub
		return dataDao.getProductByVendor(id);
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<VendorProductItemDetails> getItemByProduct(String id) {
		// TODO Auto-generated method stub
		return dataDao.getItemByProduct(id);
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<ShopBillDetails> getInvoiceDetails(String id) {
		// TODO Auto-generated method stub
		return dataDao.getInvoiceDetails(id);
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<BillPaidHistory> getBillingDetails(String id) {
		// TODO Auto-generated method stub
		return dataDao.getBillingDetails(id);
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<PurchaseHistory> getPurchaseDetails(String id) {
		// TODO Auto-generated method stub
		return dataDao.getPurchaseDetails(id);
	}
	public List<VendorProductItemDetails> getItemData(String vendorId, String productId,
			String itemId) {
		// TODO Auto-generated method stub
		return dataDao.getItemData(vendorId,productId,itemId);
	}
	
}
