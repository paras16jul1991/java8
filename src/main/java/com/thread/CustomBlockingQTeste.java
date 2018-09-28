package com.thread;

import java.util.LinkedList;

class BlockingQ<T> {
	LinkedList<T> list = new LinkedList<>();
	int capacity = 0;

	BlockingQ(int size) {
		this.capacity = size;
	}

	void take() {
		synchronized (this) {
			if (list.isEmpty())
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			T poll = list.poll();
			System.out.println("Removed " + poll);
			notifyAll();

		}
	}

	void put(T t) {
		synchronized (this) {
			if (list.size() == capacity)
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			notifyAll();
			list.add(t);
			System.out.println("Added " + t);
		}
	}
}

public class CustomBlockingQTeste {

	public static void main(String[] args) {
		BlockingQ<Integer> q = new BlockingQ<Integer>(5);
		new Thread(() -> {
			try {
				for (int i = 0; i < 10; i++) {
					q.put(i);
					Thread.sleep(100);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		new Thread(() -> {
			try {
				for (int i = 0; i < 14; i++) {
					q.take();
					Thread.sleep(500);

				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}

}
