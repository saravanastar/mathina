/**
 * 
 */
package com.ask.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ask.dbpojo.Discount;
import com.ask.dbpojo.StockMaintanence;

/**
 * @author 298651
 * 
 */
public class CommonObjectMethods {

	private static final String DATE_FORMAT = "MM/dd/yyyy";

	/**
	 * @param session
	 * @return
	 */
	public static int getMaxRow(Session session, String className) {
		int count = 0;
		try {
			Query query = session.createQuery("select max(id) from "
					+ className);

			@SuppressWarnings("unchecked")
			List<Integer> countList = (List<Integer>) query.list();
			if (countList != null && countList.size() > 0
					&& countList.get(0) != null) {
				count = (Integer) countList.get(0);
			}
		} catch (Exception e) {

		}
		return count;
	}

	public static String convertDateToString(Date date) {
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
		return format.format(date);
	}

	/**
	 * 
	 * @param itemId
	 * @param session
	 * @return
	 */
	public static StockMaintanence getstock(String itemId, Session session) {

		boolean flag = false;
		@SuppressWarnings("unchecked")
		List<Object> stockMaintanenceList = (List<Object>) session
				.createQuery(
						"select stock.id,stock.quantity,stock.discountStatus,discount1.id,discount1.discountPer,discount1.discountCount from Discount discount1,StockMaintanence stock,VendorProductItemDetails item1 where item1.itemId = "
								+ itemId
								+ " and item1.itemId=stock.itemDetails.itemId and discount1.id=stock.discount.id")
				.list();
		StockMaintanence stock = null;

		if (stockMaintanenceList != null && stockMaintanenceList.size() == 0) {
			stockMaintanenceList = (List<Object>) session
					.createQuery(
							"select  stock.id,stock.quantity,stock.discountStatus from StockMaintanence stock,VendorProductItemDetails item1 where item1.itemId = "
									+ itemId
									+ " and item1.itemId=stock.itemDetails.itemId")
					.list();
			flag = true;
		}

		if (stockMaintanenceList != null && stockMaintanenceList.size() > 0
				&& stockMaintanenceList.get(0) != null) {
			// int stockId = (Integer) stockMaintanenceList.get(0);
			Object[] split = ((Object[]) stockMaintanenceList.get(0));
			/*
			 * stock = (StockMaintanence) session.get( StockMaintanence.class,
			 * new Integer((Integer) split[0]));
			 */

			stock = new StockMaintanence();
			stock.setId((Integer) split[0]);
			stock.setQuantity((Integer) split[1]);
			stock.setDiscountStatus((String) split[2]);
			if (!flag) {
				Discount discount = new Discount();
				discount.setId((Integer) split[3]);
				discount.setDiscountPer((String) split[4]);
				discount.setDiscountCount((String) split[5]);
				stock.setDiscount(discount);
			}

		}
		return stock;
	}

	/**
	 * @param response
	 * @return
	 */
	public static HashMap<String, String> buildOutObject(String response) {
		HashMap<String, String> map = new HashMap<String, String>();
		if (response.equalsIgnoreCase(ApplicationConstants.SUCCESS_MESSAGE)) {
			map.put("Info", response);
		} else {
			map.put("Error", response);
		}
		return map;
	}
	
	public static Date convertStringToDate(String date){
		 SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
         Date dateFrom = null;
		try {
			dateFrom = formatter.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         return dateFrom;

		
	}
}
