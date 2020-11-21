package com.designpatterns.factory;

public class Bike implements Vehicle {

	@Override
	public int getNumberOfWheels() {
		return 2;
	}

	@Override
	public void drive() {
		System.out.println("Driving BIKE");
	}

}
