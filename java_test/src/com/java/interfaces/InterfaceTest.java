package com.java.interfaces;

public class InterfaceTest extends IT {

	
	public static void main(String[] args) {
		InterfaceTest.run();
	}
}


abstract class  IT{
	public static void run(){
		System.out.println("111111");
	}
	static {
		System.out.println("22222");
	}
	
}
