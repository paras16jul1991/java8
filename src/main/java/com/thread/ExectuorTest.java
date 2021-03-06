package com.thread;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExectuorTest {

	public static void main(String[] args) {
		ExecutorService exe = Executors.newFixedThreadPool(4);

		for (int i = 0; i < 10; i++) {
			exe.execute(() -> {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
			});
		}
		exe.shutdown();
	}
}