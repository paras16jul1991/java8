package com.list;

import java.util.Arrays;

public class CustomArrayList2 {
	int a[];
	static int size = 0;
	static int currentIndex = 0;
	int initialCapacity = 10;
	float loadFactory = 0.75F;

	CustomArrayList2() {
		a = new int[initialCapacity];
		size = initialCapacity;
	}

	CustomArrayList2(Integer length) {
		a = new int[length];
		size = length;
	}

	public void add(Integer i) {
		if (currentIndex < (int) (size * loadFactory))
			a[currentIndex++] = i;
		else {
			resize();
			add(i);
		}
	}

	private void resize() {
		size = (int) (size * 1.5);
		a = Arrays.copyOf(a, size);
	}

	public void remove(Integer value) {
		for (int i = 0; i < currentIndex; i++) {
			if (a[i] == value) {
				int count = i;
				while (count < currentIndex) {
					a[count] = a[count + 1];
					count++;
				}
				currentIndex--;
				return;
			}
			System.out.print("" + i);
		}
	}

	public static void main(String[] args) {
		CustomArrayList2 customLinkedList = new CustomArrayList2();
		for (int i = 1; i <= 12; i++) {
			customLinkedList.add(i);
		}
		customLinkedList.remove(10);
	}

}
