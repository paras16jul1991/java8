package com.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Product {
	int id;

	public Product(int id) {
		this.id = id;
	}
}

class ProductMachine {

	BlockingQueue<Product> q = new ArrayBlockingQueue<Product>(5);

	void produce() throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			Thread.sleep(100);
			System.out.println("Product Produced" + i);
			q.put(new Product(i));

		}
	}

	void consume() throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			Thread.sleep(5000);
			Product take = q.take();
			System.out.println("Product Consumed" + take.id);

		}
	}
}

public class ProduceConsumerProb {
	public static void main(String[] args) {
		ProductMachine p = new ProductMachine();
		new Thread(() -> {
			try {
				p.produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		new Thread(() -> {
			try {
				p.consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
}
