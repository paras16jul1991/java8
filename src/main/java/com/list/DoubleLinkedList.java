package com.list;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class DoubleLinkedList {

	public static void main(String[] args) {
		String str = "aabbabababa";
		char[] charArray = str.toCharArray();
		List<char[]> asList = Arrays.asList(charArray);
		LinkedList<Character> list = new LinkedList<>();
		System.out.println(hash(4));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(-1 >> 1);
	}

	static final int hash(Object key) {
		int h;
		System.out.println(key.hashCode());
		System.out.println(key.hashCode() >>> 16);
		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}
}
