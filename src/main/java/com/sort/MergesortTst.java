package com.sort;

import java.util.Arrays;

public class MergesortTst {

	private static void mergsort(int[] ar, int top, int length, int mid) {

	}

	private static void sort(int[] ar, int top, int length) {
		if (top < length) {
			int mid = (top + length) / 2;
			mergsort(ar, top, length, mid);
		}
	}

	public static void main(String[] args) {
		int start = 0;
		int ar[] = new int[] { 4, 5, 9, 7, 6, 11, 8, 3 };
		int end = ar.length;

		MergesortTst.sort(ar, start, ar.length);

		Arrays.stream(ar).forEach(x -> System.out.print(x + " "));
	}
}
