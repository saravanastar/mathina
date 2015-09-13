/**
 * 
 */
package com.ask.adapter;

import java.lang.reflect.Type;

import com.ask.dbpojo.ShopBillDetails;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * @author ASK
 *
 */
public class ShopBillAdapter implements JsonSerializer<ShopBillDetails> {

	public JsonElement serialize(ShopBillDetails arg0, Type arg1,
			JsonSerializationContext arg2) {
		// TODO Auto-generated method stub
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id", arg0.getId());
		jsonObject.addProperty("billID", arg0.getBillID());
		jsonObject.addProperty("billAmount", arg0.getBillAmount());
		jsonObject.addProperty("shopId", arg0.getShop().getShopID());
		jsonObject.addProperty("shopName", arg0.getShop().getShopName());
		jsonObject.addProperty("quantity", arg0.getQuantityDelivered());
		jsonObject.addProperty("itemId", arg0.getProductItemDetails().getItemId());
		jsonObject.addProperty("itemName", arg0.getProductItemDetails().getItemName()+"-"+arg0.getProductItemDetails().getQuantity());
		
//		jsonObject.addProperty("itemId", arg0.getProductItemDetails().getItemId());
		jsonObject.addProperty("billDate", arg0.getDeliveryDate().toString());
		return jsonObject;
	}

}
