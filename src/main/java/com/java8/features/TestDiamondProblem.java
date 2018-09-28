package com.java8.features;

interface Parent {
	default void test() {
	}
}

interface Child1 extends Parent {
	default void test() {

	}
}

interface Child2 extends Parent {
	default void test() {

	}
}

interface child3 extends Child1, Child2 {

	@Override
	default void test() {
	}

}

public class TestDiamondProblem {

}
