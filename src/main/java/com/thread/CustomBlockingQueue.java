package com.thread;
import java.util.LinkedList;

public class CustomBlockingQueue<T> {
	LinkedList<T> q;
	int capacity;
	int currentIndex;

	CustomBlockingQueue(int capacity) {
		this.capacity = capacity;
		q = new LinkedList<T>();
	}

	void put(T value) throws InterruptedException {
		synchronized (this) {
			if (currentIndex == capacity) {
				wait();
			}
			notifyAll();
			q.add(value);
			System.out.println("Take " + value);
			currentIndex++;
		}
	}

	T take() throws InterruptedException {
		synchronized (this) {
			if (currentIndex == 0)
				wait();

			notifyAll();
			T poll = q.poll();
			System.out.println("poll " + poll);
			currentIndex--;
			return poll;
		}
	}

	public static void main(String[] args) {
		CustomBlockingQueue<Integer> q = new CustomBlockingQueue<Integer>(5);

		new Thread(() -> {
			try {
				for (int i = 0; i < 10; i++) {
					q.put(i);
					Thread.sleep(300);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();

		new Thread(() -> {
			try {
				for (int i = 0; i < 14; i++) {
					q.take();
					Thread.sleep(300);

				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
	}
}
