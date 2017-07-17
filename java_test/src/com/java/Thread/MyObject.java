package com.java.Thread;

public class MyObject {
	String str = new String();
	public void speedPrintString(){
		
		synchronized(this){
			System.out.println("speedPrintString_getlock time="+System.currentTimeMillis()+"run ThreadName="+Thread.currentThread().getName());
			System.out.println("------aaaa-----------");
			System.out.println("speedPrintString_releaseLock time="+System.currentTimeMillis()+"run ThreadName="+Thread.currentThread().getName());
		}
	}
}
