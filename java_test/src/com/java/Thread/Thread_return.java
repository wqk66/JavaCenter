package com.java.Thread;

public class Thread_return extends Thread{

	public void run(){
		try {
			
			while(true){
				if(this.interrupted()){
					System.out.println("�߳�ֹͣ��");
					throw new InterruptedException("�߳�ֹͣ�쳣");
				}
				System.out.println("�߳����ƣ�"+this.currentThread().getName());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
