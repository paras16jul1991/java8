package com.hackerrank;

import java.io.IOException;
import java.util.Arrays;

public class RotateArray {

	// Complete the rotLeft function below.
	static int[] rotLeft(int[] a, int k) {
		int n = a.length;
		if (k >= n) {
			k = k % n;
		}

		if (k == 0)
			return a;

		int[] temp = new int[n];

		for (int i = 0; i < n; i++) {
			System.out.println((i + k) % n);
			temp[i] = a[(i + k) % n];
		}

		return temp;
	}

	public static void main(String[] args) throws IOException {

		int[] a = new int[] { 1, 2, 3, 4, 5, 6 };
		int[] rotLeft = rotLeft(a, 5);

		System.out.println("------");
		Arrays.stream(rotLeft).boxed().forEach(System.out::println);

	}
}
