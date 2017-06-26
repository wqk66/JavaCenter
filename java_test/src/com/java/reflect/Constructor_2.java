package com.java.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class Constructor_2 {

	public static void main(String[] args) {
		
		try {
			
			Class<?> demo = null;
			demo = Person.class;
			Constructor<?> con[] = demo.getConstructors();
			for(int i=0;i<con.length;i++){
				System.out.println("构造方法");
				Class<?> p[] = con[i].getParameterTypes();
				int mo = con[i].getModifiers();
				System.out.println(Modifier.toString(mo));
				System.out.println(con[i].getName());
				System.out.println("参数名字");
				for(int j=0;j<p.length;j++){
					System.out.print(p[j].getName()+" arg "+j);
					if(j<p.length-1){
						System.out.print(",");
					}
				}
			}
		} catch (Exception e) {
		}
	}
}
