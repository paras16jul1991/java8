package com.collection;

import java.util.HashMap;

class Emp {
	@Override
	public int hashCode() {
		return 1;
	}
}

public class TestTreefyInHashMap {
	public static void main(String[] args) {
		HashMap<Emp, Integer> test = new HashMap<>();
		test.put(new Emp(), 1);
		test.put(new Emp(), 2);
		test.put(new Emp(), 3);
		test.put(new Emp(), 3);
		test.put(new Emp(), 3);
		test.put(new Emp(), 3);
		test.put(new Emp(), 3);
		test.put(new Emp(), 3);
		test.put(new Emp(), 3);
		test.put(new Emp(), 3);

	}
}
