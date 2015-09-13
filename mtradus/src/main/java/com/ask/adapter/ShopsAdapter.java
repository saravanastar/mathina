/**
 * 
 */
package com.ask.adapter;

import java.lang.reflect.Type;

import com.ask.dbpojo.Shops;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * @author ASK
 *
 */
public class ShopsAdapter implements JsonSerializer<Shops> {

	public JsonElement serialize(Shops arg0, Type arg1,
			JsonSerializationContext arg2) {
		// TODO Auto-generated method stub
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id", arg0.getShopID());
		jsonObject.addProperty("shopName", arg0.getShopName());
		jsonObject.addProperty("areaId", arg0.getArea().getAreaId());
		jsonObject.addProperty("areaName", arg0.getArea().getAreaName());
		jsonObject.addProperty("createdOn", arg0.getCreatedOn().toString());
//		jsonObject.addProperty("userId", arg0.getUser().getUserId());
		return jsonObject;

	}
}
