package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.BiConsumer;
import java.util.regex.*;

public class Problem1 {
	public static int count;

	// Complete the sockMerchant function below.
	static int sockMerchant(int n, int[] ar) {
		count = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < n; i++) {
			map.put(ar[i], (map.get(ar[i]) != null ? map.get(ar[i]) : 0) + 1);
		}

		map.forEach((x, y) -> count = count + y / 2);

		return count;

	}

	public static void main(String[] args) throws IOException {

		int result = sockMerchant(14, new int[] { 1, 1, 1, 1, 1, 3, 3, 3, 4, 4, 4, 4, 4, 4 });

		System.out.print(result);
	}
}
