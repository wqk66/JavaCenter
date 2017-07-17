package com.java.reflect;

public class Field {

	public static void main(String[] args) {
		
		Class<?> demo = null;
		Object obj = null;
		try {
			
			demo = Person.class;
			obj = demo.newInstance();
			java.lang.reflect.Field f = demo.getDeclaredField("name");
			f.setAccessible(true);
			f.set(obj, "wqk");
			System.out.println(f.get(obj));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
}
