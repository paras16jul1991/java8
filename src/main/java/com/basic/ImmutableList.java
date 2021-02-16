package com.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Person implements Cloneable {
	String name;

	Person(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

final class Employees {
	private final List<Person> persons = new ArrayList<Person>();

	public Employees(List<Person> persons) {
		persons.forEach(x -> this.persons.add(clone(x)));
	//	this.persons = Collections.unmodifiableList(new ArrayList<>(persons));
	}

	private Person clone(Person x) {
		try {
			return (Person) x.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Person> getPersons() {
		return persons;
	}
}

public class ImmutableList {

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<Person>();
		Person p1 = new Person("paras");
		Person p2 = new Person("parth");

		persons.add(p1);
		persons.add(p2);
		Employees ee = new Employees(persons);

		ee.getPersons().forEach(System.out::println);

		p2.name = "Pulastya";
		persons.add(new Person("Adi"));

		ee.getPersons().forEach(System.out::println);

	}
}
