package com.list;

import java.util.Arrays;
import java.util.stream.Stream;

public class CustomArrayList {

	private Integer[] data;
	private double initialCapacity = 3;
	private double loadFactor = 1.5;
	private double threshould = 0.75;
	private int index = 0;

	CustomArrayList() {
		this.data = new Integer[(int) initialCapacity];
	}

	void resize() {
		Integer[] copyOf = Arrays.copyOf(data, (int) ((int) index * loadFactor));
		this.data = copyOf;
		System.out.println("resize completed");
	}

	public void add(int object) {
		if (index > this.data.length * threshould) {
			resize();
		}
		this.data[this.index] = object;
		index++;
	}

	Stream<Integer> stream() {
		return Stream.of(data);
	}

	public void remove(int index) {

		for (int i = index; i < data.length - 1; i++) {
			data[i] = data[i + 1];
		}
		data[data.length - 1] = null;

	}

	public void printList() {
		Stream<Integer> stream = this.stream();
		stream.forEach(x -> System.out.print(x));
		System.out.println("-----------");
		// stream.forEach(x -> System.out.print(x));

	}

	public static void main(String[] args) {

		CustomArrayList list = new CustomArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.remove(2);
		list.printList();
	}
}
