package com.java.Thread;

public class Service_1 {

	public synchronized static  void printA(){
		try {
			
			System.out.println("�߳����ƣ�"+Thread.currentThread().getName()
					+"��"+System.currentTimeMillis()+"����printA");
			Thread.sleep(3000);
			System.out.println("�߳����ƣ�"+Thread.currentThread().getName()
					+"��"+System.currentTimeMillis()+"�뿪printA");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public synchronized static  void printB(){
		System.out.println("�߳����ƣ�"+Thread.currentThread().getName()
				+"��"+System.currentTimeMillis()+"����printB");
		System.out.println("�߳�����Ϊ��"+Thread.currentThread().getName()
				+"��"+System.currentTimeMillis()+"�뿪printB");
	}
	public synchronized  void printC(){
		System.out.println("�߳����ƣ�"+Thread.currentThread().getName()+"��"+System.currentTimeMillis()+"����printC");
		System.out.println("�߳����ƣ�"+Thread.currentThread().getName()+"��"+System.currentTimeMillis()+"�뿪printC");
	}
}
