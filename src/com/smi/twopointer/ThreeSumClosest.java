package com.smi.twopointer;

import java.util.ArrayList;
import java.util.Collections;

public class ThreeSumClosest {

	public int threeSumClosest(ArrayList<Integer> A, int B) {
		Collections.sort(A);
		int result = A.get(0) + A.get(1) + A.get(2);
		for (int i = 0; i < A.size(); i++) {
			int j = i + 1, k = A.size() - 1;
			int a = A.get(i);
			while (j < k) {
				int sum = a + A.get(j) + A.get(k);
				if (sum == B) {
					return B;
				}
				if (Math.abs(sum - B) < Math.abs(result - B)) {
					result = sum;
				}

				if (sum > B) {
					k--;
				} else {

					j++;
				}
			}

		}

		return result;
	}
}
