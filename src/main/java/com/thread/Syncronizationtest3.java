package com.thread;

class PC2 {

	static int count = 0;

	void test() {
		synchronized (this) {
			System.out.println("Test " + count + " " + Thread.currentThread().getName());
			if (count++ < 10) {
				this.test();
			}
		}
	}
}

class ThreadP implements Runnable {
	PC2 pc2;

	ThreadP(PC2 pc2) {
		this.pc2 = pc2;
	}

	@Override
	public void run() {
		pc2.test();
	}
}

public class Syncronizationtest3 {
	public static void main(String[] args) {
		PC2 pc2 = new PC2();
		new Thread(new ThreadP(pc2)).start();
		// new Thread(new ThreadP(pc1)).start();

		// new Thread(new Threade(pc1)).start();
		// new Thread(new Thread3(pc1)).start();

	}
}
