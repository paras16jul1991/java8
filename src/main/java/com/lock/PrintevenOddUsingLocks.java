package com.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintevenOddUsingLocks {

	Lock lock = new ReentrantLock();
	Condition isEven = lock.newCondition();

	int count = 1;

	void print() throws InterruptedException {
		lock.lock();
		while (count < 20) {

			isEven.signal();
			System.out.println(Thread.currentThread() + "   " + count);

			count++;
			isEven.await();

		}
		lock.unlock();
	}

	public static void main(String[] args) {
		PrintevenOddUsingLocks test = new PrintevenOddUsingLocks();
		new Thread(() -> {
			try {
				test.print();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
		new Thread(() -> {
			try {
				test.print();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
	}
}
