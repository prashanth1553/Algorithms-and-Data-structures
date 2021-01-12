package com.miscellaneous;

import java.util.ArrayList;

public class MinStepsInInfiniteGrid {

	public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
		if (A.size() <= 1) {
			return 0;
		}
		int steps = 0;
		int xf = A.get(0);
		int yf = B.get(0);
		for (int i = 1; i < A.size(); i++) {
			int xd = A.get(i) - xf;
			int yd = B.get(i) - yf;
			if (Math.abs(xd) > 0 && Math.abs(yd) > 0) {
				if (Math.abs(xd) > Math.abs(yd)) {
					steps += Math.abs(yd) + Math.abs((A.get(i) - xf) - yd);
				} else {
					steps += Math.abs(xd) + Math.abs(B.get(i) - (yf + xd));
				}
			} else if (Math.abs(xd) > 0) {
				steps += Math.abs(xd);
			} else {
				steps += Math.abs(yd);
			}
			xf = A.get(i);
			yf = B.get(i);
		}

		return steps;
	}

	public static void main(String args[]) {

		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(-7);
		a.add(-13);

		ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(1);
		b.add(-5);

		MinStepsInInfiniteGrid obj = new MinStepsInInfiniteGrid();

		System.out.println(obj.coverPoints(a, b));
	}
}
