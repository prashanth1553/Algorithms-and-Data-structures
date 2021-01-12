package com.solidprinciples.ocp;

public class Circle implements Shape {

	private double radius;

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double area() {
		return 3.14 * Math.pow(radius, 2);
	}

}
