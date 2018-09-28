package com.string;

class GFG {
	public static void main(String[] args) {

		String count = args[0];
		for (int i = 1; i <= Integer.valueOf(count); i++) {
			System.out.println(reverse(args[i]));
		}
	}

	public static String reverse(String str) {
		String[] splitted = str.split("\\.");
		StringBuilder str1 = new StringBuilder();
		for (int i = splitted.length - 1; i >= 0; i--) {
			if (str1.toString().equals(""))
				str1.append(splitted[i]);
			else
				str1.append(".").append(splitted[i]);

		}

		return str1.toString();
	}

}