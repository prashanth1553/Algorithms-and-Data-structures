package com.designpatterns.strategy;

public class MultiplyStrategy implements Evaluate {

	@Override
	public int execute(int a, int b) {
		return a * b;
	}
}
