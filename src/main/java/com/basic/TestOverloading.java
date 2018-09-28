package com.basic;

public class TestOverloading {

	void call(int... a) {
		System.out.println("inside int");
	}

	void call(float a) {
		System.out.println("inside float");
	}

	void call(Integer a) {
		System.out.println("inside Integer");
	}

	void call(Object a) {
		System.out.println("inside Object");
	}

	public static void main(String[] args) {
		new TestOverloading().call();
	}
}
