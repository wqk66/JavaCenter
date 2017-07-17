package com.java.Thread;

public class Thread_Daemon extends Thread {

	private int i=0;
	public void run(){
		try {
			
			while(true){
				i++;
				System.out.println("i="+i+"Ïß³Ì£º"+Thread.currentThread().getName());
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
