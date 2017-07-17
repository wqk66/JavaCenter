package com.java.reflect;

public class Person implements China {

	public Person() {
	}
	public Person(String name){
		this.name=name;
	}
	public Person(String name,String age){
		this.name=name;
		this.age = age;
	}
	private String age;
	private String name;
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString(){
		return "["+this.name+"  "+this.age+"]";
	}
	public void sayChina() {
		System.out.println("hello china");
		
	}
	public void sayHello(String name, int age) {
		
		System.out.println(name+"--"+age);
		
	}
	
}
