/**
 * 
 */
package com.ask.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.ask.dbpojo.Discount;
import com.ask.dbpojo.PurchaseHistory;
import com.ask.dbpojo.StockMaintanence;
import com.ask.dbpojo.VendorBillDetails;
import com.ask.dbpojo.VendorDetails;
import com.ask.dbpojo.VendorProductItemDetails;
import com.ask.pojo.PurchaseData;
import com.ask.util.ApplicationConstants;
import com.ask.util.CommonObjectMethods;

/**
 * @author ASK
 *
 */
@Component
public class PurchaseDAOImpl implements PurchaseDAO {

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
	public String savePurchaseDetails(PurchaseData purchaseData) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		String responseText = ApplicationConstants.SUCCESS_MESSAGE;
		try {
			PurchaseHistory history;
			VendorProductItemDetails items;
			String[] itemId = purchaseData.getItemId();
			String[] discountQuantity = purchaseData.getDiscountQuantity();
			String[] quantity = purchaseData.getQuantity();
			String[] cost = purchaseData.getCost();
			String[] amountPaid = purchaseData.getAmountPaid();
			String[] billNumber = purchaseData.getBillNumber();
			String[] disCountAvailable = purchaseData.getDiscountId();
			String[] discountPerQuantity = purchaseData.getDiscountPer();
			String[] discountQuantityItem = purchaseData.getDiscountItem();
			String[] discountItem = purchaseData.getDiscountItemId();
			String[] otherItem = purchaseData.getOtherItem();
			session.beginTransaction();
			if (purchaseData != null) {
				for (int i = 0; i < itemId.length; i++) {
					history = new PurchaseHistory();
					items = new VendorProductItemDetails();
					items.setItemId(Integer.parseInt(itemId[i]));
					items.setRetailAmount(Integer.parseInt(cost[i])
							/ Integer.parseInt(quantity[i]));
					history.setAmount(Integer.parseInt(cost[i]));
					int count = CommonObjectMethods.getMaxRow(session,
							"PurchaseHistory");
					history.setId(++count);
					history.setItemDetails(items);
					history.setLastUpdatedBy("System");
					history.setPurchasedOn(new Date());
					history.setQuantity(Integer.parseInt(quantity[i]));
					history.setInvoiceNumber(billNumber[i]);
					history.setStatus(ApplicationConstants.PENDING_STATUS);
					if(purchaseData.getAmountPaid()[i].equalsIgnoreCase(purchaseData.getCost()[i])){
						history.setStatus(ApplicationConstants.COMPLETED_STATUS);
					}
					
					
					@SuppressWarnings("unchecked")
					List<Object> stockMaintanenceList = (List<Object>) session
							.createQuery(
									"select stock.id,stock.quantity from StockMaintanence stock,VendorProductItemDetails item1 where item1.itemId = "
											+ itemId[i]
											+ " and item1.itemId=stock.itemDetails.itemId")
							.list();

					StockMaintanence stock;
					if (stockMaintanenceList != null
							&& stockMaintanenceList.size() > 0
							&& stockMaintanenceList.get(0) != null) {
//						int stockId = (Integer) stockMaintanenceList.get(0);
						Object[] split = ((Object[]) stockMaintanenceList.get(0));
					/*	stock = (StockMaintanence) session.get(
								StockMaintanence.class,
								new Integer(stockId));*/
						stock = new StockMaintanence();
						stock.setId((Integer)split[0]);
						stock.setQuantity((Integer)split[1]);
						buildCommonStock(purchaseData, session, items,
								quantity, disCountAvailable,
								discountPerQuantity, discountQuantityItem, i,
								stock, discountItem, otherItem,discountQuantity);
						stock.setItemDetails(items);
					} else {
						stock = new StockMaintanence();
						buildCommonStock(purchaseData, session, items,
								quantity, disCountAvailable,
								discountPerQuantity, discountQuantityItem, i,
								stock, discountItem, otherItem,discountQuantity);
						count = CommonObjectMethods.getMaxRow(session,
								"StockMaintanence");
						stock.setId(++count);
						stock.setItemDetails(items);
						// stockMaintanence.set
//						stock.setDiscountStatus("N");

					}
					VendorBillDetails billDetails = new VendorBillDetails();
					count = CommonObjectMethods.getMaxRow(session,
							"VendorBillDetails");
					billDetails.setId(++count);
					billDetails.setAmountPaid(Integer.parseInt(amountPaid[i]));
					billDetails.setBillAmount(Integer.parseInt(cost[i]));
					billDetails.setBillID(Integer.parseInt(billNumber[i]));
					billDetails.setRemainingAmount(Integer.parseInt(cost[i])
							- Integer.parseInt(amountPaid[i]));
					if(billDetails.getRemainingAmount()>0){
						billDetails.setStatus(ApplicationConstants.PENDING_STATUS);
					}else{
						billDetails.setStatus(ApplicationConstants.COMPLETED_STATUS);
					}
					billDetails.setUpdatedOn(new Date());
					VendorDetails vendor = (VendorDetails) session.load(
							VendorDetails.class,
							Integer.parseInt(purchaseData.getVendorId()));
					billDetails.setVendorDetails(vendor);
					session.save(history);
					if(stock.getDiscount()!=null)
					session.save(stock.getDiscount());
					session.saveOrUpdate(stock);
					session.saveOrUpdate(billDetails);
				}
			}
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			responseText = ApplicationConstants.FAILURE_MESSAGE;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
//		responseText = "Data Saved Successfully";
		return responseText;

	}

