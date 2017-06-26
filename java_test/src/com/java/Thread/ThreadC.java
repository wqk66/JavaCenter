package com.java.Thread;

public class ThreadC extends Thread {

	private Service_1 service_1;
	public ThreadC(Service_1 service_1){
		super();
		this.service_1 = service_1;
	}
	public void run(){
		service_1.printC();
	}
}
