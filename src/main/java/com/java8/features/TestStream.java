package com.java8.features;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TestStream {

	public static void main(String[] args) {
		List<Employee2> list = new ArrayList<>();
		list.add(new Employee2(4, "Paras"));
		list.add(new Employee2(1, "Babji"));
		list.add(new Employee2(5, "Paras"));
		list.add(new Employee2(3, "Abhinav"));
		list.add(new Employee2(2, "Abhinav"));
		System.out.println("----------------");
		calculateAvarage(list);
		System.out.println("----------------");
		convertToMap(list);
		System.out.println("----------------");
		groupByName(list);
		System.out.println("-----Predicate Test -----------");
		groupByPredicates(list);
		System.out.println("----------------");
		useoftoColletionToChangeBehaviourofDefaultList(list);
		System.out.println("----------------");
		customCollector(list);
		System.out.println("----------------");
		sortList(list);
		System.out.println("----------------");
		list.stream().spliterator().forEachRemaining(x -> System.out.println(x.getId()));
	}

	private static void sortList(List<Employee2> list) {
		List<Employee2> collect = list.stream().sorted(Comparator.comparing(e -> e.getId()))
				.collect(Collectors.toList());
		collect.stream().forEach(x -> System.out.println(x.getId() + " " + x.getName()));
	}

	private static void customCollector(List<Employee2> list) {
		Collector<Employee2, ?, ArrayList<Employee2>> c = Collector.of(ArrayList::new, ArrayList::add,
				(first, second) -> {
					first.addAll(second);
					return first;
				});
		ArrayList<Employee2> collect = list.stream().collect(c);
		collect.stream().forEach(x -> System.out.println(x.getId() + " " + x.getName()));
	}

	private static void useoftoColletionToChangeBehaviourofDefaultList(List<Employee2> list) {
		List<Employee2> collect = list.stream().filter(x -> x.getId() > 2).collect(Collectors.toCollection(() -> {
			List<Employee2> list2 = new ArrayList();
			list2.add(new Employee2(5, "Deepak"));
			return list2;
		}));
		collect.stream().forEach(x -> System.out.println(x.getId() + " " + x.getName()));
	}

	private static void groupByPredicates(List<Employee2> list) {
		Map<Boolean, List<Employee2>> collect = list.stream().sorted(Comparator.comparing(e -> e.getId()))
				.collect(Collectors.partitioningBy(x -> x.getId() > 2));
		collect.entrySet().stream().forEach(x -> System.out.println(x.getKey() + "  " + x.getValue()));
	}

	private static void groupByName(List<Employee2> list) {
		Map<String, List<Employee2>> collect = list.stream().sorted(Comparator.comparing(e -> e.getId()))
				.collect(Collectors.groupingBy(x -> x.getName()));
		collect.entrySet().stream().forEach(x -> System.out.println(x.getKey() + "  " + x.getValue()));
	}

	private static void convertToMap(List<Employee2> list) {
		Map<Integer, String> collect = list.stream().sorted(Comparator.comparing(e -> e.getId()))
				.collect(Collectors.toMap(x -> x.getId(), x -> x.getName()));
		collect.entrySet().stream().forEach(x -> System.out.println(x.getKey() + "  " + x.getValue()));
	}

	private static Double calculateAvarage(List<Employee2> list) {
		Double collect = list.stream().sorted(Comparator.comparing(e -> e.getId()))
				.collect(Collectors.averagingInt(x -> x.getId()));
		System.out.println(collect);
		return collect;
	}
}
