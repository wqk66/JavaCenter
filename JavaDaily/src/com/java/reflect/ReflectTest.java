package com.java.reflect;

import java.lang.reflect.Constructor;

public class ReflectTest {

	public static void main(String[] args) {
		Class<?> clazz = null;
		try {
			
//			clazz = Class.forName("com.java.reflect.Person");
			clazz = Person.class;
			Person p1 = null;
			Person p2 = null;
			Person p3= null;
			Constructor<?> con = clazz.getConstructor(String.class);
			p1 = (Person)con.newInstance("wqk");
			System.out.println(p1);
			System.out.println(p2);
			System.out.println(p3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
