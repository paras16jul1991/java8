package com.geeksforgeeks;

public class sorting {
	public static int[] merge(int arr1[], int arr2[], int n, int m) {
		int i = 0;
		int j = 0;
		int k = 0;
		int arr[] = new int[n + m];
		while (i < n && j < m) {
			if (arr1[i] <= arr2[j]) {
				arr[k] = arr1[i];
				i++;
			} else if (arr1[i] >= arr2[j]) {
				arr[k] = arr2[j];
				j++;
			}
			k++;
		}

		while (i < n) {
			arr[k] = arr1[i];
			k++;
			i++;
		}
		while (j < m) {
			arr[k] = arr2[j];
			k++;
			j++;
		}

		return arr;
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 4, 10 };
		int[] arr2 = { 3, 5, 8 };
		int[] merge = merge(arr1, arr2, arr1.length, arr2.length);
		int k = 0;
		while (k < merge.length) {
			System.out.println(merge[k]);
			k++;
		}
	}

}
