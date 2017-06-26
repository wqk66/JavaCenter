package com.java.Thread;

public class Thread_IsAlive {

	public static void main(String[] args) throws Exception {
		
		IsAliveT t = new IsAliveT();
		System.out.println("begin="+t.isAlive());
		t.start();
		Thread.sleep(1000);
		System.out.println("end="+t.isAlive());
	}
}

class IsAliveT extends Thread{
	
	public void run(){
		System.out.println("run="+this.isAlive());
	}
}
