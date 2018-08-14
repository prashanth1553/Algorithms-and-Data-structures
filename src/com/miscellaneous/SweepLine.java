package com.miscellaneous;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SweepLine {

	public List<List<Line>> intersectingLines(List<Line> lines) {

		PriorityQueue<Point> priorityQueue = new PriorityQueue<>(2 * lines.size(), new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				return o1.x - o2.x;
			}
		});

		for (Line line : lines) {
			priorityQueue.add(line.p);
			if (!line.isVertical()) {
				priorityQueue.add(line.q);
			}
		}

		TreeSet<Line> bst = new TreeSet<>(new Comparator<Line>() {

			@Override
			public int compare(Line o1, Line o2) {
				return o1.p.y - o2.p.y;
			}
		});
		List<List<Line>> intsersectingLines = new ArrayList<>();

		while (!priorityQueue.isEmpty()) {
			Point point = priorityQueue.poll();
			Line line = point.line;
			if (line.isVertical()) {

				Set<Line> iLines = bst.subSet(point.line, new Line(line.q, line.p));
				if (!iLines.isEmpty()) {
					intsersectingLines.add(iLines.stream().collect(Collectors.toList()));
				}

			} else {
				if (point.isLeft) {
					bst.add(line);
				} else {
					bst.remove(line);
				}

			}

		}

		return intsersectingLines;

	}

	public static void main(String args []) {

		SweepLine sweepLine = new SweepLine();

		Point p1 = new Point(1, 2), q1 = new Point(10, 2); // horizontal line 1
		Point p2 = new Point(2, 3), q2 = new Point(11, 3); // horizontal line 2
		Point p3 = new Point(6, 1), q3 = new Point(6, 11); // vertical line

		Line l1 = new Line(p1, q1);
		Line l2 = new Line(p2, q2);
		Line l3 = new Line(p3, q3);
		List<Line> lines = new ArrayList<>();
		lines.add(l1);
		lines.add(l2);
		lines.add(l3);

		Point p4 = new Point(3, 4), q4 = new Point(12, 4); 
		lines.add(new Line(p4, q4));
		// out of range point
		Point p5 = new Point(5, 13), q5 = new Point(8, 13); 
		lines.add(new Line(p5, q5));
		
		List<List<Line>> intsersectingLines = sweepLine.intersectingLines(lines);

		for (List<Line> ilines : intsersectingLines) {
			for (Line line : ilines) {
				System.out.println(line.toString());
			}

		}

	}

}
