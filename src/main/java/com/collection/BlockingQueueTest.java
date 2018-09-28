package com.collection;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Producer implements Runnable {

	BlockingQueue<Integer> q;

	public Producer(BlockingQueue<Integer> q) {
		this.q = q;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				q.put(i);
				System.out.println(i + " Added to Queue by Thread " + Thread.currentThread().getName());
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable {
	BlockingQueue<Integer> q;

	public Consumer(BlockingQueue<Integer> q) {
		this.q = q;
	}

	@Override
	public void run() {
		for (int i = 0; i < 22; i++) {
			try {
				q.take();
				System.out.println(i + " Removed from Queue by Thread " + Thread.currentThread().getName());
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

public class BlockingQueueTest {

	public static void main(String[] args) {

		BlockingQueue<Integer> bq = new LinkedBlockingQueue<>(10);
		new Thread(new Producer(bq)).start();
		new Thread(new Producer(bq)).start();
		new Thread(new Consumer(bq)).start();
	}

}
