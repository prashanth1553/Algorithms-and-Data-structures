package com.designpatterns.strategy;

public class AddStrategy implements Evaluate {

	@Override
	public int execute(int a, int b) {
		return a + b;
	}
}
