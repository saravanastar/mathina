/**
 * 
 */
package com.ask.adapter;

import java.lang.reflect.Type;

import com.ask.dbpojo.BillPaidHistory;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * @author ASK
 *
 */
public class BillHistoryAdapter implements JsonSerializer<BillPaidHistory>{

	public JsonElement serialize(BillPaidHistory arg0, Type arg1,
			JsonSerializationContext arg2) {
		// TODO Auto-generated method stub
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id", arg0.getId());
		jsonObject.addProperty("billID", arg0.getBillID());
		jsonObject.addProperty("billAmount", arg0.getAmountPaid());
		jsonObject.addProperty("shopId", arg0.getShop().getShopID());
		jsonObject.addProperty("shopName", arg0.getShop().getShopName());
		jsonObject.addProperty("billDate", arg0.getPaidOn().toString());
		return jsonObject;
	}

}
