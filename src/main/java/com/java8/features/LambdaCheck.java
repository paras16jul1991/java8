package com.java8.features;

import java.util.Arrays;
import java.util.List;

public class LambdaCheck {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(new Integer[] { 1, 2, 3, 4 });
		int sum = 0;
		list.stream().map(x -> x * 10 + 1).forEach(x -> {
		});
	}
}
