package com.java.reflect;


public class Reflect_SuperClass {

	
	public static void main(String[] args) {
		
		String str = "dsafasf";
		Class<?> clazz = null;
		try {
			
			clazz = Class.forName("com.java.reflect.Reflect_SuperClass");
			
			Class<?> demo = clazz.getSuperclass();
				
			System.out.println(demo.getName());
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
