package com.java.Thread;

public class ThreadA extends Thread {

	private Service_2 service_2;
	public ThreadA(Service_2 service_2){
		super();
		this.service_2 = service_2;
	}
	public void run(){
		super.run();
		service_2.printA();
	}
}
