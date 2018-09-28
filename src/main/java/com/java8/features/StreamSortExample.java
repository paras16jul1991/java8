package com.java8.features;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

class Employee2 {
	int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	String name;

	Employee2(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/*
	 * @Override public boolean equals(Object obj) { Employee2 e = (Employee2)
	 * obj; int compare = Integer.compare(this.id, e.id); return compare == 1 ?
	 * true : false; }
	 */
}

public class StreamSortExample {
	public static void main(String[] args) {
		List<Employee2> list = new ArrayList<>();
		list.add(new Employee2(3, "paras"));
		list.add(new Employee2(1, "Aaras"));
		list.add(new Employee2(2, "Earas"));

		List<Employee2> collect = list.stream().sorted(Comparator.comparing(Employee2::getId, (x, y) -> y.compareTo(x)))
				.collect(Collectors.toList());

		collect.stream().forEach(x -> System.out.println(x.name));

	}
}
