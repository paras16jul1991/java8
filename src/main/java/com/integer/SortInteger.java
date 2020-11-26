package com.integer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

class Employee {

	int data;

	Employee(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}
}

public class SortInteger {

	public static void main(String[] args) {

		int[] ar = new int[] { 1, 5, 8, 9, 2 };

		sort(ar);

		List ls = new ArrayList<Employee>();
		ls.add(new Employee(1));
		ls.add(new Employee(5));
		ls.add(new Employee(6));
		ls.add(new Employee(2));
		ls.add(new Employee(9));

		Function<Employee, Integer> f = x -> x.getData();
		List<Employee> sort = sort(ls, f);
		sort.forEach(x -> System.out.println(x.getData()));

	}

	private static void sort(int[] ar) {

		for (int i = 0; i < ar.length; i++) {
			for (int j = i; j < ar.length; j++) {
				if (ar[i] > ar[j]) {
					int temp = ar[i];
					ar[i] = ar[j];
					ar[j] = temp;
				}
			}
		}

		for (int i = 0; i < ar.length; i++)
			System.out.println("Ar : " + ar[i]);
	}

	private static <E> List<E> sort(List<E> ls, Function f) {

		ls.sort(Comparator.comparing(f));
		return ls;
	}
}
