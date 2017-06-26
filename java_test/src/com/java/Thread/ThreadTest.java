package com.java.Thread;

public class ThreadTest {

	public static void main(String[] args) {
		CountOperate c = new CountOperate();
		Thread t = new Thread(c);
		t.setName("A");
		t.start();
	}
}

class CountOperate extends Thread{
	public CountOperate(){
		System.out.println("countoperate--begin");
		System.out.println("Thread.currentThread().getName()="+Thread.currentThread().getName());
		System.out.println("this.getName()="+this.getName());
		System.out.println("countOperate--end");
	}
	public void run(){
		System.out.println("run--begin");
		System.out.println("Thread.currentThread().getName()="+Thread.currentThread().getName()+"000--:"+Thread.currentThread().isAlive());
		System.out.println("this.getName()="+this.getName()+"---isAlive="+this.isAlive());
		System.out.println("run--end");
	}
}
