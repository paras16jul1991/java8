package com.basic;
import java.util.function.Function;

public class MainCall {

	public static void main(String[] args) {

		Function<String, String> funIn = x -> x;
		Function<Function<String, String>, String> f = x -> x.apply("Hello");
		System.out.print("--" + f.apply(funIn));
	}
}
