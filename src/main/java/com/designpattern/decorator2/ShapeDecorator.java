package com.designpattern.decorator2;

public class ShapeDecorator implements Shape {

	Shape shape;

	public ShapeDecorator(Shape shape) {
		this.shape = shape;
	}

	@Override
	public void Draw() {
		this.shape.Draw();
	}

}
