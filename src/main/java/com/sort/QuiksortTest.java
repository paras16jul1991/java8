package com.sort;

import java.util.Arrays;

public class QuiksortTest {

	private static void sort(int[] ar, int top, int length) {
		int start = top;
		int end = length;
		int pivotE = ar[(start + end) / 2];
		int pivotEloc = (start + end) / 2;

		while (start <= end) {

			while (ar[start] < pivotE) {
				start++;
			}

			while (ar[end] > pivotE) {
				end--;
			}
			System.out.println("");
			System.out.println(start+ " " + end);
			if (start <= end) {
				System.out.println("Exchange " + ar[start] + " " + ar[end]);
				int temp = ar[start];
				ar[start] = ar[end];
				ar[end] = temp;
				start++;
				end--;
			}
			 Arrays.stream(ar).forEach(x -> System.out.print(x + " "));
		}

		if (top < end) {
			sort(ar, top, end);
		}
		if (end < length) {
			sort(ar, start, length);
		}
	}

	public static void main(String[] args) {
		int start = 0;
		int ar[] = new int[] { 4, 5, 9, 7, 6, 11, 8, 3 };
		int end = ar.length;

		QuiksortTest.sort(ar, start, end - 1);

		Arrays.stream(ar).forEach(x -> System.out.print(x + " "));
	}
}
