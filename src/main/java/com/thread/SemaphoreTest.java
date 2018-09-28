package com.thread;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	public static void main(String[] args) throws InterruptedException {
		Semaphore semaphore = new Semaphore(5);
		Runnable runnable = () -> {
			try {
				semaphore.acquire();
				System.out.println(Thread.currentThread().getName() + "Thread Hello");

				Thread.sleep(1000);
				semaphore.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " sleep end");
		};

		for (int i = 0; i < 20; i++) {
			Thread t1 = new Thread(runnable);
			t1.start();
		}
	}

}
