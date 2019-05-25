package com.java.json;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class JsonHelp {

	public static Map toMap(Object bean){
		Map result = new HashMap();
		Method[] methods = Bean.class.getDeclaredMethods();
		for(Method  method:methods){
			try {
				
				if(method.getName().startsWith("get")){
					String field = method.getName();
					field = field.substring(field.indexOf("get")+3);
					field = field.toLowerCase().charAt(0)+field.substring(1);
					Object value = method.invoke(bean,null);
					result.put(field, null==value?"1":value.toString());
				}
				
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	
	public static void main(String[] args) {
		Bean bean = new Bean();
		Map map = toMap(bean);
		for(Object obj:map.keySet()){
			Object key = obj;
			Object value = map.get(key);
			System.out.println("key:"+key+" value:"+value);
		}
		
	}
}
