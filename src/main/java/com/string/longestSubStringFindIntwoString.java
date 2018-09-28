package com.string;
import java.util.Scanner;

public class longestSubStringFindIntwoString {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			int m = scanner.nextInt();
			int n = scanner.nextInt();
			String longeststring = findTheLongest(scanner.next(), scanner.next());
			System.out.println(longeststring.length());
		}
	}

	private static String findTheLongest(String str1, String str2) {
		String longestString = "";
		char[] charArray = str1.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			StringBuilder b = new StringBuilder();
			for (int j = i; j < charArray.length; j++) {
				b.append(charArray[j]);
				if (str2.contains(b)) {
					if (longestString.length() < b.length())
						longestString = b.toString();
				}
			}
		}
		return longestString;
	}
}
