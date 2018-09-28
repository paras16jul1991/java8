package com.sort;

import java.util.Arrays;

public class Insertionsorttest {
	public static void main(String[] args) {
		int start = 0;
		int ar[] = new int[] { 4, 5, 9, 7, 6, 11, 8, 3 };
		int end = ar.length;

		Insertionsorttest.sort(ar, start, end - 1);

		Arrays.stream(ar).forEach(x -> System.out.print(x + " "));
	}

	private static void sort(int[] ar, int start, int n) {

		for (int i = 1; i <= n; i++) {
			int j = i;
			int temp = ar[i];
			while (j > 0 && temp < ar[j - 1]) {
				ar[j] = ar[j - 1];
				j--;
			}
			ar[j] = temp;
			System.out.println("");
			Arrays.stream(ar).forEach(x -> System.out.print(x + " "));
		}
	}
}
