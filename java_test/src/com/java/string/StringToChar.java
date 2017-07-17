package com.java.string;

public class StringToChar {

	public static void main(String[] args) {
		
		String str = "abcd¹§Ï²·¢²Æ";
		
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			System.out.print(c);
		}
	}
}
