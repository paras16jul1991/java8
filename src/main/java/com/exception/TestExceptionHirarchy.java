package com.exception;

import java.io.IOException;

class Parent {
	void check() throws Exception {

	}
}

class child extends Parent {
	@Override
	void check() throws IOException {
	}
}

public class TestExceptionHirarchy {

}
