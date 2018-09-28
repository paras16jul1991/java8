package com.basic;

public class TestOperator {
	public static void main(String[] args) {
		int x = 0;
		int y = 0;
		boolean z = false;
		int count = 0;

		if (z = true || y++ > 0) {
			count++;
		}
		if (z ^ false) {
			count++;
		}
		if (x++ > 0 && y++ > 0) {
			count++;
		}

		System.out.println(count);

	}
}
