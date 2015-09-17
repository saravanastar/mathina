/**
 * 
 */
package com.ask.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.ask.dbpojo.BillPaidStatus;
import com.ask.dbpojo.ShopBillDetails;
import com.ask.dbpojo.Shops;
import com.ask.dbpojo.StockMaintanence;
import com.ask.dbpojo.VendorProductDetails;
import com.ask.dbpojo.VendorProductItemDetails;
import com.ask.pojo.InvoicePojo;
import com.ask.util.ApplicationConstants;
import com.ask.util.CommonObjectMethods;

/**
 * @author 298651
 * 
 */

@Component
public class InvoiceDAOImpl implements InvoiceDAO {

	@Autowired
	HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ask.dao.InvoiceDAO#saveInvoiceDetails(com.ask.pojo.InvoicePojo)
	 */
	public String saveInvoiceDetails(InvoicePojo pojo) {
		// TODO Auto-generated method stub
		String responseText = ApplicationConstants.SUCCESS_MESSAGE;
		Shops shop = null;
		List<ShopBillDetails> billDetailsList = new ArrayList<ShopBillDetails>();
		Session session = null;
		try {
			 session = hibernateTemplate.getSessionFactory()
					.openSession();
			String className = "ShopBillDetails";
			int count = CommonObjectMethods.getMaxRow(session, className);

			String[] product = pojo.getProductId();
			String[] amount = pojo.getAmount();
			String[] quantity = pojo.getQuantity();
			String[] items = pojo.getItemId();

			session.beginTransaction();
			int remaintAmount = 0;
			for (int i = 0; i < product.length; i++) {
				ShopBillDetails billDetails = new ShopBillDetails();
				VendorProductItemDetails iteDetails = new VendorProductItemDetails();
				VendorProductDetails productDetails = new VendorProductDetails();
				shop = new Shops();
				StockMaintanence stock = new StockMaintanence();
				stock = CommonObjectMethods.getstock(items[i], session);

				if (stock == null) {
					return ApplicationConstants.STOCK_PROBLEM_MESSAGE;
				}

				if (stock != null) {
					stock.setQuantity(stock.getQuantity()
							- Integer.parseInt(quantity[i]));
					if (stock.getQuantity() < 0) {
						return ApplicationConstants.STOCK_PROBLEM_MESSAGE;
						// + " "
						// + stock.getItemDetails().getItemName()
						// + "-"
						// + stock.getItemDetails().getQuantity()
						// + " available is only "
						// + (stock.getQuantity() + Integer
						// .parseInt(quantity[i]));
					}
				}
				if (stock.getDiscountStatus().equalsIgnoreCase("Y")) {
					int disoucntQuantityPer = Integer.parseInt(stock
							.getDiscount().getDiscountPer());
					int disoucntQuantityCount = Integer.parseInt(stock
							.getDiscount().getDiscountCount());
					int billQuantityDiscount = (Integer.parseInt(quantity[i]) / disoucntQuantityPer)
							* disoucntQuantityCount;
					stock.setDiscountQuantity(billQuantityDiscount);
				}
				remaintAmount += Integer.parseInt(amount[i]);
				billDetails.setBillAmount(Integer.parseInt(amount[i]));
				billDetails
						.setBillID(Integer.parseInt(pojo.getBillNumber()[0]));
				billDetails.setId(++count);
				billDetails.setDeliveryDate(pojo.getDateOfPurchase());

				productDetails.setProductId(Integer.parseInt(product[i]));

				iteDetails.setItemId(Integer.parseInt(items[i]));

				double discountAmount = 0;
				if (pojo.getDiscountPercentage() != null
						&& !pojo.getDiscountPercentage().equalsIgnoreCase("0")) {
					discountAmount = Integer.parseInt(pojo
							.getDiscountPercentage());
					double billAMount = billDetails.getBillAmount();
					discountAmount = (billAMount / 100) * discountAmount;
					discountAmount = billAMount - discountAmount;
					billDetails.setBillAmount((int) discountAmount);

				}
				iteDetails.setProductDetails(productDetails);
				stock.setItemDetails(iteDetails);
				stock.setLastUpdatedOn(new Date());
				billDetails.setProductItemDetails(iteDetails);
				billDetails.setQuantityDelivered(Integer.parseInt(quantity[i]));
				shop.setShopID(Integer.parseInt(pojo.getShopId()[0]));
				billDetails.setShop(shop);
				billDetailsList.add(billDetails);
				session.save(billDetails);
				session.update(stock);
			}
			// session.getTransaction().commit();
			// session.beginTransaction();
			double discountAmount = 0;
			if (pojo.getDiscountPercentage() != null
					&& !pojo.getDiscountPercentage().equalsIgnoreCase("0")) {
				discountAmount = Integer.parseInt(pojo.getDiscountPercentage());
				double totalBill = remaintAmount;
				discountAmount = (totalBill / 100) * discountAmount;
				// discountAmount = totalBill-discountAmount;

			}
			className = "BillPaidStatus";
			count = CommonObjectMethods.getMaxRow(session, className);
			BillPaidStatus paidStatus = new BillPaidStatus();
			paidStatus.setId(++count);
			paidStatus.setAmountPaid(0);
			paidStatus.setPaidOn(null);
			paidStatus.setShop(shop);
			paidStatus
					.setRemainingAmount((int) (remaintAmount - discountAmount));
			paidStatus.setBillAmount((int) (remaintAmount - discountAmount));
			paidStatus.setDiscountAmount((int) (discountAmount));
			paidStatus.setBillID(Integer.parseInt(pojo.getBillNumber()[0]));
			paidStatus.setStatus(ApplicationConstants.PENDING_STATUS);
			session.save(paidStatus);

			session.getTransaction().commit();

			session.close();
		} catch (Exception e) {
			responseText = ApplicationConstants.FAILURE_MESSAGE;
			e.printStackTrace();
		}finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return responseText;
	}
	/**
	 * 
	 * @param id
	 * @param billAmount
	 * @param quantity
	 * @return
	 */

