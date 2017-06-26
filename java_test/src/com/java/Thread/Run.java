package com.java.Thread;

public class Run {

	public static void main(String[] args) throws Exception {
		
		
		try {
			
			try {
				
				DeadThread t1 = new DeadThread();
				t1.setFlag("a");
				Thread thread1 = new Thread(t1);
				thread1.start();
				Thread.sleep(100);
				t1.setFlag("b");
				Thread thread2 = new Thread(t1);
				thread2.start();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
