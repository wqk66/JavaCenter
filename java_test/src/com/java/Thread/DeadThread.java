package com.java.Thread;

public class DeadThread implements Runnable {

	private String userName;
	public Object lock1 = new Object();
	public Object lock2 = new Object();
	public void setFlag(String userName){
		this.userName = userName;
	}
	public void run() {
		String name;
		if(userName.equals("a")){
			synchronized(lock1){
				try {
					
					System.out.println("username="+userName);
					Thread.sleep(3000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				synchronized(lock2){
					System.out.println("按lock1->lock2代码顺序执行");
				}
			}
		}
		if(userName.equals("b")){
			synchronized(lock2){
				try {
					
					System.out.println("username="+userName);
					Thread.sleep(3000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				synchronized(lock1){
					System.out.println("按lock2->lock1代码顺序执行");
				}
			}
		}
	}

}
