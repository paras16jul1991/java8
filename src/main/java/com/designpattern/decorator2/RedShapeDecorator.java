package com.designpattern.decorator2;

public class RedShapeDecorator extends ShapeDecorator {

	public RedShapeDecorator(Shape shape) {
		super(shape);
	}

	@Override
	public void Draw() {
		super.Draw();
		System.out.println("Red color added.");
	}
}
