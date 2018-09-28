package com.string;

public class TestStringAndStringBuilderComparios {
	public static void main(String[] args) {
		StringBuilder s = new StringBuilder("Test");

		System.out.print("Test".equals(new String("Test")));
	}
}
