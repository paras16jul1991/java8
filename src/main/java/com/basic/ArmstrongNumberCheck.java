package com.basic;

public class ArmstrongNumberCheck {

	public static void main(String[] args) {
		// System.out.println(check(101));

		for (int i = 0; i < 500; i++) {
			if (check(i)) {
				System.out.println(i);
			}
		}

		//System.out.println(check(125));
	}

	static boolean check(int number) {

		int sum = 0;
		int check = number;

		while (number > 0) {
			int a = number % 10;
			sum = sum + (int) Math.pow(a, 3);
			number = number / 10;
		}
		if (sum == check)
			return true;
		return false;
	}
}
