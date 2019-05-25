package com.java.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Reflect_Attribute {

	public static void main(String[] args) {
		
		Class<?> clazz = null;
		try {
			
			clazz = Class.forName("com.java.reflect.Person");
			//ȡ�ñ����ȫ������
			Field[] field = clazz.getDeclaredFields();
			for(int i=0;i<field.length;i++){
				//Ȩ������
				int mo = field[i].getModifiers();
				String priv = Modifier.toString(mo);
				//��������
				Class<?> type = field[i].getType();
				System.out.println("Ȩ�ޣ�"+priv+"====���ԣ�"+type.getName()+"===�ֶΣ�"+field[i]);
				
				
			}
			System.out.println("===ʵ�ֵĽӿڻ��߸���");
			Field[] field1 = clazz.getFields();
			for(int i=0;i<field1.length;i++){
				int mo = field1[i].getModifiers();
				String priv = Modifier.toString(mo);
				Class<?> type = field1[i].getType();
				System.out.println("�������η���"+priv+"===��������ԣ�"+type.getName()+"====�����ֶΣ�"+field1[i]);
			}
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
