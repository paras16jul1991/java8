package com.basic;

abstract class A {

	A() {
		System.out.println("Inside A Constructor");
		test();
	}

	Number check() {
		return null;
	}

	void testT() {
		test();
	}

	abstract void test();
}

class B extends A {

	public B() {
		System.out.println("Inside B Constructor");
	}

	@Override
	void test() {
		System.out.println("inside test");
	}
}

public class TestJava {

	public static void main(String[] args) {
		Integer i = new Integer(10);
		System.out.println(i.toString());

		B b = new B();
	}

	public static void main(int[] args) {

	}
}
