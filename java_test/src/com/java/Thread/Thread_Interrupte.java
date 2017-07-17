package com.java.Thread;

public class Thread_Interrupte {

	public static void main(String[] args) {
		try {
			MyThread_2 t2 = new MyThread_2();
			t2.start();
			Thread.sleep(1000);
			t2.interrupt();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("end");
	}
}


class MyThread_2 extends Thread{
	
	public void run(){
		super.run();
		try {
			for(int i=0;i<500000;i++){
				if(Thread.interrupted()){
					System.out.println("已经是停止状态了，我要退出");
					throw new InterruptedException();
				}
				System.out.println("i="+(i+1));
			}
			System.out.println("11111");
			
		} catch (Exception e) {
			System.out.println("MyThread.java类run方法中的catch");
			e.printStackTrace();
		}
		
	}	
}
