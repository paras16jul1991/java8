package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyResourceR1 {
	ReadWriteLock lock = new ReentrantReadWriteLock();

	void get() {
		Lock readLock = lock.readLock();
		try {
			readLock.lock();
			for (int i = 0; i < 10; i++) {
				System.out.println("Get " + i + " " + Thread.currentThread());
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			readLock.unlock();
		}

	}

	void put() {
		Lock writelock = lock.writeLock();
		try {
			writelock.lock();
			for (int i = 0; i < 10; i++) {
				System.out.println("Put " + i + " " + Thread.currentThread());
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			writelock.unlock();
		}

	}
}

public class TestReadWriteLock {

	public static void main(String[] args) {
		MyResourceR1 r = new MyResourceR1();
		ExecutorService pool = Executors.newFixedThreadPool(4);
		Runnable task = () -> r.get();
		Runnable task2 = () -> r.put();

		pool.execute(task);
		pool.execute(task);
		pool.execute(task);
		pool.execute(task2);

		pool.execute(task2);

		pool.shutdown();

	}
}
