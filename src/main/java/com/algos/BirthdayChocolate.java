package com.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BirthdayChocolate {
	public static void main(String[] args) {
		ArrayList list = new ArrayList<Integer>();
		list.add(4);

		System.out.println(birthday(list, 4, 1));
	}

	// Complete the birthday function below.
	static int birthday(ArrayList<Integer> s, int d, int m) {
		int ar[] = new int[s.size()];
		int count = 0;
		for (int a : s) {
			ar[count] = a;
			count++;
		}

		count = 0;
		int sum = 0;
		for (int i = 0; i < ar.length; i++) {
			sum = ar[i];
			int countNo = 1;
			if (sum == d && countNo == m) {
				count++;
			}
			for (int j = 1; j < ar.length; j++) {

				if (sum == d && countNo == m) {
					count++;
				}

				sum = sum + ar[j];
				countNo = countNo + 1;
				if (sum == d && countNo == m) {
					count++;
				}

			}
		}
		return count;

	}

	static int solve(int n, int[] s, int d, int m) {
		int total = 0;
		for (int i = 0; i <= n - m; i++) {
			if (Arrays.stream(s, i, i + m).sum() == d)
				total++;
		}
		return total;
	}

	static int checkforVal(int value, List<Integer> s, int d, int m) {
		int findV = d - value;
		if (findV <= 0) {
			return 0;
		}
		Iterator<Integer> it = s.iterator();
		while (it.hasNext()) {
			int val = it.next();
			if (val == findV) {
				return 1;
			}
		}
		return 0;
	}
}