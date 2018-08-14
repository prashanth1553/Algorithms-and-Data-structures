package com.miscellaneous;

public class LineIntersection {


	// Given three colinear points p, q, r, the function checks if
	// point q lies on line segment 'pr'
	boolean onSegment(Point p, Point q, Point r) {
		if (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) && q.y <= Math.max(p.y, r.y)
				&& q.y >= Math.min(p.y, r.y))
			return true;

		return false;
	}

	// To find orientation of ordered triplet (p, q, r).
	// The function returns following values
	// 0 --> p, q and r are colinear
	// 1 --> Clockwise
	// 2 --> Counterclockwise
	private int orientation(Point p1, Point p2, Point p3) {

		int val = (p2.y - p1.y) * (p3.x = p2.x) - (p3.y - p2.y) * (p2.x - p1.x);
		if (val > 0) {
			return 1;
		} else if (val < 0) {
			return 2;
		} else {
			return 0;
		}
	}

	public boolean doIntersect(Line l1, Line l2) {

		int d1 = orientation(l1.p, l1.q, l2.p), d2 = orientation(l1.p, l1.q, l2.q);
		int d3 = orientation(l2.p, l2.q, l1.p), d4 = orientation(l2.p, l2.q, l1.q);

		if (d1 != d2 && d3 != d4) {
			return true;
		} else if (d1 == 0 && onSegment(l1.p, l2.p, l1.q)) {
			return true;
		} else if (d2 == 0 && onSegment(l1.p, l2.q, l1.q)) {
			return true;
		} else if (d3 == 0 && onSegment(l2.p, l1.p, l2.q)) {
			return true;
		} else if (d4 == 0 && onSegment(l2.p, l1.q, l2.q)) {
			return true;
		}
		return false;
	}

	public static void main(String args[]) {
		LineIntersection lineIntersection = new LineIntersection();
		
		Point p1 = new Point(1, 1), q1 = new Point(10, 1);
		Point p2 = new Point(1, 2), q2 = new Point(10, 2);

		Line l1 = new Line(p1, q1);
		Line l2 = new Line(p2, q2);
		
		System.out.println("intersect " + lineIntersection.doIntersect(l1, l2));
		
		p1 = new Point(10, 0); q1 = new Point(0, 10);
		p2 = new Point(0, 0); q2 = new Point(10, 10);

		l1 = new Line(p1, q1);
		l2 = new Line(p2, q2);
		
		System.out.println("intersect " + lineIntersection.doIntersect(l1, l2));
		
	}

}
