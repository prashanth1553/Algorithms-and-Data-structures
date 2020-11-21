package com.designpatterns.factory;

public class Car implements Vehicle {

	@Override
	public int getNumberOfWheels() {
		return 4;
	}

	@Override
	public void drive() {
		System.out.println("Driving car");
	}

}
