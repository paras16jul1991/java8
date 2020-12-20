package com.crisil.interview;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindFirstRepeatedCharacter {

	public static void main(String[] args) {
		String var = "a,b,a,b,c,d,d,e";
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();

		IntStream chars = var.chars();
		String[] split = Pattern.compile(",").split(var);
		Stream.of(split).forEach(x -> {
			if (map.get(x) == null) {
				map.put(x, 1);
			} else
				map.put(x, map.get(x) + 1);
		});

		Stream<String> of = Stream.of(split);
		Optional<String> findFirst = of.filter(x -> map.get(x) < 2).findFirst();
		System.out.println(findFirst.get());

		Map<String, Integer> map2 = new LinkedHashMap<String, Integer>();

		Stream.of(var.split(",")).forEach(x -> map2.compute(x, (k, v) -> (v == null) ? 1 : ++v));
		map2.keySet().stream().filter(key -> map2.get(key) == 1).findFirst().ifPresent(System.out::println);
	}

}