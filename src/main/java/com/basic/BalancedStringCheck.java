package com.basic;

public class BalancedStringCheck {

	public static void main(String[] args) {
		int check = 0;
		String str = "(d))";
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++)
			if (charArray[i] == '(') {
				check = check + 1;
			} else if (charArray[i] == ')') {
				check = check - 1;
			}
		System.out.println(check == 0 ? true : false);
	}
}