	/**
	 * @param purchaseData
	 * @param session
	 * @param items
	 * @param quantity
	 * @param disCountAvailable
	 * @param discountPerQuantity
	 * @param discountQuantityItem
	 * @param i
	 * @param stock
	 */
	private void buildCommonStock(PurchaseData purchaseData, Session session,
			VendorProductItemDetails items, String[] quantity,
			String[] disCountAvailable, String[] discountPerQuantity,
			String[] discountQuantityItem, int i, StockMaintanence stock,
			String[] discountItem, String[] otherItem,String[] discountQuantity) {
		int quan = stock.getQuantity() ;
		stock.setQuantity(quan+ Integer.parseInt(quantity[i]));
		stock.setLastUpdatedOn(new Date());
		stock.setDiscountStatus("N");
		if (purchaseData.getDiscountId() != null
				&& disCountAvailable[i].equalsIgnoreCase("1")) {
			stock.setDiscountStatus("Y");
//			stock.setDiscountQuantity((Integer.parseInt(quantity[i]) / Integer
//					.parseInt(discountPerQuantity[i]))
//					* Integer.parseInt(discountQuantity[i]));
			stock.setDiscountQuantity(Integer.parseInt(discountQuantity[i]));
			// Discount discount = buildDiscountRecord(purchaseData, session,
			// items);
			Discount discount = buildDiscountRecord(session, items,
					discountPerQuantity, discountQuantityItem, i, discountItem,
					otherItem);
			stock.setDiscount(discount);
		}
	}

	/**
	 * @param session
	 * @param items
	 * @param discountPerQuantity
	 * @param discountQuantity
	 * @param i
	 * @param discountItem
	 * @param otherItem
	 * @return
	 */
	private Discount buildDiscountRecord(Session session,
			VendorProductItemDetails items, String[] discountPerQuantity,
			String[] discountQuantity, int i, String[] discountItem,
			String[] otherItem) {
		Discount discount = new Discount();
		discount.setDiscountCount(discountQuantity[i]);
		discount.setDiscountPer(discountPerQuantity[i]);
		discount.setItemDetails(items);
		discount.setItemId(Integer.parseInt(discountItem[i]));
		discount.setItemName(otherItem[i]);
		int count = CommonObjectMethods.getMaxRow(session, "Discount");
		discount.setId(++count);
		discount.setLastUpdatedBy("System");
		discount.setLastUpdatedOn(new Date());
		return discount;
	}
	
