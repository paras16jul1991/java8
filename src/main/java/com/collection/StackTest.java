package com.collection;

import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {

		Stack<Integer> e = new Stack<>();
		e.push(1);
		e.push(2);
		e.push(3);
		e.push(3);
		e.pop();

		System.out.println(e);
	}
}
