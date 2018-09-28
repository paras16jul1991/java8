package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

class Task implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		return 1;
	}

}

class MyResource implements AutoCloseable {

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
	}
}

public class FutureTaskExample {
	private static void tryWithResourceException() throws Exception {
		try (MyResource mr = new MyResource()) {
			System.out.println("MyResource created in try-with-resources");
			if (true)
				throw new Exception("Exception in try");
		}
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<Integer> task = new FutureTask<>(new Task());
		new Thread(task).start();
		System.out.println(task.get());

		ExecutorService service = Executors.newFixedThreadPool(2);
		Future<Integer> result = service.submit(new Task());
		System.out.println(result.get());
		service.shutdown();
	}
}
