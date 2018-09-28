package com.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteTest {
	public static void main(String[] args) {
		int a[] = new int[] { 1, 2, 3, 4 };
		CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		for (Integer i : list) {

			System.out.println(i);
			if (i == 2) {
				list.add(6);
				list.remove(4);
			}
			System.out.println("size "+list.size());
		}
		System.out.println("------------");
		for (Integer i : list) {
			System.out.println(i);
		}

	}
}
