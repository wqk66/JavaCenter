package com.java.Thread;

public class Thread_3 extends Thread {
	
	private Service_3 service_3;
	public Thread_3(Service_3 service_3){
		this.service_3 = service_3;
	}

	public void run(){
		service_3.methodB();
	}
}
