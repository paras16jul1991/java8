package com.collection;

import java.util.HashMap;

class Employee1 {
	static int count = 0;
	String name;
	int id;

	Employee1(int id) {
		this.id = id;
	}

	public int hashCode() {
		count = count + 16;
		return count;
	}
}

public class HashMapTesting {

	public static void main(String[] args) {
		HashMap<Employee1, Integer> map = new HashMap<>();
		for (int i = 1; i < 15; i++) {
			map.put(new Employee1(i), i);
		}
		System.out.print("Hello");
	}

}
