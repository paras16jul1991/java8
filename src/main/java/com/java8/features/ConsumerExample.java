package com.java8.features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ConsumerExample {

	public static void testConsumer() {

		List<String> test = new ArrayList<>();
		test.add("test");
		test.add("test2");
		test.stream().forEach(extracted().andThen(x -> System.out.println("Finish " + x)));
		List<String> collect = test.stream().filter(x -> x.equalsIgnoreCase("test")).collect(Collectors.toList());
		System.out.println("-----");
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> collect2 = list.stream().filter(x -> x % 2 != 0).collect(Collectors.toList());
	}

	private static Consumer<? super String> extracted() {
		return x -> System.out.println(x);
	}

	public static void main(String args[]) {
		testConsumer();

		Function<Integer, Integer> fun = x -> x + 10;
		System.out.println(fun.apply(10));

	}
}
