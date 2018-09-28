package com.collection;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class SortTreeMapByValueComapartor implements Comparator<String> {

	Map<String, Integer> map;

	public SortTreeMapByValueComapartor(Map<String, Integer> tree) {
		this.map = tree;
	}

	@Override
	public int compare(String o1, String o2) {
		Integer integer1 = this.map.get(o1);
		Integer integer2 = this.map.get(o2);
		if (integer1 == integer2)
			return 0;
		else if (integer1 > integer2)
			return 1;
		else
			return -1;
	}
}

public class SortTreeMapByValue {
	public static void main(String[] args) {

		HashMap<String, Integer> tree = new HashMap<>();
		tree.put("Paras", 16);
		tree.put("Abhinav", 19);
		tree.put("Babji", 21);
		tree.put("Dipika", 13);

		Comparator<String> sortByValue = new SortTreeMapByValueComapartor(tree);
		TreeMap<String, Integer> map = new TreeMap<>(sortByValue);
		map.putAll(tree);

		System.out.println(map);
	}
}
