package com.thread;

public class DeadLockDemo {

	Object obj1 = new Object();
	Object obj2 = new Object();

	public static void main(String[] args) throws InterruptedException {
		DeadLockDemo demo = new DeadLockDemo();

		Thread t1 = new Thread(new ThreadDemo1(demo));
		Thread t2 = new Thread(new ThreadDemo2(demo));

		t1.start();
		t2.start();

	}

	private static class ThreadDemo1 implements Runnable {

		DeadLockDemo demo;

		ThreadDemo1(DeadLockDemo demo) {
			this.demo = demo;
		}

		@Override
		public void run() {

			synchronized (demo.obj1) {
				System.out.print("lock on Demo1 on obj 1 ");

				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				synchronized (demo.obj2) {
					System.out.print("lock on Demo2 on obj 2 ");
				}
			}
		}

	}

	private static class ThreadDemo2 implements Runnable {

		DeadLockDemo demo;

		ThreadDemo2(DeadLockDemo demo) {
			this.demo = demo;
		}

		@Override
		public void run() {

			synchronized (demo.obj2) {
				System.out.print("lock on Demo2 on obj 2 ");

				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				synchronized (demo.obj1)

				{
					System.out.print("lock on Demo2 on obj 1 ");
				}
			}

		}

	}
}