package com.java8.features;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListSorting {

	public static void main(String[] args) {

		int ar[] = new int[] { 4, 4, 4, 8, 8, 8, 8, 6, 6, 9, 2, 2 };

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Arrays.stream(ar).boxed().forEach(value -> map.compute(value, (k, v) -> v == null ? 1 : ++v));

		List<Integer> list = Arrays.stream(ar).boxed().collect(Collectors.toList());
		list.sort(Comparator.comparing(x -> map.get(x)));

		list.sort(Comparator.comparing(x -> x, (x, y) -> map.get(x) - map.get(y)));
		
		list.sort((x, y) -> map.get(x) - map.get(y));

		List<Integer> list2 = Arrays.asList(4, 4, 4, 8, 8, 8, 8, 6, 6, 9, 2, 2);

		System.out.println(list.equals(list2));
		list.forEach(System.out::print);
	}

}
