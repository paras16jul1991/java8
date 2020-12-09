package com.java8.features;

import java.util.Arrays;
import java.util.List;

public class LambdaCheck {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(new Integer[] { 1, 2, 3, 4 });
		list.stream().map(x -> x * 10 + 1).forEach(System.out::println);
	}
}
