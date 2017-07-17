package com.java.reflect;

public class Reflect_Get_Set {

	public static void main(String[] args) {
		
		Class<?> clazz = null;
		try {
			
			clazz = Class.forName("com.java.reflect.Person");
			Object obj = clazz.newInstance();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
