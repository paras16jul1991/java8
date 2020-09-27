package com.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestCopyOnArrayLIst {
	public static void main(String[] args) {
		List<String> test = new CopyOnWriteArrayList<String>();
		test.add("paras1");
		test.add("paras2");
		test.add("paras3");
		test.add("paras4");
		test.add("paras5");

		for (String str : test) {
			if (str.equals("paras4")) {
				test.add("paras7");
				System.out.println(test);
			}
		}

		for (String str : test) {
			System.out.println(str);
		}

	}
}
