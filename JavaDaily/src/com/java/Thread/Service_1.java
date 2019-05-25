package com.java.Thread;

public class Service_1 {

	public synchronized static  void printA(){
		try {
			
			System.out.println("线程名称："+Thread.currentThread().getName()
					+"在"+System.currentTimeMillis()+"进入printA");
			Thread.sleep(3000);
			System.out.println("线程名称："+Thread.currentThread().getName()
					+"在"+System.currentTimeMillis()+"离开printA");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public synchronized static  void printB(){
		System.out.println("线程名称："+Thread.currentThread().getName()
				+"在"+System.currentTimeMillis()+"进入printB");
		System.out.println("线程名称为："+Thread.currentThread().getName()
				+"在"+System.currentTimeMillis()+"离开printB");
	}
	public synchronized  void printC(){
		System.out.println("线程名称："+Thread.currentThread().getName()+"在"+System.currentTimeMillis()+"进入printC");
		System.out.println("线程名称："+Thread.currentThread().getName()+"在"+System.currentTimeMillis()+"离开printC");
	}
}
