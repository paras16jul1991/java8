package com.search;

public class BinarySearch {
	public static void main(String[] args) {
		int[] ar = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 19, 27, 35, 44 };
		System.out.println(search(ar, 19));
	}

	static boolean search(int[] ar, int value) {
		int start = 0;
		int end = ar.length - 1;
		int mid = (start + end) / 2;
		while (start <= end) {
			System.out.println(ar[mid]);
			if (value == ar[mid]) {
				return true;
			}
			if (value < ar[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
			mid = (start + end) / 2;
		}
		return false;
	}
}
