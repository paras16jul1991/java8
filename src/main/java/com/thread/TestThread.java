package com.thread;

class Test {

	synchronized static void printTest() {

		for (int i = 0; i < 10; i++) {
			System.out.println("Inside printtest by" + Thread.currentThread().getName());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	synchronized void printTest2() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Inside printtest2 by" + Thread.currentThread().getName());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
}

public class TestThread implements Runnable {
	Test test = new Test();

	public static void main(String[] args) {
		Thread t1 = new Thread(new TestThread());
		t1.start();

		Thread t2 = new Thread(new TestThread2());
		t2.start();
	}

	@Override
	public void run() {
		test.printTest();
	}
}

class TestThread2 implements Runnable {
	Test test = new Test();

	@Override
	public void run() {
		test.printTest();
	}

}
