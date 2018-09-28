package com.thread;

import java.util.LinkedList;

class PC {
	LinkedList<Integer> q = new LinkedList<>();
	int capacity = 5;

	synchronized static void test() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Test " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	synchronized void produce() {
		for (int i = 0; i < 10; i++) {
			try {
				if (q.size() == capacity) {
					wait();
				}
				q.add(i);
				System.out.println("Produced " + i);
				Thread.sleep(1000);
				notify();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	synchronized void consume() {
		for (int i = 0; i < 10; i++) {
			try {
				if (q.size() == 0) {
					wait();
				}
				notify();
				Thread.sleep(1000);
				System.out.println("Consumed " + q.poll());

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	void call() {
		for (int i = 0; i < 10; i++) {
			System.out.println("call ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

class Thread1 implements Runnable {
	PC pc;

	Thread1(PC pc) {
		this.pc = pc;
	}

	@Override
	public void run() {
		pc.produce();
	}
}

class Thread2 implements Runnable {
	PC pc;

	Thread2(PC pc) {
		this.pc = pc;
	}

	@Override
	public void run() {
		pc.consume();
	}
}

class Thread3 implements Runnable {
	PC pc;

	Thread3(PC pc) {
		this.pc = pc;
	}

	@Override
	public void run() {
		pc.call();
	}
}

class Thread4 implements Runnable {
	PC pc;

	Thread4(PC pc) {
		this.pc = pc;
	}

	@Override
	public void run() {
		PC.test();
	}
}

public class TestSyncronization {
	public static void main(String[] args) {
		PC pc = new PC();
		new Thread(new Thread4(pc)).start();
		new Thread(new Thread1(pc)).start();
		new Thread(new Thread2(pc)).start();
		// new Thread(new Thread3(pc)).start();

	}
}
