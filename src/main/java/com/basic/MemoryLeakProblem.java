package com.basic;
public class MemoryLeakProblem {

	public static void main(String[] args) {
		String a = "";
		for (int x = 0; x < Integer.MAX_VALUE; x++)
			a = a + Integer.toString(x);
		System.out.println(a);
	}
}
