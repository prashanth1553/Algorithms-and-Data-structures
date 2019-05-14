package com.smi.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumWithoutAdjacentElements {

	public int adjacent(List<List<Integer>> A) {
		int dp[][] = new int[2][A.get(0).size()];
		int ans = Integer.MIN_VALUE;
		if (A.get(0).size() == 1) {
			return Math.max(A.get(0).get(0), A.get(1).get(0));
		}
		if (A.get(0).size() == 2) {
			int a = Math.max(A.get(0).get(0), A.get(1).get(0));
			int b = Math.max(A.get(0).get(1), A.get(1).get(1));
			return Math.max(a, b);
		}
		dp[0][0] = A.get(0).get(0);
		dp[0][1] = A.get(0).get(1);
		dp[1][0] = A.get(1).get(0);
		dp[1][1] = A.get(1).get(1);
		ans = Math.max(ans, dp[0][0]);
		ans = Math.max(ans, dp[0][1]);
		ans = Math.max(ans, dp[1][0]);
		ans = Math.max(ans, dp[1][1]);

		for (int j = 2; j < A.get(0).size(); j++) {
			for (int i = 0; i < 2; i++) {
				int c = 0;
				c = Math.max(dp[0][j - 2], dp[1][j - 2]);
				if (j - 3 >= 0) {
					int e = Math.max(dp[0][j - 3], dp[1][j - 3]);
					c = Math.max(c, e);
				}

				int d = Math.max(c + A.get(i).get(j), A.get(i).get(j));
				dp[i][j] = d;
				ans = Math.max(ans, d);
			}

		}

		return ans;
	}

	public static void main(String args[]) {
		Integer a1[] = { 16, 5, 54, 55, 36, 82, 61, 77, 66, 61 };
		Integer a2[] = { 31, 30, 36, 70, 9, 37, 1, 11, 68, 14 };
		List<List<Integer>> data = new ArrayList<>(2);
		data.add(Arrays.asList(a1));
		data.add(Arrays.asList(a2));
		MaxSumWithoutAdjacentElements obj = new MaxSumWithoutAdjacentElements();
		System.out.println(obj.adjacent(data));
	}
}
