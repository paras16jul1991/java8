package com.java8.features;

interface AInterface {
	default void call() {
		System.out.println("Hello");
	}
}

interface ASubInterface extends AInterface {

}

interface A1SubInterface extends AInterface {

}

public class DefaultMethodTest implements A1SubInterface, ASubInterface {

	public static void main(String[] args) {
		DefaultMethodTest test = new DefaultMethodTest();
		test.call();
	}

}
