package com.collection;

import java.util.HashMap;

public class HashMapTest {
	HashMap<Object, Integer> map = new HashMap<>();

	public static void main(String[] args) {

	}

	void store(Object obj) {
		Integer integer = this.map.get(obj);
		if (integer != null) {
			map.put(obj, this.map.get(obj) + 1);
		} else
			map.put(obj, 1);
	}
}
