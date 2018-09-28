package com.string;

public class ReverseString {

	public static void main(String[] args) {
		// new ReverseString().reverse("Java");
		System.out.println(new ReverseString().reverseRecursively("java"));
		System.out.println(1295 % 1000);

	}

	int reverseInt(int a) {

		int i = 1;
		while (i > 0) {
			int b = a % (10 * i);
			a = a - (b * 10 * 1);
		}

		return 0;
	}

	void reverse(String str) {
		char ch[] = new char[str.length()];
		StringBuilder newstr = new StringBuilder();
		int count = str.length() - 1;
		int i = 0;
		while (count < str.length()) {
			newstr.append(str.charAt(count++));
		}
		System.out.println(newstr);
	}

	public String reverseRecursively(String str) {

		// base case to handle one char string and empty string
		if (str.length() < 2) {
			return str;
		}

		return reverseRecursively(str.substring(1)) + str.charAt(0);

	}

}
