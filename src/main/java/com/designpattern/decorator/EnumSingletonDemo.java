package com.designpattern.decorator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

enum SingleInstance {
	INSTANCE;

	private SingleInstance() {
		System.out.println("constructor");
	}
}

public class EnumSingletonDemo {

	public static void main(String args[])
			throws FileNotFoundException, IOException, ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		SingleInstance s = SingleInstance.INSTANCE;
		SingleInstance s1 = SingleInstance.INSTANCE;

		System.out.println(s.hashCode() + " " + s1.hashCode());// prints same
																// hashcode
																// indicates
																// only one
																// instance
																// created

		// ------- Serialization -------
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("sample.ser"));
		oos.writeObject(s);
		oos.close();

		// ------- De-Serialization -------
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("sample.ser"));
		SingleInstance s2 = (SingleInstance) ois.readObject();

		System.out.println("Serialization :: " + s.hashCode() + " " + s2.hashCode());// prints
																						// same
																						// hashcodes
																						// because
																						// JVM
																						// handles
																						// serialization
																						// in
																						// case
																						// of
																						// enum(we
																						// dont
																						// need
																						// to
																						// override
																						// readResolve()
																						// method)

		// -----Accessing private enum constructor using Reflection-----

		Class c = Class.forName("SingleInstance");

		Constructor co = c.getDeclaredConstructor();// throws
													// NoSuchMethodException
		co.setAccessible(true);
		SingleInstance newInst = (SingleInstance) co.newInstance();

	}
}