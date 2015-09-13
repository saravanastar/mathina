/**
 * 
 */
package com.ask.adapter;

import java.lang.reflect.Type;

import com.ask.dbpojo.VendorProductItemDetails;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * @author 298651
 *
 */
public class VendorProductItemDetailsAdapter implements JsonSerializer<VendorProductItemDetails> {

	public JsonElement serialize(VendorProductItemDetails arg0, Type arg1, JsonSerializationContext arg2) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("itemId", arg0.getItemId());
		jsonObject.addProperty("itemName", arg0.getItemName());
		jsonObject.addProperty("quantity", arg0.getQuantity());
		jsonObject.addProperty("retailAmount", arg0.getRetailAmount());
		jsonObject.addProperty("retailPercentage", arg0.getRetailPercentage());
		jsonObject.addProperty("itemMrp", arg0.getItemMRP());
		jsonObject.addProperty("itemVate", arg0.getItemVate());
		jsonObject.addProperty("cretedOn", arg0.getCretedOn().toString());
		return jsonObject;
	}
}