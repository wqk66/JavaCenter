package com.java.inner;

public class Test {

	public void test(Bird bird){
		System.out.println(bird.getName()+"ÄÜ¹»·É"+bird.fly()+"Ã×");
	}
	
	public static void main(String[] args) {
		
		Test test = new Test();
		test.test(new Bird() {
			
			public int fly() {
				return 1000;
			}
			public String getName(){
				return "´óÑã";
			}
		});
	}
}

