package com.java8.features;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Address {
	private String location;

	public Address(String location) {
		super();
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String toString() {
		return location;
	}
}

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
	private List<Address> addresses;

	Employee2(int id, String name, List<Address> addresses) {
		this.id = id;
		this.name = name;
		this.setAddresses(addresses);
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

}

public class StreamSortExample {
	public static void main(String[] args) {
		List<Employee2> list = new ArrayList<>();
		List<Address> listaddress = new ArrayList<>();
		listaddress.add(new Address("Mandi1"));
		listaddress.add(new Address("Mandi2"));
		listaddress.add(new Address("Mandi3"));

		List<Address> listaddress2 = new ArrayList<>();
		listaddress2.add(new Address("kangra1"));
		listaddress2.add(new Address("kangra2"));
		listaddress2.add(new Address("kangra3"));

		list.add(new Employee2(3, "paras11", listaddress));
		list.add(new Employee2(1, "Aaras", listaddress2));
		list.add(new Employee2(2, "Earas", listaddress));
		list.add(new Employee2(4, "Earas", listaddress2));

		// List<Employee2> collect =
		// list.stream().sorted(Comparator.comparing(Employee2::getId, (x, y) ->
		// y.compareTo(x)))
		// .collect(Collectors.toList());

		list.sort(Comparator.comparing(Employee2::getName, (x, y) -> x.compareTo(y)));

		list.forEach(x -> System.out.println(x.name));

		boolean anyMatch = list.stream().anyMatch(x -> x.name.equalsIgnoreCase("paras"));
		System.out.println(anyMatch);

		long count = list.stream().filter(x -> x.getId() > 2).count();
		System.out.println(count);

		long count2 = list.stream().map(x -> x.getName()).distinct().count();
		System.out.println(count2);

		list.stream().map(x -> x.getName()).findFirst().ifPresent(System.out::println);

		list.stream().map(x -> x.getAddresses()).flatMap(x -> x.stream()).distinct().forEach(System.out::println);

		list.stream().map(x -> x.getName()).reduce((x1, x2) -> x1.length() > x2.length() ? x1 : x2)
				.ifPresent(System.out::println);
		Integer reduce = Stream.of(1, 2, 3, 4, 5).reduce(15, Integer::sum);
		System.out.print(reduce);
	}
}
