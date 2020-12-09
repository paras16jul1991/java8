package com.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class FindRansomNote {

	// Complete the checkMagazine function below.
	static void checkMagazine(String[] magazine, String[] note) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		Stream.of(note).forEach(x -> map.compute(x, (k, v) -> (v == null) ? 1 : ++v));

		Stream.of(magazine).forEach(x -> map.compute(x, (k, v) -> (v == null) ? 0 : (v <= 0 ? 0 : --v)));

		map.keySet().stream().map(x -> map.get(x)).reduce(Integer::sum).ifPresent(x -> {
			if (x > 0) {
				System.out.println("No");
			} else
				System.out.println("Yes");
		});

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		String[] magazine = "give me one grand today night".split(" ");
		String[] note = "give me grand today".split(" ");
		checkMagazine(magazine, note);

		scanner.close();
	}
}
