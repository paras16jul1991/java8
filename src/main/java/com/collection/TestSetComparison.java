package com.collection;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;

class Employee implements Comparable<Employee> {
	String name;

	public Employee(String name) {
		super();
		this.name = name;
	}

	@Override
	public int compareTo(Employee o) {
		return this.name.equals(o.name) ? 0 : 1;

	}
}

public class TestSetComparison {
	public static void main(String[] args) {
		Employee[] emps = new Employee[] { new Employee("Abhinav"), new Employee("Umesh"), new Employee("Paras") };
		Employee[] emps2 = new Employee[] { new Employee("Abhinav"), new Employee("Umesh"), new Employee("Paras") };
		List<Employee> list = Arrays.asList(emps);
		List<Employee> list2 = Arrays.asList(emps);
		LinkedHashSet<Employee> set = new LinkedHashSet<>(list);
		TreeSet<Employee> treeSet = new TreeSet<>(list2);
		System.out.println(set + " " + set.hashCode());
		System.out.println(treeSet + " " + treeSet.hashCode());
		System.out.println(set.equals(treeSet));
	}
}
