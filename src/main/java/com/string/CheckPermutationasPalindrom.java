package com.string;

import java.util.HashMap;
import java.util.Map.Entry;

public class CheckPermutationasPalindrom {

	public static void main(String[] args) {
		System.out.println(new CheckPermutationasPalindrom().check("CODDCOO"));
	}

	public boolean check(String string) {
		char ch[] = string.toCharArray();
		HashMap<Character, Integer> map = new HashMap<>();

		int i = 0;
		while (i < ch.length) {
			map.put(ch[i], map.get(ch[i]) != null ? map.get(ch[i]) + 1 : 1);
			i++;
		}
		int chk = 0;
		for (Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() % 2 != 0) {
				chk++;
			}
		}

		return chk > 1 ? false : true;
	}
}
