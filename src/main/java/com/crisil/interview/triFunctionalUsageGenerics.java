package com.crisil.interview;

public class triFunctionalUsageGenerics<X, Y, Z, R> {

	public TriFunction<X, Y, Z, R> sum(TriFunction<X, Y, Z, R> fun) {
		return fun;
	}

	public static void main(String[] args) {

		triFunctionalUsageGenerics<String, String, String, String> triSum = new triFunctionalUsageGenerics<String, String, String, String>();
		System.out.print(triSum.sum((x, y, z) -> {
			return x + y + z;
		}).apply("Hi", " How", " r u ? "));
	}

}
