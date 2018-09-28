package com.designpattern.template;

public abstract class AbstractTemplate {

	public final void build() {
		step1();
		step2();
		step3();
		step4();
	}

	public abstract void step1();

	public abstract void step2();

	public abstract void step3();

	public abstract void step4();
}
