package com.java.json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JsonUtil {

	/**
	 * 读取文本中的字符串，并返回该字符串 add by wqk 2017-5-23
	 * 
	 * @return
	 */
	public static String readJsonStr(String filePath) {

		StringBuilder sb = new StringBuilder();
		try {
			String encoding = "UTF-8";// 定义编码，防止出现乱码
			File file = new File(filePath);// 定义文件
			String strJson = "";// 返回的json串
			if (file.isFile() && file.exists()) {// 判断文件是否存在
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// 读取文件
				BufferedReader bufferedReader = new BufferedReader(read);// 缓存字符读取流
				while ((strJson = bufferedReader.readLine()) != null) {
					sb.append(strJson);// 拼接字符串
					sb.append("\n");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public static JsonObject getMain(JsonElement jsonElement){
		JsonObject MainObject=getTypeValue(jsonElement,JsonData.Main);
		return MainObject;
	}
	
	public static JsonObject getChildList(JsonElement jsonElement){
		JsonObject ChildListObject=getTypeValue(jsonElement,JsonData.ChildList);
		return ChildListObject;
	}
	
	public static JsonObject getTabData(JsonElement jsonElement){
		JsonObject TabDataObject=getTypeValue(jsonElement,JsonData.TabData);
		return TabDataObject;
	}
	
	public static JsonObject getFieldData(JsonElement jsonElement){
		JsonObject FieldDataObject=getTypeValue(jsonElement,JsonData.FieldData);
		return FieldDataObject;
	}
	
	/***
	 * 根据类型返回下个节点的Json
	 * @param jsonElement
	 * @param Type
	 * @return
	 */
	public static JsonObject getTypeValue(JsonElement jsonElement,String Type) {
		JsonObject Object=new JsonObject();
		Set<Entry<String, JsonElement>> js = ((JsonObject) jsonElement).entrySet();
		for (Entry<String, JsonElement> ent : js) {
			if (!ent.getValue().isJsonNull()) {
				if (ent.getKey().equals(Type)) {
					if (ent.getValue().isJsonObject()) {
						Object = ent.getValue().getAsJsonObject();
					}
				}
			}
		}
		return Object;
	}
	
	/***
	 * 获取当前Json 的 key与 value
	 * @param jsonElement
	 * @param ValueIsJson 返回是否包含json对象
	 * @return
	 */
	public static Map<String,Object> getCurrentJsonObejctValue(JsonElement jsonElement,boolean ValueIsJson) {
		Map<String,Object> map=new HashMap<String, Object>();
		Set<Entry<String, JsonElement>> js = ((JsonObject) jsonElement).entrySet();
		for (Entry<String, JsonElement> ent : js) {
			if (!ent.getValue().isJsonNull()) {
					if(!ent.getValue().isJsonObject()){
						map.put(ent.getKey(), ent.getValue().getAsString());
					} 
					if (ent.getValue().isJsonObject() && ValueIsJson) {
						map.put(ent.getKey(), ent.getValue());
					}
			}
		}
		return map;
	}
}
