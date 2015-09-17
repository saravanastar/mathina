/**
 * 
 */
package com.ask.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.ask.pojo.InvoicePojo;
import com.ask.util.CommonObjectMethods;

/**
 * @author 298651
 * 
 */
@Component
public class ReportsDAOImpl implements ReportsDAO {

	@Autowired
	HibernateTemplate hibernateTemplate;
	private Session session;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ask.dao.ReportsDAO#getInvoiceReport()
	 */
	public List<Object> getInvoiceReport() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Object> loadPaidStatusReport(InvoicePojo pojo) {
		// TODO Auto-generated method stub
		boolean isDateAvailable = false;
		session = hibernateTemplate.getSessionFactory().openSession();
		String queryString = "select area1.district.districtName,area1.areaName,status.shop.shopName,status.billID,status.billAmount,status.amountPaid,status.remainingAmount,"
				+ "status.status,status.paidOn from BillPaidStatus status,Area area1 where ";
		if (pojo.getBillNumber() != null
				&& !pojo.getBillNumber()[0].equalsIgnoreCase("")) {
			queryString += " status.billID = " + pojo.getBillNumber()[0]
					+ " and";
		} else if (pojo.getShopId() != null
				&& !pojo.getShopId()[0].equalsIgnoreCase("")) {
			queryString += "  status.shop.shopID = " + pojo.getShopId()[0]
					+ " and";
		}
		if (pojo.getFromDate() != null
				&& !pojo.getFromDate().equalsIgnoreCase("")) {
			isDateAvailable = true;
			queryString += " status.paidOn between :startDate  and :endDate and ";

		}
		queryString += "  area1.areaId=status.shop.area.areaId";
		Query query = session.createQuery(queryString);
		if (isDateAvailable) {
			query.setDate("startDate",
					CommonObjectMethods.convertStringToDate(pojo.getFromDate()));
			query.setDate("endDate",
					CommonObjectMethods.convertStringToDate(pojo.getToDate()));
		}
		@SuppressWarnings("unchecked")
		List<Object> object = query.list();
		session.close();
		return object;
	}

	public List<Object> loadProductSalesReport(InvoicePojo pojo) {
		// TODO Auto-generated method stub
		boolean isDateAvailable = false;
		session = hibernateTemplate.getSessionFactory().openSession();
		String queryString = "select vendor.vendorName,product.productName,item.itemName +'  ' + item.quantity,bill.quantityDelivered,bill.billID,bill.shop.shopName,bill.billAmount "
				+ "from ShopBillDetails bill,VendorProductItemDetails item,VendorProductDetails product,VendorDetails vendor where ";
		if (pojo.getItemId() != null
				&& !pojo.getItemId()[0].equalsIgnoreCase("")) {

			queryString += "  item.itemId = " + pojo.getItemId()[0] + " and ";
		} else if (pojo.getProductId() != null
				&& !pojo.getProductId()[0].equalsIgnoreCase("")) {
			queryString += " product.productId = " + pojo.getProductId()[0]
					+ " and ";
		} else if (pojo.getVendorId() != null
				&& !pojo.getVendorId().equalsIgnoreCase("")) {
			queryString += " vendor.vendorId = " + pojo.getVendorId() + " and ";
		}
		if (pojo.getFromDate() != null
				&& !pojo.getFromDate().equalsIgnoreCase("")) {
			isDateAvailable = true;
			queryString += " bill.deliveryDate between :startDate  and :endDate and ";
		}
		queryString += " bill.productItemDetails.itemId = item.itemId and item.productDetails.productId=product.productId and product.vendorDetails.vendorId=vendor.vendorId";
		Query query = session.createQuery(queryString);
		if (isDateAvailable) {
			query.setDate("startDate",
					CommonObjectMethods.convertStringToDate(pojo.getFromDate()));
			query.setDate("endDate",
					CommonObjectMethods.convertStringToDate(pojo.getToDate()));
		}
		@SuppressWarnings("unchecked")
		List<Object> object = query.list();
		session.close();
		return object;
	}

	/**
	 * 
	 * @param pojo
	 * @return
	 */
	public List<Object> getPurchaseData(InvoicePojo pojo) {

		boolean isDateAvailable = false;
		session = hibernateTemplate.getSessionFactory().openSession();
		String queryString = "select vendor.vendorName,product.productName,item1.itemName+' - '+item1.quantity,purchase.invoiceNumber,"
				+ "purchase.quantity,purchase.amount,purchase.purchasedOn "
				+ "from PurchaseHistory purchase,VendorProductItemDetails item1,VendorProductDetails product,"
				+ "VendorDetails vendor where ";
		if (pojo.getItemId() != null
				&& !pojo.getItemId()[0].equalsIgnoreCase("")) {

			queryString += "  purchase.itemDetails.itemId = " + pojo.getItemId()[0] + " and ";
		} else if (pojo.getProductId() != null
				&& !pojo.getProductId()[0].equalsIgnoreCase("")) {
			queryString += " purchase.itemDetails.productDetails.productId = " + pojo.getProductId()[0]
					+ " and ";
		} else if (pojo.getVendorId() != null
				&& !pojo.getVendorId().equalsIgnoreCase("")) {
			queryString += " purchase.itemDetails.productDetails.vendorDetails.vendorId = " + pojo.getVendorId() + " and ";
		}
		if (pojo.getFromDate() != null
				&& !pojo.getFromDate().equalsIgnoreCase("")) {
			isDateAvailable = true;
			queryString += " purchase.purchasedOn between :startDate  and :endDate and ";

		}
		queryString += " purchase.itemDetails.itemId = item1.itemId and item1.productDetails.productId = product.productId and product.vendorDetails.vendorId = vendor.vendorId";
		Query query = session.createQuery(queryString);
		if (isDateAvailable) {
			query.setDate("startDate",
					CommonObjectMethods.convertStringToDate(pojo.getFromDate()));
			query.setDate("endDate",
					CommonObjectMethods.convertStringToDate(pojo.getToDate()));
		}
		@SuppressWarnings("unchecked")
		List<Object> object = query.list();
		return object;

	}

