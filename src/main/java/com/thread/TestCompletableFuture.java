package com.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCompletableFuture {

	public Future<String> calculateAsync() throws InterruptedException {
		CompletableFuture<String> completableFuture = new CompletableFuture<>();

		Executors.newCachedThreadPool().submit(() -> {
			Thread.sleep(500);
			completableFuture.complete("Hello");
			System.out.println("Test");
			return null;
		});

		return completableFuture;
	}

	public static void main(String[] args) throws Exception {
		TestCompletableFuture test = new TestCompletableFuture();
		Future<String> calculateAsync = test.calculateAsync();
	//	System.out.println(calculateAsync.get());
	}

}
