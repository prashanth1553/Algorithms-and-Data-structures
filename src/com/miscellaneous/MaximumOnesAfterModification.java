package com.miscellaneous;

public class MaximumOnesAfterModification {

	public int solve(int[] A, int B) {
		if (B >= A.length || A.length <= 0) {
			return A.length;
		}
		int ans = Integer.MIN_VALUE;
		int p1 = 0;
		int zeroCount = 0;
		int p2 = 0;
		while (p2 < A.length) {
			if (A[p2] == 0) {
				zeroCount++;
			}
			while (zeroCount > B) {
				if (A[p1] == 0) {
					zeroCount--;
				}
				p1++;
			}
			ans = Math.max(ans, p2 - p1 + 1);
			p2++;

		}

		return ans;
	}

}
