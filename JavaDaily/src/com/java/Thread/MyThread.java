package com.java.Thread;

public class MyThread extends Thread {

	public void run(){
		super.run();
		try {
			System.out.println("run begin");
			Thread.sleep(200);
			System.out.println("run end");
		} catch (Exception e) {
			System.out.println("�ڳ�˯�б�ֹͣ������Catch!"+this.isInterrupted());
			e.printStackTrace();
		}
	}
}
