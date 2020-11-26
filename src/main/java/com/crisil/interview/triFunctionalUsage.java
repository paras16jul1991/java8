package com.crisil.interview;

@FunctionalInterface
interface TriFunction<X, Y, Z, R> {

	R apply(X x, Y y, Z z);
}

public class triFunctionalUsage {

	public TriFunction<Integer, Integer, Integer, Integer> sum(TriFunction<Integer, Integer, Integer, Integer> fun) {
		return fun;
	}

	public static void main(String[] args) {

		triFunctionalUsage triSum = new triFunctionalUsage();
		System.out.print(triSum.sum((x, y, z) -> {
			return x + y + z;
		}).apply(10, 20, 30));
	}

}
