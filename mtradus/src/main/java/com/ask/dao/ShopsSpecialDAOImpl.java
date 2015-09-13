/**
 * 
 */
package com.ask.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.ask.dbpojo.Area;
import com.ask.dbpojo.ShopProductMap;
import com.ask.dbpojo.Shops;
import com.ask.dbpojo.VendorProductItemDetails;
import com.ask.pojo.InvoicePojo;
import com.ask.util.ApplicationConstants;
import com.ask.util.CommonObjectMethods;

/**
 * @author 298651
 * 
 */
@Component
public class ShopsSpecialDAOImpl implements ShopsSpecialDAO {

	@Autowired
	HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public String saveEditedShop(InvoicePojo pojo) {
		// TODO Auto-generated method stub
		String responseText = ApplicationConstants.SUCCESS_MESSAGE;
		Session session = null;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			String[] itemId = pojo.getItemId();
			String[] shopId = pojo.getShopId();
			String shopName = pojo.getShopName();
			String areaId = pojo.getAreaId();
			if (shopId != null && shopId[0] != null
					&& !shopId[0].equalsIgnoreCase("")) {
				Shops shop = null;
				ArrayList<ShopProductMap> productMapList = new ArrayList<ShopProductMap>();
				if (shopId[0].equalsIgnoreCase("0")) {
					if (areaId != null && !areaId.equalsIgnoreCase("")) {
						int count = CommonObjectMethods.getMaxRow(session,
								"Shops");
						Area area = new Area();
						shop = new Shops();
						shop.setShopID(++count);
						area.setAreaId(Integer.parseInt(areaId));
						shop.setArea(area);
						shop.setCreatedOn(new Date());
						shop.setShopName(shopName);
						if (itemId != null && itemId[0] != null
								&& !itemId[0].equalsIgnoreCase("")) {
							int countmap = CommonObjectMethods.getMaxRow(
									session, "ShopProductMap");
							for (int i = 0; i < itemId.length; i++) {
								VendorProductItemDetails vendorItemProduct = new VendorProductItemDetails();
								ShopProductMap productMap = new ShopProductMap();

								productMap.setId(++countmap);
								productMap.setShop(shop);
								vendorItemProduct.setItemId(Integer
										.parseInt(itemId[i]));
								productMap
										.setVendorItemProduct(vendorItemProduct);
								session.save(productMap);
								productMapList.add(productMap);
							}
						}

					} else {
						return "Area Name required to add a new Shop";
					}
				} else {

					shop = new Shops();
					shop.setShopID(Integer.parseInt(shopId[0]));
					@SuppressWarnings("unchecked")
					List<Shops> shopList = session.createQuery(
							"from Shops where shopID = "
									+ Integer.parseInt(shopId[0])).list();
					shop = shopList.get(0);
					if (areaId != null && !areaId.equalsIgnoreCase("")) {
						Area area = new Area();
						area.setAreaId(Integer.parseInt(areaId));
						shop.setArea(area);
					}
					if (shopName != null && !shopName.equalsIgnoreCase("")) {
						shop.setShopName(shopName);
					}
					if (itemId != null && itemId[0] != null
							&& !itemId[0].equalsIgnoreCase("")) {

						VendorProductItemDetails vendorItemProduct = new VendorProductItemDetails();
						@SuppressWarnings("unchecked")
						List<ShopProductMap> shopProductMapList = session
								.createQuery(
										"from ShopProductMap where shop.shopID = "
												+ Integer.parseInt(shopId[0]))
								.list();

						ArrayList<String> list = new ArrayList<String>();
						for (int i = 0; i < itemId.length; i++) {
							list.add(itemId[i]);
						}
						if (shopProductMapList != null
								&& shopProductMapList.size() > 0) {

							boolean deleteFlag = false;
							ShopProductMap deleteProductMap = null;
							for (int j = 0; j < shopProductMapList.size(); j++) {
								ShopProductMap productMap = shopProductMapList
										.get(j);
								deleteFlag = false;
								for (int i = 0; i < itemId.length; i++) {

									deleteProductMap = productMap;
									if (itemId[i].equalsIgnoreCase(String
											.valueOf(productMap
													.getVendorItemProduct()
													.getItemId()))) {
										deleteFlag = true;
										list.remove(itemId[i]);
										break;
									}
								}
								if (!deleteFlag) {
									session.delete(deleteProductMap);

								}

							}
						}
						int countMap = CommonObjectMethods.getMaxRow(session,
								"ShopProductMap");
						for (int i = 0; i < list.size(); i++) {
							ShopProductMap productMap = new ShopProductMap();

							productMap.setId(++countMap);
							productMap.setShop(shop);
							vendorItemProduct.setItemId(Integer
									.parseInt((String) list.get(i)));
							productMap.setVendorItemProduct(vendorItemProduct);
							session.save(productMap);
							productMapList.add(productMap);
						}
					}
				}
				session.beginTransaction();
				session.saveOrUpdate(shop);
				// if (productMapList.size() > 0) {
				// for (int i = 0; i < productMapList.size(); i++) {
				// session.saveOrUpdate(productMapList.get(i));
				// }
				// }
				session.getTransaction().commit();
			}

			session.close();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

		return responseText;
	}
	/**
	 * 
	 * @param id
	 * @param productCost
	 * @param prodcutPercentage
	 * @return
	 */
	public String saveProductMapCost(String id, String productCost,
			String prodcutPercentage) {
		String respoString = ApplicationConstants.SUCCESS_MESSAGE;
		Session session = null;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			ShopProductMap map = null;
			Query query = session.createQuery("from ShopProductMap where id = "+id);
			@SuppressWarnings("unchecked")
			List<ShopProductMap> list = query.list();
			if(list==null){
				return "Row is not existed";
			}else{
				map = list.get(0);
			}
			map.setId(Integer.parseInt(id));
			if(productCost!=null && !productCost.equalsIgnoreCase(""))
			map.setProductCost(Integer.parseInt(productCost));
			if(prodcutPercentage!=null && !prodcutPercentage.equalsIgnoreCase(""))
			map.setPercentage(Integer.parseInt(prodcutPercentage));
			session.beginTransaction();
			session.update(map);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			respoString = ApplicationConstants.FAILURE_MESSAGE;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return respoString;

	}

}
