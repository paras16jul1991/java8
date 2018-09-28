package com.sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {

		int a[] = new int[] { 11, 4, 8, 3, 9, 10, 1, 2 };
		new BubbleSort().bubbleSort(a);
		Arrays.stream(a).forEach(x -> System.out.print(" " + x));
	}

	void bubbleSort(int a[]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 1; j < a.length; j++) {
				if (a[j - 1] > a[j]) {
					int temp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = temp;
				}

			}
			Arrays.stream(a).forEach(x -> System.out.print(" " + x));
			System.out.println(" ");
		}

	}
}
