package com.java.reflect;

public class Method {

	public static void main(String[] args) {
		
		
		Class<?> demo = null;
		try {
			
			demo = Person.class;
			java.lang.reflect.Method method = demo.getDeclaredMethod("sayChina");
			method.invoke(demo.newInstance());
			java.lang.reflect.Method method2 = demo.getMethod("sayHello",String.class,int.class);
			method2.invoke(demo.newInstance(), "wqk",20);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
