package com.sort;

public class QuickSort {
	/** Quick Sort function **/
	public static void sort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	/** Quick sort function **/
	public static void quickSort(int arr[], int low, int high) {
		int i = low, j = high;
		int temp;
		int pivot = arr[(low + high) / 2];

		/** partition **/
		while (i <= j) {
			while (arr[i] < pivot)
				i++;
			while (arr[j] > pivot)
				j--;
			if (i <= j) {
				/** swap **/
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

				i++;
				j--;
			}
		}

		/** recursively sort lower half **/
		if (low < j)
			quickSort(arr, low, j);
		/** recursively sort upper half **/
		if (i < high)
			quickSort(arr, i, high);
	}

	/** Main method **/
	public static void main(String[] args) {
		int ar[] = new int[] { 4, 5, 9, 7, 6, 11, 8, 3 };
		sort(ar);
		/** Print sorted Array **/
		System.out.println("\nElements after sorting ");
		for (int i = 0; i < ar.length; i++)
			System.out.print(ar[i] + " ");
		System.out.println();
	}
}