package com.thread;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestCompleteableFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
			return "1";
		});

		CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "2";
		});

		CompletableFuture<String> cf3 = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "3";
		});

		for (int i = 0; i < 10; i++)
			System.out.println("Here");

		List<String> collect = Stream.of(cf1, cf2, cf3).map(CompletableFuture::join).collect(Collectors.toList());

		System.out.print(collect);
	}

}
