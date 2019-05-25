package com.java.Thread;

public class Thread_2 extends Thread {

	private Service_3 service_3;
	public Thread_2(Service_3 service_3){
		this.service_3 = service_3;
	}
	public void run(){
		service_3.methodA();
	}
}
