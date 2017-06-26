package com.java.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class GenerateJson {

	public static void main(String[] args) {
		
		JsonObject window = new JsonObject();
		window.addProperty("window_id", 111);
		JsonObject tableJson = new JsonObject();
		tableJson.addProperty("tableName1", "bbbb");
		tableJson.addProperty("tableName2", "bbbb");
		tableJson.addProperty("tableName3", "bbbb");
		JsonArray windowArr = new JsonArray();
		windowArr.add(window);
		windowArr.add(tableJson);
		
		
		JsonObject fieldDataList = new JsonObject();
		fieldDataList.addProperty("field", "aa");
		
		JsonArray fieldData = new JsonArray();
		fieldData.add(fieldDataList);
		windowArr.add(fieldData);
		JsonObject jsonObject = new JsonObject();
		jsonObject.add("_main",windowArr);
		System.out.println(jsonObject.toString());
	}
}
