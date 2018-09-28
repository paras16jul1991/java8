package com.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestFutureTask {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService pool = Executors.newFixedThreadPool(2);
		Future<Integer> submit3 = pool.submit(() -> 1);
		Future<Integer> submit2 = pool.submit(() -> 1);
		Future<Integer> submit = pool.submit(() -> 1);
		System.out.println(submit.get() + submit2.get() + submit3.get());
		pool.shutdown();
	}
}
