package com.smi.twopointer;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfSortedArrays {

	public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
		ArrayList<Integer> result = new ArrayList<>();
		if (A.isEmpty()) {
			result.addAll(B);
			return result;
		}
		if (B.isEmpty()) {
			result.addAll(A);
			return result;
		}
		int p1 = 0;
		int p2 = 0;
		while (p1 < A.size() && p2 < B.size()) {
			int a = A.get(p1);
			int b = B.get(p2);
			if (a == b) {
				result.add(A.get(p1));
				p2++;
				p1++;
			} else if (a > b) {
				p2++;
			} else {
				p1++;
			}

		}
		return result;
	}
}
