package com.thread;

class PC1 {

	synchronized void test() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Test " + i + " " + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	synchronized void test2() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Test2 " + i + " " + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class Threade implements Runnable {
	PC1 pc1;

	Threade(PC1 pc1) {
		this.pc1 = pc1;
	}

	@Override
	public void run() {
		pc1.test();
	}
}

class Threade1 implements Runnable {
	PC1 pc1;

	Threade1(PC1 pc1) {
		this.pc1 = pc1;
	}

	@Override
	public void run() {
		pc1.test2();
	}
}

public class Syncronizationtest2 {
	public static void main(String[] args) {
		PC1 pc1 = new PC1();
		new Thread(new Threade1(pc1)).start();
		new Thread(new Threade(pc1)).start();

		// new Thread(new Threade(pc1)).start();
		// new Thread(new Thread3(pc1)).start();

	}
}
