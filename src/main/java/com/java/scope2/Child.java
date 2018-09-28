package com.java.scope2;

import com.java.scope.Parent;

public class Child implements Parent {

	@Override
	public void call() {
	}

	public static void main(String[] args) {

		synchronized (args) {
		}
	}
}
