package com.integer;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class findMostRepeatedCharacter {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 1, 2 };
		int length = 4;
		System.out.print(find(length, arr));

	}

	private static int find(int length, int[] arr) {

		int result = -1;
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.get(arr[i]) == null ? 1 : map.get(arr[i]) + 1);
		}

		AtomicInteger last = new AtomicInteger(0);
		AtomicInteger lastValue = new AtomicInteger(0);
		StringBuilder sb = new StringBuilder();
		map.keySet().stream().forEach(x -> {
			if (map.get(x) > lastValue.get()) {
				lastValue.set(map.get(x));
				last.set(x);
			}

		});

		if (last.get() >= length / 2)
			result = last.get();

		return result;
	}
}
