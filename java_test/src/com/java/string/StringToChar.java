package com.java.string;

public class StringToChar {

	public static void main(String[] args) {
		
		String str = "abcd��ϲ����";
		
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			System.out.print(c);
		}
	}
}
