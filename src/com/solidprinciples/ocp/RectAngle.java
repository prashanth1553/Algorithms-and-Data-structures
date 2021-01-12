package com.solidprinciples.ocp;

public class RectAngle implements Shape {

	private double width;
	private double hight;

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHight() {
		return hight;
	}

	public void setHight(double hight) {
		this.hight = hight;
	}

	@Override
	public double area() {
		return width * hight;
	}

}
