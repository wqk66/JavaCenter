package com.java.Thread;

public class Thread_syc {
	private int num = 0;
	 public synchronized  void  addI(String userName){
		try {
			
			if(userName.equals("a")){
				num = 100;
				System.out.println("a set over");
				Thread.sleep(2000);
				
			}else{
				num  = 200;
				System.out.println("b set over");
			}
			System.out.println(userName + "num="+num);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
