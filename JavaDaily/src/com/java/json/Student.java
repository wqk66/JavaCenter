package com.java.json;

import java.util.Map;

public class Student {

	private int age;
	private String gender;
	private String grades;
	private String name;
	private Map<String,Integer> score;
	private float weight;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGrades() {
		return grades;
	}
	public void setGrades(String grades) {
		this.grades = grades;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, Integer> getScore() {
		return score;
	}
	public void setScore(Map<String, Integer> score) {
		this.score = score;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
}
