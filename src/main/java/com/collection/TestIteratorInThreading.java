package com.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
/*
class Test implements Runnable {
	HashMap<Integer, String> map;

	Test(HashMap<Integer, String> map) {
		this.map = map;
	}

	@Override
	public void run() {
		map.
	}

}*/

public class TestIteratorInThreading {

	public static void main(String[] args) {

		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "paras1");
		map.put(2, "paras2");
		map.put(3, "paras3");
		map.put(4, "paras4");
		map.put(5, "paras5");

		Iterator<Entry<Integer, String>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Integer, String> next = iterator.next();
			if (next.getKey() == 2)
				iterator.remove();
			
		
			
		}
		map.entrySet().stream().forEach(x -> System.out.println(x.getValue()));
	}
}