	/**
	 * 
	 * @param id
	 * @param billAmount
	 * @param quantity
	 * @return
	 */

	public String savePurchaseEditDetails(String id, String billAmount,
			String quantity,String discountQuantity) {

		String responseText = ApplicationConstants.SUCCESS_MESSAGE;
		Session session = null;
		try {
			 session = hibernateTemplate.getSessionFactory()
					.openSession();
			@SuppressWarnings("unchecked")
			List<PurchaseHistory>  purchaseHistories = session.createQuery("from PurchaseHistory where id = "+id).list();
			
			PurchaseHistory purchaseHistory =  purchaseHistories.get(0);
			
		
			@SuppressWarnings("unchecked")
			List<StockMaintanence> stockMaintanenceList = session.createQuery("from StockMaintanence where itemDetails.itemId="+ purchaseHistory.getItemDetails().getItemId()).list();
			

			StockMaintanence stockMaintanence =  stockMaintanenceList.get(0);
			int existingQuanntity = purchaseHistory.getQuantity();
			int existingAmount = purchaseHistory.getAmount();
			int existingDiscount = purchaseHistory.getDiscountQuantity();
			
			purchaseHistory.setAmount(purchaseHistory.getAmount()-(existingAmount-Integer.parseInt(billAmount)));
			purchaseHistory.setQuantity(purchaseHistory.getQuantity()-(existingQuanntity-Integer.parseInt(quantity)));
			purchaseHistory.setDiscountQuantity(purchaseHistory.getDiscountQuantity()-(existingDiscount-Integer.parseInt(discountQuantity)));
		
			stockMaintanence.setQuantity(stockMaintanence.getQuantity()-(existingQuanntity-Integer.parseInt(quantity)));
			stockMaintanence.setDiscountQuantity(stockMaintanence.getDiscountQuantity()-(existingDiscount-Integer.parseInt(discountQuantity)));

			session.beginTransaction();
			session.update(stockMaintanence);
			session.update(purchaseHistory);
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
	public String removePurchaseEditDetails(String id, String billAmount,
			String quantity) {

		String responseText = ApplicationConstants.REMOVE_SUCCESS_MESSAGE;
		Session session = null;
		try {
			 session = hibernateTemplate.getSessionFactory()
					.openSession();
			@SuppressWarnings("unchecked")
			List<PurchaseHistory>  purchaseHistories = session.createQuery("from PurchaseHistory where id = "+id).list();

			PurchaseHistory purchaseHistory =  purchaseHistories.get(0);
			@SuppressWarnings("unchecked")
			List<StockMaintanence> stockMaintanenceList = session.createQuery("from StockMaintanence where itemDetails.itemId="+ purchaseHistory.getItemDetails().getItemId()).list();
			
			StockMaintanence stockMaintanence =  stockMaintanenceList.get(0);
			int existingQuanntity = purchaseHistory.getQuantity();
//			int existingAmount = purchaseHistory.getAmount();
			int existingDiscount = purchaseHistory.getDiscountQuantity();
			
//			purchaseHistory.setAmount(purchaseHistory.getAmount()-(existingAmount-Integer.parseInt(billAmount)));
//			purchaseHistory.setQuantity(purchaseHistory.getQuantity()-(existingQuanntity-Integer.parseInt(quantity)));
//			purchaseHistory.setDiscountQuantity(purchaseHistory.getDiscountQuantity()-(existingDiscount-Integer.parseInt(discountQuantity)));
		
			stockMaintanence.setQuantity(stockMaintanence.getQuantity()-(existingQuanntity));
			stockMaintanence.setDiscountQuantity(stockMaintanence.getDiscountQuantity()-(existingDiscount));


			session.beginTransaction();
			session.update(stockMaintanence);
			session.delete(purchaseHistory);
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
