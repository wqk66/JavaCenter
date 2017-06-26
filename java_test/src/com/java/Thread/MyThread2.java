package com.java.Thread;

public class MyThread2 extends Thread {

	private MyOneList list;
	public MyThread2(MyOneList list){
		super();
		this.list = list;
	}
	public void run(){
		MyService service = new MyService();
		service.addServiceMethod(list, "B");
	}
}
