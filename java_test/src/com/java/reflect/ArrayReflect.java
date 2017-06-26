package com.java.reflect;

import java.lang.reflect.Array;

public class ArrayReflect {

	public static void main(String[] args) {
		
		int arr[] = {1,4,5,6,7};
		Class<?> demo = arr.getClass().getComponentType();
		System.out.println(demo.getName());
		Array.set(arr, 0, 100);
		System.out.println(Array.get(arr,0));
	}
}
