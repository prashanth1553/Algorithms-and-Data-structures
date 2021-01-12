package com.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxContinuousSeriesOf1s {

	public int[] maxone(int[] A, int B) {
		if (B >= A.length) {
			int[] array = new int[A.length];
			Arrays.setAll(array, i -> i++);
			return array;
		}
		int p1 = 0;
		int p2 = 0;
		int zeroCount = 0;
		int l = 0;
		int ans = Integer.MIN_VALUE;
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
			int at = p2 - p1 + 1;
			if (at > ans) {
				ans = at;
				l = p1;
			}
			p2++;
		}
		int aa[] = new int[ans];
		for (int i = 0; i < ans; i++) {
			aa[i] = l++;
		}
		return aa;
	}

	public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
		int start = 0;
		int len = A.size();
		int p1 = 0;
		int p2 = 0;
		int zeros = B;
		int lastZero = -1;
		int[] ans = new int[2];

		int maxLen = Integer.MIN_VALUE;

		while (start < len) {
			if (A.get(start).equals(0)) {
				if (lastZero == -1) {
					lastZero = start;
				}
				if (zeros == 0) {
					if (maxLen < (p2 - p1)) {
						ans[0] = p1;
						ans[1] = p2 - 1;
						maxLen = p2 - p1;
					}
					p1 = lastZero + 1;
					start = p1;
					lastZero = -1;
					p2 = p1;
					zeros = B;
				} else {
					zeros--;
					start++;
					p2++;
				}
			} else {
				start++;
				p2++;
			}
		}

		if (maxLen < p2 - p1) {
			ans[0] = p1;
			ans[1] = p2 - 1;
		}
		ArrayList<Integer> res = new ArrayList<>();
		start = ans[0];
		while (start <= ans[1]) {
			res.add(start++);
		}

		return res;
	}
}
