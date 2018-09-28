package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

class MyResourceR2 {
	StampedLock lock = new StampedLock();

	void get() {
		long stamp = lock.tryOptimisticRead();
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("Get " + i + " " + Thread.currentThread());
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock(stamp);
		}

	}

	void put() {
		long stamp = lock.writeLock();
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("Put " + i + " " + Thread.currentThread());
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock(stamp);
		}

	}
}

public class TestStampedLocking {

	public static void main(String[] args) {
		MyResourceR2 r = new MyResourceR2();
		ExecutorService pool = Executors.newFixedThreadPool(4);
		Runnable task = () -> r.get();
		Runnable task2 = () -> r.put();
		pool.execute(task2);
		pool.execute(task);
		pool.execute(task);
		pool.execute(task);

		pool.shutdown();

	}
}
