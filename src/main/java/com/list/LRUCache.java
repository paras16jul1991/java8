package com.list;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class LRUCache {
	HashMap<Integer, Integer> map;
	Queue<Integer> queue;
	int queueSize;

	/* Inititalize an LRU cache with size N */
	public LRUCache(int N) {
		map = new HashMap<Integer, Integer>(N);
		queue = new LinkedList<Integer>();
		queueSize = N;
	}

	public static void main(String[] args) {
		LRUCache c = new LRUCache(4);
		c.set(1, 1);
		c.set(2, 2);
		c.set(3, 3);
		c.set(4, 4);
		c.set(5, 5);
		c.get(2);
		c.set(6, 6);

		c.queue.stream().forEach(x -> System.out.println(x));
	}

	/*
	 * Returns the value of the key x if present else returns -1
	 */
	public int get(int x) {
		if (map.get(x) != null) {
			queue.remove(x);
			queue.add(x);
			return x;
		} else
			return -1;
	}

	/* Sets the key x with value y in the LRU cache */
	public void set(int x, int y) {
		if (map.get(x) != null) {
			queue.remove(x);
			queue.add(x);
		} else if (queue.size() < queueSize) {
			queue.add(x);
			map.put(x, y);
		} else {
			queue.add(x);
			map.put(x, y);
			queue.poll();
		}

	}
}
