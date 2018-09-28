package com.basic;

import java.util.Arrays;

public class TestExample {
	public static void main(String[] args) {
		Arrays.stream(new int[] { 1, 2, 3, 4 }).map(n -> 3 * n + 1).filter(n -> n > 10).average()
				.ifPresent(System.out::println);
	}
}
