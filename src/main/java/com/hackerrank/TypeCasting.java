package com.hackerrank;

class TypeCasting {
	public static void main(String s[]) {
		A a = new A();
		a.i = 21;
		B b = new B();
		b.i = 43;
		b.j = 25;

		B b2 = (B) a; // LINE X

		System.out.println("i = " + b2.i); // LINE Y
	}

}
