package com.thread;

public class ThreadTask {

	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread(new Thread11());
		Thread t2 = new Thread(new Thread12());
		Thread t3 = new Thread(new Thread13());

		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();

	}
}

class Thread11 implements Runnable {

	@Override
	public void run() {
		System.out.println("T1");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Thread12 implements Runnable {

	@Override
	public void run() {
		System.out.println("T2");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Thread13 implements Runnable {

	@Override
	public void run() {
		System.out.println("T3");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
