package com.java.Thread;

public class Service_3 {
	
	Object obj_2 = new Object();
	public void methodA(){
		synchronized(obj_2){
			System.out.println("methodA begin");
			boolean isContiune = true;
			while(isContiune){
				
			}
			System.out.println("methodA end");
		}
		
	}
	Object obj_3 = new Object();
	public void methodB(){
		synchronized(obj_3){
			System.out.println("methodB begin");
			System.out.println("methodB end");
		}
		
	}

}
