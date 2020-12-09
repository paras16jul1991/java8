package com.java8.features;

interface AInterface {
	default void call() {
		System.out.println("Hello");
	}

	default void call2() {
		System.out.println("Hello2");
	}

	static void call3() {
		System.out.println("Hello3");
	}

	static void call4() {
		System.out.println("Hello4");
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
		test.call2();
		AInterface.call3();
		AInterface.call4();
	}

}
