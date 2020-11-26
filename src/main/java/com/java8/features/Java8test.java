package com.java8.features;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Employee {
	private String name;
	private int age;

	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return "Employee Name: " + name + " age: " + age;
	}
}

public class Java8test {

	public static void main(String args[]) {
		List<Employee> employeeList = createEmployeeList();

		List<String> employeeFilteredList = employeeList.stream().filter(x -> x.getAge() > 20).map(x -> x.getName())
				.collect(Collectors.toList());

		employeeFilteredList.forEach((name) -> System.out.println(name));

		System.out.println(employeeList.stream().filter(x -> x.getAge() == 25).count());

		System.out.println(employeeList.stream().filter(x -> x.getAge() == 26).findAny().isPresent());

		System.out.println(employeeList.stream().filter(x -> x.getAge() < 25).max(Comparator.comparing(x -> x.getAge()))
				.get().getName());

	}

	public static List<Employee> createEmployeeList() {
		List<Employee> employeeList = new ArrayList<>();

		Employee e1 = new Employee("John", 21);
		Employee e2 = new Employee("Martin", 19);
		Employee e3 = new Employee("Mary", 31);
		Employee e4 = new Employee("Stephan", 18);
		Employee e5 = new Employee("Gary", 26);

		employeeList.add(e1);
		employeeList.add(e2);
		employeeList.add(e3);
		employeeList.add(e4);
		employeeList.add(e5);

		return employeeList;
	}

}
