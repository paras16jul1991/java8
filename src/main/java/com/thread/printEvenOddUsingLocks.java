package com.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class callRunnable implements Runnable {

	AtomicInteger intt = new AtomicInteger(0);
	Lock lock = new ReentrantLock();
	Condition con = lock.newCondition();

	void printEven() {
		lock.lock();
		try {
			con.signalAll();
			System.out.println(Thread.currentThread() + "  Even " + intt.getAndIncrement());
			con.await();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lock.unlock();

	}

	private void printOdd() {
		lock.lock();
		try {
			con.signalAll();
			System.out.println(Thread.currentThread() + "  odd " + intt.getAndIncrement());
			con.await();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lock.unlock();
	}

	@Override
	public void run() {

		while (intt.get() < 10) {

			if (intt.get() % 2 == 0) {
				printEven();

			} else {
				printOdd();

			}

		}
	}

}

public class printEvenOddUsingLocks {

	public static void main(String[] args) {
		Runnable call = new callRunnable();
		new Thread(call).start();
		new Thread(call).start();
	}
}
