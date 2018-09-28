package com.basic;
import javax.xml.bind.annotation.XmlElement;

public class Model {

	private String a;
	private String b;

	String nameA;

	public Model(String a) {
		this.a = a;
	}

	public Model(String a, String b) {
		this.a = a;
		this.b = b;
	}

	@XmlElement(name = "hello")
	public String getA() {
		return a;
	}

	private static String get() {
		return "";
	}

	public void setA(String a) {
		this.a = a;
	}
}