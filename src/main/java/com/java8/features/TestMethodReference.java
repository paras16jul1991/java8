package com.java8.features;

import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

interface Test<T, R> {
	R testM(T t);
}

class RefClass {
	static int refTest(int i) {
		return i * 2;
	}

	static int refComTest(String i) {
		return i.hashCode();
	}
}

public class TestMethodReference {
	public static void main(String[] args) {
		Test<Integer, Integer> t = RefClass::refTest;
		System.out.println(t.testM(10));

		Comparable<String> c = RefClass::refComTest;

		Function keyExtractor;
		Stream.of(1, 2, 3, 4, 5).sorted(Comparator.reverseOrder()).collect(Collectors.toList());

	}
}
