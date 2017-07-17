package com.java.Thread;

public class Thread_return extends Thread{

	public void run(){
		try {
			
			while(true){
				if(this.interrupted()){
					System.out.println("线程停止了");
					throw new InterruptedException("线程停止异常");
				}
				System.out.println("线程名称："+this.currentThread().getName());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
