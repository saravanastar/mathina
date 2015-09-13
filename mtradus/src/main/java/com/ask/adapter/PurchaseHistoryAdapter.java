/**
 * 
 */
package com.ask.adapter;

import java.lang.reflect.Type;

import com.ask.dbpojo.PurchaseHistory;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * @author ASK
 *
 */
public class PurchaseHistoryAdapter implements JsonSerializer<PurchaseHistory> {

	public JsonElement serialize(PurchaseHistory arg0, Type arg1,
			JsonSerializationContext arg2) {
		// TODO Auto-generated method stub
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id", arg0.getId());
		jsonObject.addProperty("billID", arg0.getInvoiceNumber());
		jsonObject.addProperty("billAmount", arg0.getAmount());
//		jsonObject.addProperty("shopId", arg0.getShop().getShopID());
//		jsonObject.addProperty("shopName", arg0.getShop().getShopName());
		jsonObject.addProperty("quantity", arg0.getQuantity());
		jsonObject.addProperty("itemId", arg0.getItemDetails().getItemId());
		jsonObject.addProperty("itemName", arg0.getItemDetails().getItemName()+"-"+arg0.getItemDetails().getQuantity());
//		jsonObject.addProperty("itemId", arg0.getProductItemDetails().getItemId());
		jsonObject.addProperty("billDate", arg0.getPurchasedOn().toString());
		jsonObject.addProperty("discountQuantity", arg0.getDiscountQuantity());
		return jsonObject;
	}

}
