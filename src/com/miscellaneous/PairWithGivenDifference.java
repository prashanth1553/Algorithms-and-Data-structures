package com.miscellaneous;

import java.util.ArrayList;
import java.util.Collections;

public class PairWithGivenDifference {

	/**
	 * B can be negative
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public int diffPossibleWhereBCanBeNegative(ArrayList<Integer> A, int B) {
		Collections.sort(A);
		int p1 = 0, p2 = 0;
		while (p2 < A.size() && p1 < A.size()) {
			int d = A.get(p2) - A.get(p1);
			if (d == B && p1 != p2) {
				return 1;
			} else if (d > B) {
				p1++;
			} else {
				p2++;
			}
		}
		return 0;
	}

	/**
	 * Here B always Positive. diffPossibleWhereBCanBeNegative method logic works
	 * for it but as B is positive we can p1==p2 condition
	 * 
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public int diffPossible(ArrayList<Integer> A, int B) {
		if (A.size() <= 1) {
			return 0;
		}
		int p1 = 0, p2 = 1;
		while (p2 < A.size()) {
			int diff = A.get(p2) - A.get(p1);
			if (diff == B) {
				return 1;
			}
			if (diff > B) {
				if (p1 + 1 == p2) {
					p1++;
					p2++;
				} else {
					p1++;
				}
			} else {
				p2++;
			}
		}
		return 0;
	}
}
