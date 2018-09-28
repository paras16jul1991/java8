package com.basic;

public class SwapTwoIntWithoutVariable {

	public static void main(String[] args) {
		swap(20, 10);
	}

	static void swap(int a, int b) {
		a = b - a;
		b = b - a;
		a = a + b;
		System.out.println(a + " " + b);
	}
}
