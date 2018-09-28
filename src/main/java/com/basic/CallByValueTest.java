package com.basic;

class AA {
	public String name;
}

public class CallByValueTest {

	public static void main(String[] args) {
		AA aa = new AA();
		aa.name = "paras";
		change(aa);
		System.out.print(aa.name);
	}

	private static void change(AA aa) {
		aa.name = "Abhinav";
		AA bb = aa;
		bb.name = "Umesh";
		bb = null;
	}
}
