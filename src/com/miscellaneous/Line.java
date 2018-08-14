package com.miscellaneous;

public class Line {

	public Point p, q;

	public Line(Point p, Point q) {
		this.p = p;
		this.q = q;
		q.isLeft = false;
		p.line = this;
		q.line = this;
	}

	public boolean isVertical() {
		return p.x == q.x;

	}

	@Override
	public String toString() {
		return "Line [p=" + p + ", q=" + q + "]";
	}

}
