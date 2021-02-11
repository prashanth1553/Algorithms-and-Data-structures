package com.miscellaneous;

import java.util.ArrayList;

public class NumberOfSubarraysHavingSumLessThanK {

	public int solve(ArrayList<Integer> A, int B) {
		int n = A.size();
		int count = 0;
		int sum = A.get(0);
		int p1 = 0, p2 = 0;
		while (p1 < n && p2 < n) {
			if (sum < B) {
				p2++;
				count += (p2 - p1);
				if (p2 < n)
					sum += A.get(p2);
			} else {
				sum -= A.get(p1);
				p1++;
			}
		}

		return count;

	}
}
