package com.hackerrank;

public class findThePower {

	public static void main(String[] args) {

		System.out.print(find(-8, 2));
	}

	private static int find(int i, int j) {

		int power = 0;
		i = Math.abs(i);

		while (j != 0 && i > 0 && i % j == 0) {
			int temp = i / j;
			power++;
			i = temp;
		}

		return power;
	}
}
