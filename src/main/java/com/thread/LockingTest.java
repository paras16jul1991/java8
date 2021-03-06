package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyResourceR {
	Lock lock = new ReentrantLock();

	void test() {
		try {
			boolean tryLock = lock.tryLock(5000, TimeUnit.MILLISECONDS);
			if (tryLock) {
				for (int i = 0; i < 2; i++) {
					System.out.println("Test " + i + " " + Thread.currentThread());
					Thread.sleep(10000);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			 lock.unlock();
		}
		System.out.println("Executing end" + Thread.currentThread());
	}
}

public class LockingTest {

	public static void main(String[] args) {
		MyResourceR r = new MyResourceR();
		ExecutorService pool = Executors.newFixedThreadPool(4);
		Runnable task = () -> r.test();
		Runnable task2 = () -> r.test();
		pool.execute(task);
		pool.execute(task2);
		pool.shutdown();

	}
}
