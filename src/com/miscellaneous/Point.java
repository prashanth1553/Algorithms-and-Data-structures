package com.miscellaneous;

public class Point {

	public int x, y;
	
	public Line line = null;
	
	public boolean isLeft = true;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", isLeft=" + isLeft + "]";
	}
	
	
}
