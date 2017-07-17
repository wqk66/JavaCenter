package com.java.Thread;

public class MyThread1 extends Thread {

	private MyOneList list;
	public MyThread1(MyOneList list){
		super();
		this.list = list;
	}
	public void run(){
		MyService service = new MyService();
		service.addServiceMethod(list, "A");
	}
}
