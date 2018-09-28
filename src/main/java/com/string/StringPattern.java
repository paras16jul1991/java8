package com.string;

import java.util.regex.Pattern;

public class StringPattern {
	public static void main(String[] args) {
		String test = "1234523";
		Pattern p = Pattern.compile(".*\\D*");
		System.out.println(p.matcher(test).matches());
	}
}
