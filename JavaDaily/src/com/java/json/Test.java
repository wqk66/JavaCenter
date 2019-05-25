package com.java.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Test {

	public static void main(String[] args) {
		
		String path = "F:\\data\\data.txt";
		String strJson = JsonUtil.readJsonStr(path);
		parseJson(strJson);
	}
	public static void parseJson(String strJson){
		
		JsonObject jsonObject = new JsonParser().parse(strJson).getAsJsonObject();
		String contry =jsonObject.get("contry").getAsString();
		String language = jsonObject.get("language").getAsString();
		JsonArray userData =  jsonObject.get("user").getAsJsonArray();
		System.out.println(contry+"----"+language);
		for(int i=0;i<userData.size();i++){
			JsonElement jsonElement = userData.get(i);
			JsonObject data =  jsonElement.getAsJsonObject();
			String name = data.get("name").getAsString();
			String age = data.get("age").getAsString();
			System.out.println("name:"+name+"----age:"+age);
		}
		JsonArray courseData = jsonObject.get("course").getAsJsonArray();
		for(int i=0;i<courseData.size();i++){
			JsonElement jsonElement = courseData.get(i);
			JsonObject data = jsonElement.getAsJsonObject();
			System.out.println("课程："+data.get("courseName").getAsString()+"----"+data.get("grade").getAsString());
		}
	}
}
