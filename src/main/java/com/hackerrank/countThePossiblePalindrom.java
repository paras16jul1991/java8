package com.hackerrank;

import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class countThePossiblePalindrom {

	static long substrCount(int n, String s) {

		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				if (isPalindrom(s.substring(i, j))) {
					System.out.print(s.substring(i, j) + "    ");
					count++;
				}
			}
		}

		return count;

	}

	private static boolean isPalindrom(String substring) {

		boolean equals = new StringBuilder(substring).reverse().toString().equals(substring);
		if (equals) {
			equals = Stream.of(substring.split("")).collect(Collectors.toSet()).size() > 2 ? false : true;
		}

		return equals;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		long result = substrCount(4, "abcbaba");
		System.out.print(result);

	}
}
