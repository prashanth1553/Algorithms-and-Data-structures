package com.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MaximumSumTriplet {

	public int solve(ArrayList<Integer> A) {
		if (A.size() < 3) {
			return 0;
		}
		int length = A.size();
		int ans = 0;
		int suffixArray[] = new int[A.size()];
		suffixArray[length - 1] = A.get(length - 1);
		for (int i = length - 2; i >= 0; i--) {
			suffixArray[i] = Math.max(suffixArray[i + 1], A.get(i));
		}
		TreeSet<Integer> prefixSorting = new TreeSet<>();
		prefixSorting.add(A.get(0));
		for (int i = 1; i < length - 1; i++) {
			if (A.get(i) < suffixArray[i + 1]) {
				Integer lessThan = prefixSorting.floor(A.get(i));
				if (lessThan != null && lessThan.equals(A.get(i))) {
					prefixSorting.remove(lessThan);
					lessThan = prefixSorting.floor(A.get(i));
				}
				if (lessThan != null) {
					ans = Math.max(ans, A.get(i) + lessThan + suffixArray[i + 1]);
				}
			}
			prefixSorting.add(A.get(i));
		}

		return ans;
	}

	public static void main(String args[]) {
		MaximumSumTriplet obj = new MaximumSumTriplet();
		int arr[] = { 2, 5, 3, 1, 4, 9 };
		ArrayList<Integer> A = (ArrayList<Integer>) Arrays.stream(arr).boxed().collect(Collectors.toList());
		System.out.println(obj.solve(A));
	}
}
