package com.exception;

class ParentService {

	int callChildservice() {
		return new Service().add();
	}
}

class Service {

	int add() {
		return 1 / 0;
	}
}

public class TsetException {
	public static void main(String[] args) {
		try {
			new ParentService().callChildservice();
		} catch (Exception e) {
			System.out.println("Exception occured");
		}
	}
}
