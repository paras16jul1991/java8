package com.thread;

class TestT implements Runnable {

	private void check() {
		int a = 5 / 0;
	}

	@Override
	public void run() {
		check();
		System.out.println("checks");
	}
}

public class ThreadException {
	public static void main(String[] args) {
		new Thread(new TestT()).start();
		System.out.println("Th");
	}
}
