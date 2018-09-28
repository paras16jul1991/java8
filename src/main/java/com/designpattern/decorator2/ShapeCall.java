package com.designpattern.decorator2;

public class ShapeCall {

	public static void main(String[] args) {
		Shape d = new Circle();
		d.Draw();

		Shape dd = new RedShapeDecorator(new Line());
		dd.Draw();
	}
}
