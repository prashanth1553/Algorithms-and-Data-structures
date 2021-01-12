package com.solidprinciples.lsp;

public class ElectricCar {

	public void turnOnEngine() {
		throw new AssertionError("I don't have an engine!");
	}

	public void accelerate() {
		// this acceleration is crazy!
	}
}
