package com.hackerrank;

import java.io.IOException;
import java.util.Scanner;

public class RemveRepeatedAB {

	// Complete the alternatingCharacters function below.
	static int alternatingCharacters(String s) {
		int count = 0;
		String[] a = s.split("");
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i].equals(a[i + 1])) {
				count++;
			}
		}
		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		System.out.println(alternatingCharacters("AABBBA"));
		System.out.print(Math.pow(1, 2));

	}
}
