package com.thread;

import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCustomThreadPool {

	public static void main(String[] args) {

		ThreadPool pool = new ThreadPool(3);
		for (int i = 0; i < 10; i++)
			pool.execute(() -> {
				try {
					System.out.println(Thread.currentThread().getName());
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				//	e.printStackTrace();
				}
			});

		pool.shutdown();
	}
}

class CallThread implements Runnable {
	private BlockingQueue<Runnable> q;

	CallThread(BlockingQueue<Runnable> q) {
		this.q = q;
	}

	@Override
	public void run() {
		try {
			while (true) {
				Runnable take = q.take();
				take.run();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class ThreadPool {

	BlockingQueue<Runnable> que;
	HashSet<Thread> threads;

	ThreadPool(int size) {
		que = new ArrayBlockingQueue<>(size);
		threads = new HashSet<>();
		int count = 0;
		while (count < size) {
			Thread thread = new Thread(new CallThread(que));
			threads.add(thread);
			thread.start();
			count++;
		}
	}

	public void shutdown() {
		synchronized (que) {
			Iterator<Thread> iterator = threads.iterator();
			while (iterator.hasNext()) {
				Thread t = iterator.next();
				if (!t.interrupted())
					t.interrupt();
			}
		}
	}

	void execute(Runnable runn) {
		try {
			que.put(runn);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
