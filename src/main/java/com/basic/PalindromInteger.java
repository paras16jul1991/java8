package com.basic;

public class PalindromInteger {
	public static void main(String[] args) {

		System.out.println(checkPalindrom(12021));
	}

	static boolean checkPalindrom(int value) {

		int sum = 0;
		int temp = value;

		while (temp > 0) {
			int r = temp % 10;
			sum = sum * 10 + r;
			temp = temp / 10;
		}
		if (value == sum) {
			return true;
		}
		return false;
	}
}