	/**
	 * 
	 * @param pojo
	 * @return
	 */
	public List<Object> loadPCashCollectionReport(InvoicePojo pojo) {
		// TODO Auto-generated method stub
		boolean isDateAvailable = false;
		session = hibernateTemplate.getSessionFactory().openSession();
		String queryString = "select area1.district.districtName,area1.areaName,status.shop.shopName,status.billID,status.amountPaid,"
				+ "status.paidOn from BillPaidHistory status,Area area1 where ";
		if (pojo.getBillNumber() != null
				&& !pojo.getBillNumber()[0].equalsIgnoreCase("")) {
			queryString += " status.billID = " + pojo.getBillNumber()[0]
					+ " and";
		} else if (pojo.getShopId() != null
				&& !pojo.getShopId()[0].equalsIgnoreCase("")) {
			queryString += "  status.shop.shopID = " + pojo.getShopId()[0]
					+ " and";
		}
		if (pojo.getFromDate() != null
				&& !pojo.getFromDate().equalsIgnoreCase("")) {
			isDateAvailable = true;
			queryString += " status.paidOn between :startDate  and :endDate and ";

		}
		queryString += "  area1.areaId=status.shop.area.areaId";
		Query query = session.createQuery(queryString);
		if (isDateAvailable) {
			query.setDate("startDate",
					CommonObjectMethods.convertStringToDate(pojo.getFromDate()));
			query.setDate("endDate",
					CommonObjectMethods.convertStringToDate(pojo.getToDate()));
		}
		@SuppressWarnings("unchecked")
		List<Object> object = query.list();
		session.close();
		return object;
	}

	/**
	 * 
	 * @param pojo
	 * @return
	 */
	public List<Object> getInventoryData(InvoicePojo pojo) {

		boolean isDateAvailable = false;
		session = hibernateTemplate.getSessionFactory().openSession();
		String queryString = "select vendor.vendorName,product.productName,item1.itemName+' - '+item1.quantity,stock.quantity+stock.discountQuantity,stock.quantity,"
				+ "stock.discountQuantity,stock.discountStatus,stock.lastUpdatedOn "
				+ "from StockMaintanence stock,VendorProductItemDetails item1,VendorProductDetails product,"
				+ "VendorDetails vendor where ";
		if (pojo.getItemId() != null
				&& !pojo.getItemId()[0].equalsIgnoreCase("")) {

			queryString += "  item1.itemId = " + pojo.getItemId()[0] + " and ";
		} else if (pojo.getProductId() != null
				&& !pojo.getProductId()[0].equalsIgnoreCase("")) {
			queryString += " product.productId = " + pojo.getProductId()[0]
					+ " and ";
		} else if (pojo.getVendorId() != null
				&& !pojo.getVendorId().equalsIgnoreCase("")) {
			queryString += " vendor.vendorId = " + pojo.getVendorId() + " and ";
		}
		if (pojo.getFromDate() != null
				&& !pojo.getFromDate().equalsIgnoreCase("")) {
			isDateAvailable = true;
			queryString += " stock.lastUpdatedOn between :startDate  and :endDate and ";

		}
		queryString += " stock.itemDetails.itemId = item1.itemId and item1.productDetails.productId = product.productId and product.vendorDetails.vendorId = vendor.vendorId";
		Query query = session.createQuery(queryString);
		if (isDateAvailable) {
			query.setDate("startDate",
					CommonObjectMethods.convertStringToDate(pojo.getFromDate()));
			query.setDate("endDate",
					CommonObjectMethods.convertStringToDate(pojo.getToDate()));
		}
		@SuppressWarnings("unchecked")
		List<Object> object = query.list();
		return object;

	}

	@SuppressWarnings("unchecked")
	public List<Object> loadMiscellenousReport(InvoicePojo pojo) {
		// TODO Auto-generated method stub
		boolean isDateAvailable = false;
		List<Object> object =null;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			String queryString = "select itemName,quantity,itemPrice,createdOn from Miscellenous";
			if (pojo.getFromDate() != null
					&& !pojo.getFromDate().equalsIgnoreCase("")) {
				isDateAvailable = true;
				queryString += " where createdOn between :startDate  and :endDate and ";

			}
			Query query = session.createQuery(queryString);
			if (isDateAvailable) {
				query.setDate("startDate", CommonObjectMethods
						.convertStringToDate(pojo.getFromDate()));
				query.setDate("endDate", CommonObjectMethods
						.convertStringToDate(pojo.getToDate()));
			}
			
			 object = query.list();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return object;
	}
}
