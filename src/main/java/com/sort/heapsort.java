package com.sort;

import java.util.Arrays;

public class heapsort {
	public static void main(String[] args) {
		int start = 0;
		int ar[] = new int[] { 4, 5, 9, 7, 6, 11, 3 };
		int end = ar.length;

		heapsort.sort(ar, start, end - 1);

		Arrays.stream(ar).forEach(x -> System.out.print(x + " "));
	}

	private static void sort(int[] ar, int start, int n) {
		for (int i = n / 2 - 1; i >= 0; i--) {
			System.out.println(" heapfy " + ar[i]);
			heapfy(ar, n, i);
		}

		for (int i = n; i >= 0; i--) {
			int temp = ar[0];
			ar[0] = ar[i];
			ar[i] = temp;
			heapfy(ar, i, 0);
		}
	}

	private static void heapfy(int[] ar, int n, int i) {

		int temp = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;

		if (l < n && ar[l] > ar[temp]) {
			temp = l;
		}
		if (r < n && ar[r] > ar[temp]) {
			temp = r;
		}
		System.out.println(" Temp " + ar[temp]);
		if (temp != i) {
			int tempv = ar[i];
			ar[i] = ar[temp];
			ar[temp] = tempv;

			heapfy(ar, n, temp);
		}

	}

}
