package com.java.Thread;

public class Service_2 {

	public void printA(){
		synchronized (Service_2.class){
			try {
				
				System.out.println("线程名称："+Thread.currentThread().getName()+"在"+System.currentTimeMillis()+"进入线程A");
				Thread.sleep(2000);
				System.out.println("线程名称："+Thread.currentThread().getName()+"在"+System.currentTimeMillis()+"离开A");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void printB(){
		synchronized (Service_2.class){
			System.out.println("线程名称："+Thread.currentThread().getName()+"在"+System.currentTimeMillis()+"进入B");
			System.out.println("线程名称："+Thread.currentThread().getName()+"在"+System.currentTimeMillis()+"离开printB");
		}
	}
}
