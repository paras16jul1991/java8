package com.java8.features;

import java.util.Optional;

public class OptionalTest {
	public static void main(String[] args) throws Exception {

		String test = null;
		Optional.ofNullable(test).orElseThrow(Exception::new);
		// System.out.println(orElseGet);
		// optnl.ifPresent(x -> System.out.println(x));
		// System.out.println(optnl.isPresent());

	}
}
