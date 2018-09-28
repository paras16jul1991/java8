package com.java8.features;
import java.util.stream.Stream;

public class ParallelStreamTest {

	int sum = 0;

	public static void main(String[] args) {
		Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);
		Stream<Integer> parallel = stream.parallel();
		ParallelStreamTest test = new ParallelStreamTest();
		parallel.forEach(x -> {
			test.sum = test.sum + x;
		});

		System.out.println("Sum  " + test.sum + " ");

	}
}
