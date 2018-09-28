package com.designpattern.decorator;

public class CarDecorator implements Car {

	Car car;

	public CarDecorator(Car car) {
		this.car = car;
	}

	public void assmble() {
		this.car.assmble();
	}
}
