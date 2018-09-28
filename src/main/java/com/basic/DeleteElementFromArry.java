package com.basic;
public class DeleteElementFromArry {

	public static void main(String[] args) {
		int[] ar = new int[] { 1, 1, 5, 4, 5, 5, 5, 9, 9 };
		for (int i = 0; i < ar.length; i++) {
			ar = check(ar, i + 1);
		}

		for (int i = 0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}
	}

	private static int[] check(int[] ar, int i) {
		if (ar[i - 1] == ar[i]) {
			ar = remove(ar, i - 1);
		}
		return ar;
	}

	private static int[] remove(int[] ar, int index) {
		System.out.println("Called to remove index " + index);
		int arr[] = new int[ar.length - 1];
		for (int i = 0, j = 0; i < ar.length; i++) {
			if (i != index) {
				arr[j] = ar[i];
				j++;
			}
		}

		return arr;
	}
}
