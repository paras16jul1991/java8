package com.string;

public class StringTest {

	public static void main(String[] args) {
		String s1 = "welcome";

		String s2 = new String(s1);

		String s3 = s1;
		String s4 = s2.toString();

		System.out.println(s1 == s4);
	}
}
