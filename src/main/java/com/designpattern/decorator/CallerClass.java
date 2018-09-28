package com.designpattern.decorator;

public class CallerClass {

	public static void main(String[] args) {
		new CarDecorator(new LuxuryCar(new SportsCar(new BasicCar()))).assmble();
	}
}
