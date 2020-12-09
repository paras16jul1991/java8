package com.hackerrank;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Anagram {

	// Complete the makeAnagram function below.
	static int makeAnagram(String a, String b) {

		Map<String, Integer> map = new HashMap<>();

		Stream.of(a.split("")).forEach(x -> map.compute(x, (k, v) -> v == null ? 1 : ++v));

		Stream.of(b.split("")).forEach(x -> map.compute(x, (k, v) -> v == null ? -1 : --v));

		return map.entrySet().stream().map(x -> Math.abs(x.getValue())).reduce(Integer::sum).get();
	}

	public static void main(String[] args) throws IOException {

		int res = makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke");
		System.out.print(res);

	}
}
