package com.java.Thread;

public class Service_2 {

	public void printA(){
		synchronized (Service_2.class){
			try {
				
				System.out.println("�߳����ƣ�"+Thread.currentThread().getName()+"��"+System.currentTimeMillis()+"�����߳�A");
				Thread.sleep(2000);
				System.out.println("�߳����ƣ�"+Thread.currentThread().getName()+"��"+System.currentTimeMillis()+"�뿪A");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void printB(){
		synchronized (Service_2.class){
			System.out.println("�߳����ƣ�"+Thread.currentThread().getName()+"��"+System.currentTimeMillis()+"����B");
			System.out.println("�߳����ƣ�"+Thread.currentThread().getName()+"��"+System.currentTimeMillis()+"�뿪printB");
		}
	}
}
