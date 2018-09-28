package com.collection;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestCopyOnArrayLIst {
	public static void main(String[] args) {
		List<String> test = new CopyOnWriteArrayList<>();
		test.add("paras1");
		test.add("paras2");
		test.add("paras3");
		test.add("paras4");
		test.add("paras5");

		for (String str : test) {
			test.remove("paras4");
		}

		for (String str : test) {
			System.out.println(str);
		}

	}
}
