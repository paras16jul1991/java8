package com.designpattern.decorator;

public class LuxuryCar extends CarDecorator {

	public LuxuryCar(Car car) {
		super(car);
	}

	@Override
	public void assmble() {
		super.assmble();
		System.out.println("Luxury car feaure added.");
	}
}
