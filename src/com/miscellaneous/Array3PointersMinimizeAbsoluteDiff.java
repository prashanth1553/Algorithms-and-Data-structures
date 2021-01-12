package com.miscellaneous;

import java.util.List;

public class Array3PointersMinimizeAbsoluteDiff {

	public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
		int ans = Integer.MAX_VALUE;
		int p1 = 0, p2 = 0, p3 = 0;
		while (p1 < A.size() && p2 < B.size() && p3 < C.size()) {
			int currentMax = Math.max(getAbsDiff(A, B, p1, p2), getAbsDiff(A, C, p1, p3));
			currentMax = Math.max(currentMax, getAbsDiff(B, C, p2, p3));
			ans = Math.min(ans, currentMax);
			if (A.get(p1) <= B.get(p2) && A.get(p1) <= C.get(p3)) {
				p1++;
			} else if (B.get(p2) <= C.get(p3)) {
				p2++;
			} else {
				p3++;
			}

		}

		return ans;
	}

	public static int getAbsDiff(List<Integer> A, List<Integer> B, int i, int j) {

		return Math.abs(A.get(i) - B.get(j));
	}
}
