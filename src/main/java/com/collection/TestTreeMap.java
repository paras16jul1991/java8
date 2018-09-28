package com.collection;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TestTreeMap {

	public static void main(String args[]) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		map.put(4, 4);
		map.put(1, 1);
		map.put(7, 7);

		Set<Entry<Integer, Integer>> entrySet = map.entrySet();
		Iterator<Entry<Integer, Integer>> iterator = entrySet.iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next().getValue());
		}
	}

}
