package com.java.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Reflect_Attribute {

	public static void main(String[] args) {
		
		Class<?> clazz = null;
		try {
			
			clazz = Class.forName("com.java.reflect.Person");
			//取得本类的全部属性
			Field[] field = clazz.getDeclaredFields();
			for(int i=0;i<field.length;i++){
				//权限修饰
				int mo = field[i].getModifiers();
				String priv = Modifier.toString(mo);
				//属性类型
				Class<?> type = field[i].getType();
				System.out.println("权限："+priv+"====属性："+type.getName()+"===字段："+field[i]);
				
				
			}
			System.out.println("===实现的接口或者父类");
			Field[] field1 = clazz.getFields();
			for(int i=0;i<field1.length;i++){
				int mo = field1[i].getModifiers();
				String priv = Modifier.toString(mo);
				Class<?> type = field1[i].getType();
				System.out.println("父类修饰符："+priv+"===父类的属性："+type.getName()+"====父类字段："+field1[i]);
			}
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
