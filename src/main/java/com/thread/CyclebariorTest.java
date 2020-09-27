package com.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class ChildThread implements Runnable {
	CyclicBarrier barrier;

	public ChildThread(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	@Override
	public void run() {
		try {
			System.out.println("Thread " + Thread.currentThread().getName());
			barrier.await();
			// Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread " + Thread.currentThread().getName() + " end");

	}
}

public class CyclebariorTest {
	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		CyclicBarrier barrier = new CyclicBarrier(4);
		new Thread(new ChildThread(barrier)).start();
		new Thread(new ChildThread(barrier)).start();
		new Thread(new ChildThread(barrier)).start();
		new Thread(new ChildThread(barrier)).start();
		//Thread.sleep(2000);
		System.out.println("Here");
		barrier.await();
		System.out.println(barrier.getParties());

		barrier.reset();
		new Thread(new ChildThread(barrier)).start();
		new Thread(new ChildThread(barrier)).start();
		new Thread(new ChildThread(barrier)).start();
		barrier.await();

	}
}
