package com.java.reflect;

import java.lang.reflect.Method;

public class Reflect_Invoke {

	public static void main(String[] args) {
		
		Class<?> demo =null;
		try {
			demo = Person.class;
			Method method = demo.getMethod("sayChina");
			method.invoke(demo.newInstance());
			method = demo.getDeclaredMethod("sayHello", String.class,int.class);
			method.invoke(demo.newInstance(), "wqk",29);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
	