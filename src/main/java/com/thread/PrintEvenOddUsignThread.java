package com.thread;

import java.util.concurrent.atomic.AtomicInteger;

class PrintEvenOdd {

	AtomicInteger intt = new AtomicInteger(0);

	synchronized void print() {

		for (int i = 0; i < 10; i++) {
			try {
				System.out.println(Thread.currentThread().getName() + "  " + intt.getAndIncrement());
				notifyAll();
				if (i != 9)
					wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class PrintEvenOddUsignThread {

	public static void main(String[] args) {
		PrintEvenOdd p = new PrintEvenOdd();
		new Thread(() -> p.print()).start();
		new Thread(() -> p.print()).start();
	}
}
