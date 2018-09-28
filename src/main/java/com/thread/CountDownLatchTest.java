package com.thread;

import java.util.concurrent.CountDownLatch;

class Threadtest implements Runnable {
	CountDownLatch latch;

	public Threadtest(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		latch.countDown();
		System.out.println("Thread " + Thread.currentThread().getName());

	}
}

public class CountDownLatchTest {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(3);
		new Thread(new Threadtest(latch)).start();
		new Thread(new Threadtest(latch)).start();
		new Thread(new Threadtest(latch)).start();
		latch.await();
		System.out.println("Here");
	}

}
