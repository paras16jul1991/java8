package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ForLoopExecutionTest {

	AtomicInteger intg = new AtomicInteger(0);
	AtomicInteger maxintg = new AtomicInteger(20);

	void exec() {
		while (intg.get() < maxintg.get()) {
			System.out.println(intg.getAndIncrement() + " " + Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(2);
		ForLoopExecutionTest test = new ForLoopExecutionTest();
		pool.execute(() -> test.exec());
		pool.execute(() -> test.exec());
		pool.shutdown();
	}
}
