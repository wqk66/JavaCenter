package com.java.reflect;

import java.lang.reflect.Method;

public class SetAndGet {

	public static void main(String[] args) {
		
		Class<?> demo = null;
		Object obj = null;
		try {
			
			demo = Person.class;
			obj = demo.newInstance();
			setter(obj, "Name", "wqk", String.class);
			getter(obj, "Name");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void getter(Object obj,String att){
		try {
			
			Method method = obj.getClass().getMethod("get"+att); 
			System.out.println(method.invoke(obj));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void setter(Object obj,String att,Object value,Class<?> type){
		try {
			
			Method method = obj.getClass().getMethod("set"+att, type);
			method.invoke(obj, value);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

