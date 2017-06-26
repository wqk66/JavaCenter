package com.java.reflect;

import java.lang.reflect.Constructor;

public class Reflect_Contructor {

	public static void main(String[] args) {
		
		Class<?> clazz = null;
		try {
			
			clazz = Class.forName("com.java.reflect.Person");
			Constructor<?> con[] = clazz.getConstructors();
			for(int i=0;i<con.length;i++){
				System.out.println(con[i]);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
