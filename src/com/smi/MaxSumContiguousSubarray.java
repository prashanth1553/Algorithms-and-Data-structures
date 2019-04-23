package com.smi;

import java.util.Arrays;
import java.util.List;

public class MaxSumContiguousSubarray {

	public static int maxSubArray(final List<Integer> A) {
		int maxSoFar = Integer.MIN_VALUE, currentMax = 0;
		int size = A.size();
		int start = 0, end, s = 0;
		for (int i = 0; i < size; i++) {
			currentMax += A.get(i);
			if (maxSoFar < currentMax) {
				maxSoFar = currentMax;
				start = s;
				end = i;
			}
			if (currentMax < 0) {
				s = i + 1;
				currentMax = 0;
			}

		}

		return maxSoFar;
	}

	public static void main(String args[]) {

		Integer a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		List<Integer> list = Arrays.asList(a);
		System.out.println(maxSubArray(list));
	}
}
