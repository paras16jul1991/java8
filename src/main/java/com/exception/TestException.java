package com.exception;

public class TestException {
	public static void main(String[] args) {
		String a = new TestException().test();
	}

	private String test() {

		try {
			throw new Exception("Test");
		} catch (Exception e) {
			// return "d";

		} finally {
			// return "a";
		}

		return "b";
	}
}
