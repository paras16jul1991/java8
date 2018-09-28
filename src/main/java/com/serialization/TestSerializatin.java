package com.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Parent {
	String field;
}

class Employee extends Parent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String name;
	Integer salary;
	int age;
	final int id = 2;
	transient String location = "India";
	static int deptCode;

	@Override
	public String toString() {
		return this.name + " " + this.field + " " + this.salary + " " + this.age + " " + this.id + " " + this.location
				+ " " + this.deptCode;
	}
}

public class TestSerializatin {

	void serialize(Employee e) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(
					new File("C:\\Users\\parass\\Downloads\\test.txt"));
			ObjectOutputStream oStream = new ObjectOutputStream(fileOutputStream);
			oStream.writeObject(e);
			//oStream.writeObject(e.field);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	Employee deSerialize() {
		Employee e = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(new File("C:\\Users\\parass\\Downloads\\test.txt"));
			ObjectInputStream stream = new ObjectInputStream(fileInputStream);
			e = (Employee) stream.readObject();
		//	e.field = (String) stream.readObject();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;
	}

	public static void main(String[] args) {
		TestSerializatin test = new TestSerializatin();

		Employee e = new Employee();
		e.name = "Paras";
		e.salary = 10000;
		e.location = "india";
		e.age = 22;
		e.deptCode = 4;
		e.field = "Field";

		System.out.println(e);
		test.serialize(e);

		e.deptCode = 9;

		System.out.println(test.deSerialize());
	}
}
