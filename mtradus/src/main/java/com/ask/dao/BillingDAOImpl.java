/**
 * 
 */
package com.ask.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.ask.dbpojo.BillPaidHistory;
import com.ask.dbpojo.BillPaidStatus;
import com.ask.pojo.InvoicePojo;
import com.ask.util.ApplicationConstants;
import com.ask.util.CommonObjectMethods;

/**
 * @author ASK
 * 
 */
@Component
public class BillingDAOImpl implements BillingDAO {

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
	 * @see com.ask.dao.BillingDAO#saveBillingData(com.ask.pojo.InvoicePojo)
	 */
	public String saveBillingData(InvoicePojo pojo) {
		// TODO Auto-generated method stub
		String responseText = ApplicationConstants.SUCCESS_MESSAGE;
		Session session = hibernateTmeplate.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			String[] billNumber = pojo.getBillNumber();
			for (int i = 0; i < billNumber.length; i++) {

				Query query = session
						.createQuery("from BillPaidStatus where id = "
								+ pojo.getBillNumber()[i]+" and shop.shopID = "+pojo.getShopId()[i]);
				@SuppressWarnings("unchecked")
				List<BillPaidStatus> paidStatusList = query.list();
				if (paidStatusList != null && paidStatusList.size() > 0
						&& paidStatusList.get(0) != null) {

					BillPaidStatus paidStatus = paidStatusList.get(0);
					paidStatus.setAmountPaid(paidStatus.getAmountPaid()
							+ Integer.parseInt(pojo.getAmount()[i]));
					int billNumberId = paidStatus.getBillID();
					paidStatus.setRemainingAmount(paidStatus
							.getRemainingAmount()
							- Integer.parseInt(pojo.getAmount()[i]));
					if (paidStatus.getRemainingAmount() > 0) {
						paidStatus
								.setStatus(ApplicationConstants.PENDING_STATUS);
					} else {
						paidStatus
								.setStatus(ApplicationConstants.COMPLETED_STATUS);
					}
					paidStatus.setPaidOn(new Date());
					session.update(paidStatus);

					BillPaidHistory billPaidHistory = new BillPaidHistory();
					String className = "BillPaidHistory";
					int count = CommonObjectMethods.getMaxRow(session,
							className);
					billPaidHistory.setAmountPaid(Integer.parseInt(pojo
							.getAmount()[i]));
					billPaidHistory.setBillID(billNumberId);
					billPaidHistory.setId(++count);
					billPaidHistory.setPaidOn(new Date());
					billPaidHistory.setShop(paidStatus.getShop());
					session.saveOrUpdate(billPaidHistory);

				}
			}
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			responseText = ApplicationConstants.FAILURE_MESSAGE;
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return responseText;
	}
	public String saveEditedBillingData(String id,String billAmount,String shopId) {
		// TODO Auto-generated method stub
		String responseText = ApplicationConstants.SUCCESS_MESSAGE;
		Session session = hibernateTmeplate.getSessionFactory().openSession();
		try {
			String string = "from BillPaidHistory where id = "+id;
			@SuppressWarnings("unchecked")
			List<BillPaidHistory> paidHistories = session.createQuery(string).list();
			
			BillPaidHistory paidHistory = paidHistories.get(0);
			
			@SuppressWarnings("unchecked")
			List<BillPaidStatus> billPaidStatusList = session.createQuery("from BillPaidStatus where billID = "+paidHistory.getBillID() +" and shop.shopID = "+paidHistory.getShop().getShopID()).list();
			BillPaidStatus billPaidStatus =  billPaidStatusList.get(0);
			
			int existingAmount = paidHistory.getAmountPaid();
//			int existingQuanntity = bill.getQuantityDelivered();
			
			paidHistory.setAmountPaid(paidHistory.getAmountPaid()-(existingAmount-Integer.parseInt(billAmount)));
//			billPaidStatus.setBillAmount(billPaidStatus.getBillAmount()-(existingAmount-Integer.parseInt(billAmount)));
			billPaidStatus.setRemainingAmount(billPaidStatus.getRemainingAmount()+(existingAmount-Integer.parseInt(billAmount)));
			billPaidStatus.setStatus(ApplicationConstants.COMPLETED_STATUS);
			if(billPaidStatus.getRemainingAmount()>0){
				billPaidStatus.setStatus(ApplicationConstants.PENDING_STATUS);
			}
			billPaidStatus.setAmountPaid(billPaidStatus.getBillAmount()-billPaidStatus.getRemainingAmount());
			session.beginTransaction();
			session.update(billPaidStatus);
			session.update(paidHistory);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			responseText = ApplicationConstants.FAILURE_MESSAGE;
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return responseText;
	}
	public String removeBillingData(String id,String billAmount,String shopId) {
		// TODO Auto-generated method stub
		String responseText = ApplicationConstants.REMOVE_SUCCESS_MESSAGE;
		Session session = hibernateTmeplate.getSessionFactory().openSession();
		try {
			String string = "from BillPaidHistory where id = "+id;
			@SuppressWarnings("unchecked")
			List<BillPaidHistory> paidHistories = session.createQuery(string).list();
			
			BillPaidHistory paidHistory = paidHistories.get(0);
			
			@SuppressWarnings("unchecked")
			List<BillPaidStatus> billPaidStatusList = session.createQuery("from BillPaidStatus where billID = "+paidHistory.getBillID() +" and shop.shopID = "+paidHistory.getShop().getShopID()).list();
			BillPaidStatus billPaidStatus =  billPaidStatusList.get(0);
			
			int existingAmount = paidHistory.getAmountPaid();
//			int existingQuanntity = bill.getQuantityDelivered();
			
			paidHistory.setAmountPaid(paidHistory.getAmountPaid()-(existingAmount-Integer.parseInt(billAmount)));
//			billPaidStatus.setBillAmount(billPaidStatus.getBillAmount()-(existingAmount-Integer.parseInt(billAmount)));
			billPaidStatus.setRemainingAmount(billPaidStatus.getRemainingAmount()+existingAmount);
			billPaidStatus.setStatus(ApplicationConstants.COMPLETED_STATUS);
			if(billPaidStatus.getRemainingAmount()>0){
				billPaidStatus.setStatus(ApplicationConstants.PENDING_STATUS);
			}
			
			session.beginTransaction();
			session.update(billPaidStatus);
			session.delete(paidHistory);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			responseText = ApplicationConstants.FAILURE_MESSAGE;
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return responseText;
	}

}
