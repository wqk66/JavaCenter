package com.java.Thread;

public class Service {

	public void testMethod1(MyObject object){
		synchronized(object){
			try {
				
				System.out.println("testMethod1_getlock time="+System.currentTimeMillis()+"run threadName="+Thread.currentThread().getName());
				Thread.sleep(2000);
				System.out.println("testMethod1_releaseLock time="+System.currentTimeMillis()+"run ThreadName="+Thread.currentThread().getName());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
