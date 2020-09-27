package com.hackerrank;

public class SumOfSubArray {

	public static void main(String[] args) {
		int ar[] = { -3, 2, -1, 10 };
		int sum, result = ar[0];

		for (int i = 0; i < 4; i++) {
			sum = ar[i];
			for (int j = i + 1; j < 4; j++) {
				sum = sum + ar[j];
				System.out.println("Sum  =  " + sum);

				if (result < sum) {
					result = sum;
				}
			}

			System.out.println("Result " + result + "  i " + i);
		}

	}
}
