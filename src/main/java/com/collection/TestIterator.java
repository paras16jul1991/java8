package com.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class TestIterator {

	public static void main(String[] args) {

		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "paras1");
		map.put(2, "paras2");
		map.put(3, "paras3");
		map.put(4, "paras4");
		map.put(5, "paras5");

		Iterator<Entry<Integer, String>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Integer, String> next = iterator.next();
			if (next.getKey() == 2)
				iterator.remove();

			if (next.getKey() == 3)
				map.put(9, "paras9");
		}
		map.entrySet().stream().forEach(x -> System.out.println(x.getValue()));

	}
}
