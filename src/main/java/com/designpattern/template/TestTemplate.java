package com.designpattern.template;

public class TestTemplate {
	public static void main(String[] args) {
		AbstractTemplate template = new TemplateImpl();
		template.build();
	}
}
