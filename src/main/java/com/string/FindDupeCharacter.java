package com.string;

import java.util.LinkedHashSet;

public class FindDupeCharacter {
	public static void main(String[] args) {
		new FindDupeCharacter().FundDupCharViaReplace("Java");
		System.out.println(new FindDupeCharacter().replaceChar("Jav a"));
		System.out.println(new FindDupeCharacter().removeDupAndhreturnString("Javata"));
	}

	String removeDupAndhreturnString(String str) {
		LinkedHashSet<Character> lhs = new LinkedHashSet<Character>();
		int count = 0;
		while (count < str.length()) {
			lhs.add(str.charAt(count));
			count++;
		}

		StringBuilder b = new StringBuilder();
		lhs.stream().forEach(x -> {
			b.append(x);
		});
		return b.toString();
	}

	public void FundDupChar(String str) {
		char a[] = str.toCharArray();
		for (int i = 0; i < a.length; i++) {
			int count = 0;
			for (int j = 0; j < a.length; j++) {
				if (a[i] == a[j]) {
					count++;
				}
				if (count > 1) {
					System.out.println(" " + a[i]);
				}
			}
		}
	}

	String replaceChar(String str) {

		StringBuilder b = new StringBuilder();
		int count = 0;
		while (count < str.length()) {
			if (str.charAt(count) == ' ')
				b.append("%%");
			else
				b.append(str.charAt(count));

			count++;
		}

		return b.toString();
	}

	public void FundDupCharViaReplace(String str) {
		int count = 0;
		while (count < str.length()) {
			char charAt = str.charAt(count);
			int maintain = 0;
			for (int i = 0; i < str.length(); i++) {
				if (charAt == str.charAt(i) && charAt != ' ') {
					maintain++;
				}
			}
			if (maintain > 1) {
				str = str.replace(charAt, ' ');
				System.out.println(charAt);
			}
			count++;
		}

	}

	public void findDupWithoutDS(String a) {
		String res = "";
		while (a.length() > 0) {
			int c = 0;
			for (int j = 0; j < a.length(); j++) {
				if (a.charAt(0) == a.charAt(j))
					c = c + 1;
			}
			res = res + a.charAt(0) + "=" + c + "\n";
			String k[] = a.split(a.charAt(0) + "");
			a = new String("");
			for (int i = 0; i < k.length; i++)
				a = a + k[i];
		}

		System.out.println(res);
	}

}
