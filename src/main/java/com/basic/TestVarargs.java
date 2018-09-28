package com.basic;

import java.util.ArrayList;
import java.util.List;

public class TestVarargs {
	public static void main(String[] args) {
		asList(10);
		asList(10, 10);
		asList();
	}

	public static <T> List<T> asList(T... a) {
		System.out.println("here1");
		return new ArrayList<T>();
	}

	public static <T> List<T> asList(T a) {
		System.out.println("here2");
		return new ArrayList<T>();
	}

}
