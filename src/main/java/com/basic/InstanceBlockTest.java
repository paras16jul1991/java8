package com.basic;

class Aaaa {
	{
		System.out.println("Aaaas");
	}
}

class Bbbbb extends Aaaa {
	{
		System.out.println("Bbbbb");
	}
}

public class InstanceBlockTest extends Bbbbb {
	{
		System.out.println("InstaceBlock");
	}

	public InstanceBlockTest(String a) {
		System.out.println("InstaceBlock - P Constructor");
	}

	public InstanceBlockTest() {
		System.out.println("InstaceBlock - Constructor");
	}

	public static void main(String[] args) {
		InstanceBlockTest test = new InstanceBlockTest();
	}
}
