package com.collection;

import java.util.Enumeration;
import java.util.Hashtable;

public class TestEnumInCollection {
	public static void main(String[] args) {
		Hashtable<Integer, String> map = new Hashtable<>();
		map.put(1, "paras1");
		map.put(2, "paras2");
		map.put(3, "paras3");
		map.put(4, "paras4");
		map.put(5, "paras5");

		Enumeration<String> elements = map.elements();
		while (elements.hasMoreElements()) {
			String nextElement = elements.nextElement();
		}
		map.entrySet().stream().forEach(x -> System.out.println(x.getValue()));

	}
}
