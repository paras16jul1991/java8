package com.thread;

import java.util.Date;
import java.util.concurrent.Semaphore;

public class YeildTest {

	void check(Date date) {

	}

	void check(String str) {
		System.out.println(str);
	}

	public static void main(String[] args) throws InterruptedException {
		Runnable runnable1 = () -> {
			System.out.println("Thread1 Hello");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread1 sleep end");
		};

		Runnable runnable2 = () -> {
			System.out.println("Thread2 Hello");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread2 sleep end");
		};

		Thread.currentThread().setPriority(10);
		Thread t1 = new Thread(runnable1);
		Thread t2 = new Thread(runnable2);
		t2.setPriority(5);

		t2.start();
		t1.start();
		t1.join();
		// Thread.yield();
		// t2.join();

		// t2.join();

		System.out.println("End");
	}
}
