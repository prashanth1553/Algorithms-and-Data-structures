package com.smi.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {

	public int lis(final List<Integer> A) {
		if (A.size() == 1) {
			return 1;
		}
		int longT[] = new int[A.size()];
		longT[0] = A.get(0);
		int length = 1;
		for (int i = 1; i < A.size(); i++) {
			int e = A.get(i);
			if (longT[0] > e) {
				longT[0] = e;
			} else if (e > longT[length - 1]) {
				longT[length++] = e;
			} else {
				longT[getMiddleIndex(longT, length, e)] = e;
			}

		}

		return length;
	}

	private int getMiddleIndex(int array[], int length, int key) {
		int lo = 0, hi = length - 1;
		int ceil = 0;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int e = array[mid];
			if (e == key) {
				return mid;
			} else if (e > key) {
				ceil = mid;
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}

		}
		return ceil;
	}

	public static void main(String args[]) {
		// Integer a1[] = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
		Integer a1[] = { 3, 3, 3, 3 };
		List<List<Integer>> data = new ArrayList<>(2);
		data.add(Arrays.asList(a1));
		LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
		System.out.println(obj.lis(Arrays.asList(a1)));
	}
}
