package com.collection;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class EnumrationTest {
	public static void main(String[] args) {

		Hashtable<String, String> vars = new Hashtable<String, String>();

		vars.put("POSTCODE", "TU1 3ZU");
		vars.put("EMAIL", "job.blogs@lumesse.com");
		vars.put("DOB", "02 Mar 1983");

		Enumeration<String> e = vars.keys();

		while (e.hasMoreElements()) {
			String next = e.nextElement();
			if (next.equals("POSTCODE"))
				vars.put("PARAS", "hi Hello");
			System.out.println(next);
		}

		System.out.println("--------------");
		System.out.println("--------------");
		Set<String> keySet = vars.keySet();
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String next = it.next();
			// if (next.equals("POSTCODE"))
			// vars.put("PARAS", "hi Hello");
			System.out.println(next);
		}

		System.out.println(keySet.size());

		System.out.println("--------------");
		System.out.println("--------------");

		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");

		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			list.add("Paras");
		}

	}
}
