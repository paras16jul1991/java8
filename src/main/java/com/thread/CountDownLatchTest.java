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
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread " + Thread.currentThread().getName());

	}
}

public class CountDownLatchTest {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(4);
		new Thread(new Threadtest(latch)).start();
		new Thread(new Threadtest(latch)).start();
		new Thread(new Threadtest(latch)).start();
		latch.await();
		Thread.currentThread().sleep(5000);
		System.out.println("Here");
	}

}
