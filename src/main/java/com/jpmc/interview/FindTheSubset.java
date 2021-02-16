package com.jpmc.interview;

public class FindTheSubset {

	public static void main(String[] args) {

		int a[] = { 2, 1, 5, 1, 3, 2 };
		int k = 4;

		System.out.print(findMax(a, k));
	}

	private static int findMax(int[] a, int k) {

		int max = 0;

		if (k > a.length) {
			return 0;
		}

		for (int i = 0; i < a.length - k; i++) {
			int count = i;
			int value = 0;
			int countk = k;

			while (countk > 0) {
				value = value + a[count];
				count++;
				countk--;
			}

			if (value > max) {
				max = value;
			}
		}

		return max;
	}

}
