package com.sort;

import java.util.Arrays;

public class SelectsortTest {

	public static void main(String[] args) {
		int start = 0;
		int ar[] = new int[] { 4, 5, 9, 7, 6, 11, 8, 3 };
		int end = ar.length;

		SelectsortTest.sort(ar, start, end - 1);

		Arrays.stream(ar).forEach(x -> System.out.print(x + " "));
	}

	private static void sort(int[] ar, int start, int n) {
		for (int i = 0; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				if (ar[i] > ar[j]) {
					int temp = ar[i];
					ar[i] = ar[j];
					ar[j] = temp;
					System.out.println(" ");
					Arrays.stream(ar).forEach(x -> System.out.print(x + " "));
				}

			}
		}
	}
}
