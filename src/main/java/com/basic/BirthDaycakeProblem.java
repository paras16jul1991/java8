package com.basic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BirthDaycakeProblem {

	/*
	 * Complete the birthdayCakeCandles function below.
	 */
	static int birthdayCakeCandles(int n, int[] ar) {
		/*
		 * Write your code here.
		 */
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = ar[0];
		for (int i = 0; i < ar.length; i++) {

			if (max < ar[i]) {
				max = ar[i];
			}
			Integer value = map.get(ar[i]);
			if (value != null) {
				map.put(ar[i], value + 1);
			} else
				map.put(ar[i], 1);

		}
		return map.get(max);
	}

	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		/*
		 * BufferedWriter bw = new BufferedWriter(new
		 * FileWriter(System.getenv("OUTPUT_PATH")));
		 * 
		 * int n = Integer.parseInt(scan.nextLine().trim());
		 * 
		 * int[] ar = new int[n];
		 * 
		 * String[] arItems = scan.nextLine().split(" ");
		 * 
		 * for (int arItr = 0; arItr < n; arItr++) { int arItem =
		 * Integer.parseInt(arItems[arItr].trim()); ar[arItr] = arItem; }
		 */

		int[] ar = { 3, 1, 2, 3 };
		int result = birthdayCakeCandles(4, ar);
		System.out.println(result);
		Thread t = new Thread();
		t.start();

		// bw.write(String.valueOf(result));
		// bw.newLine();

		// bw.close();
	}
}
