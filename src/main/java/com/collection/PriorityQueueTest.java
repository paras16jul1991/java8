package com.collection;

import java.util.PriorityQueue;

public class PriorityQueueTest {
	public static void main(String[] args) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		q.add(11);
		q.add(23);
		q.add(9);
		q.add(13);

		System.out.println(q);
		System.out.println(q.poll());
	}
}