	public String saveInvoiceEditDetails(String id, String billAmount,
			String quantity) {

		String responseText = ApplicationConstants.SUCCESS_MESSAGE;
		Session session = null;
		try {
			 session = hibernateTemplate.getSessionFactory()
					.openSession();
			@SuppressWarnings("unchecked")
			List<ShopBillDetails> billDetailsList = session.createQuery("from ShopBillDetails where id = "+id).list();
			
			ShopBillDetails bill =  billDetailsList.get(0);
			@SuppressWarnings("unchecked")
			List<BillPaidStatus> billPaidStatusList = session.createQuery("from BillPaidStatus where billID = "+bill.getBillID() +" and shop.shopID = "+bill.getShop().getShopID()).list();
		
			@SuppressWarnings("unchecked")
			List<StockMaintanence> stockMaintanenceList = session.createQuery("from StockMaintanence where itemDetails.itemId="+ bill.getProductItemDetails().getItemId()).list();
			
			BillPaidStatus billPaidStatus =  billPaidStatusList.get(0);
			StockMaintanence stockMaintanence =  stockMaintanenceList.get(0);
			int existingAmount = bill.getBillAmount();
			int existingQuanntity = bill.getQuantityDelivered();
			
			bill.setBillAmount(bill.getBillAmount()-(existingAmount-Integer.parseInt(billAmount)));
			bill.setQuantityDelivered(bill.getQuantityDelivered()-(existingQuanntity-Integer.parseInt(quantity)));
			billPaidStatus.setBillAmount(billPaidStatus.getBillAmount()-(existingAmount-Integer.parseInt(billAmount)));
			billPaidStatus.setRemainingAmount(billPaidStatus.getRemainingAmount()-(existingAmount-Integer.parseInt(billAmount)));
			stockMaintanence.setQuantity(stockMaintanence.getQuantity()+(existingQuanntity-Integer.parseInt(quantity)));

			session.beginTransaction();
			session.update(stockMaintanence);
			session.update(billPaidStatus);
			session.update(bill);
			session.getTransaction().commit();
			session.close();
			
		} catch (Exception e) {
			responseText = ApplicationConstants.FAILURE_MESSAGE;
			e.printStackTrace();
		}finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return responseText;
	}
	/***
	 * 
	 * @param id
	 * @param billAmount
	 * @param quantity
	 * @return
	 */
	public String removeInvoiceEditDetails(String id, String billAmount,
			String quantity) {

		String responseText = ApplicationConstants.REMOVE_SUCCESS_MESSAGE;
		Session session = null;
		try {
			 session = hibernateTemplate.getSessionFactory()
					.openSession();
			@SuppressWarnings("unchecked")
			List<ShopBillDetails> billDetailsList = session.createQuery("from ShopBillDetails where id = "+id).list();
			
			ShopBillDetails bill =  billDetailsList.get(0);
			@SuppressWarnings("unchecked")
			List<BillPaidStatus> billPaidStatusList = session.createQuery("from BillPaidStatus where billID = "+bill.getBillID() +" and shop.shopID = "+bill.getShop().getShopID()).list();
		
			@SuppressWarnings("unchecked")
			List<StockMaintanence> stockMaintanenceList = session.createQuery("from StockMaintanence where itemDetails.itemId="+ bill.getProductItemDetails().getItemId()).list();
			
			BillPaidStatus billPaidStatus =  billPaidStatusList.get(0);
			StockMaintanence stockMaintanence =  stockMaintanenceList.get(0);
			int existingAmount = bill.getBillAmount();
			int existingQuanntity = bill.getQuantityDelivered();
			
			bill.setBillAmount(bill.getBillAmount()-(existingAmount));
			bill.setQuantityDelivered(bill.getQuantityDelivered()-(existingQuanntity));
			billPaidStatus.setBillAmount(billPaidStatus.getBillAmount()-(existingAmount));
			billPaidStatus.setRemainingAmount(billPaidStatus.getRemainingAmount()-(existingAmount));
			stockMaintanence.setQuantity(stockMaintanence.getQuantity()+(existingQuanntity));

			session.beginTransaction();
			session.update(stockMaintanence);
			session.update(billPaidStatus);
			session.delete(bill);
			session.getTransaction().commit();
			session.close();
			
		} catch (Exception e) {
			responseText = ApplicationConstants.FAILURE_MESSAGE;
			e.printStackTrace();
		}finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return responseText;
	}


}
