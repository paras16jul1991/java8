package com.designpattern.decorator;

public class SportsCar extends CarDecorator {

	public SportsCar(Car car) {
		super(car);
	}

	@Override
	public void assmble() {
		super.assmble();
		System.out.println("Sport car feaure added.");
	}

}
