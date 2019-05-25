package com.java.Thread;

public class Thread_sleep {

	public static void main(String[] args) {
		
		Thread_1 t1 = new Thread_1();
		System.out.println("begin="+System.currentTimeMillis());
		t1.run();
		System.out.println("end="+System.currentTimeMillis());
	}
}


class Thread_1 extends Thread{
	
	public void run(){
		try{
			System.out.println("run threadName="+this.currentThread().getName()+" begin");
			Thread.sleep(2000);
			System.out.println("run threadName="+this.currentThread().getName()+" end");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
