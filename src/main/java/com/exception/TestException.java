package com.exception;

public class TestException {
	public static void main(String[] args) {
		String a = new TestException().test();
		System.out.print(a);
	}

	private String test() {

		try {
			throw new RuntimeException("Test");
		} catch (Exception e) {
			 return "d";

		} finally {
	 	 return "a";
		}

	//	return "b";
	}
}
