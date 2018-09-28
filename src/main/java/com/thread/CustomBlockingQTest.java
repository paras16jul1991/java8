package com.thread;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

class CustomBlockingQ {

	public List<String> list = new ArrayList();
	int size = 4;

	synchronized void enqueue(String str) throws InterruptedException {
		if (list.size() == size) {
			System.out.println("Inside  e");
			wait();
		}
		if (list.isEmpty()) {
			System.out.println("e list empty");
			notifyAll();
		}

		list.add(str);
		System.out.println("Added " + str);
	}

	synchronized void dequeue() throws InterruptedException {
		if (list.isEmpty()) {
			System.out.println("d list empty");
			wait();
		}
		if (list.size() == size) {
			System.out.println("Inside  d");
			notifyAll();
		}
		String removedValue = list.remove(0);
		System.out.println("Removed " + removedValue);
	}
}

public class CustomBlockingQTest {
	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		CyclicBarrier l = new CyclicBarrier(3);
		CustomBlockingQ q = new CustomBlockingQ();

		new Thread(() -> {
			try {
				l.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
			for (int i = 0; i < 10; i++)
				try {
					Thread.sleep(100);
					q.enqueue("a" + i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

		}).start();

		new Thread(() -> {
			try {
				l.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			for (int i = 0; i < 10; i++)
				try {
					Thread.sleep(100);
					q.dequeue();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}).start();
		Thread.sleep(100);
		System.out.println(q.list);
		l.await();
	}
}
