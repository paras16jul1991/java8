package com.geeksforgeeks;

public class sorting2 {

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 4, 10, 19 };
		int[] arr2 = { 3, 5, 8 };
		sort(arr1, arr2, arr1.length - 1, arr2.length - 1);
		int k = 0;
		while (k < arr1.length) {
			System.out.print(arr1[k] + " ");
			k++;
		}
		k = 0;
		System.out.print("    ");
		while (k < arr2.length) {
			System.out.print(arr2[k] + " ");
			k++;
		}
	}

	private static void sort(int[] arr1, int[] arr2, int n, int m) {
		while (arr1[n] > arr2[0]) {

			int temp = arr1[n];
			arr1[n] = arr2[0];
			arr2[0] = temp;
			int i = n, j = 0;
			while (i >= 1 && arr1[i] < arr1[i - 1]) {
				int temp2 = arr1[i];
				arr1[i] = arr1[i - 1];
				arr1[i - 1] = temp2;
				i--;
			}

			while (j < m && arr2[j] > arr2[j + 1]) {
				int temp2 = arr2[j];
				arr2[j] = arr2[j + 1];
				arr2[j + 1] = temp2;
				j++;
			}
		}
	}

}
