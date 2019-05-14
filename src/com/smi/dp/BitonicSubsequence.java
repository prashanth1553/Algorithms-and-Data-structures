package com.smi.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BitonicSubsequence {

	public int longestSubsequenceLength(final List<Integer> A) {
		if (A.size() == 0) {
			return 0;
		}
		if (A.size() == 1) {
			return 1;
		}
		int ans = Integer.MIN_VALUE;
		int[] increasingrank = new int[A.size()];
		int[] decreasingRank = new int[A.size()];

		int[] increasingSubSequence = new int[A.size()];
		int[] decreasingSubSequence = new int[A.size()];

		// increasing part
		increasingSubSequence[0] = A.get(0);
		increasingrank[0] = 1;
		int length = 1;
		for (int i = 1; i < A.size(); i++) {
			int e = A.get(i);
			if (e < increasingSubSequence[0]) {
				increasingSubSequence[0] = A.get(i);
				increasingrank[i] = 1;
			} else if (e > increasingSubSequence[length - 1]) {
				increasingSubSequence[length++] = e;
				increasingrank[i] = length;
			} else {
				int ceil = getCeil(increasingSubSequence, 0, length, e);
				increasingSubSequence[ceil] = e;
				increasingrank[i] = ceil + 1;
			}

		}
		// decreasing part
		int[] reverse = new int[A.size()];
		for (int i = A.size() - 1; i >= 0; i--) {
			reverse[A.size() - 1 - i] = A.get(i);
		}

		int increasingLength = 1;
		decreasingSubSequence[0] = reverse[0];
		decreasingRank[0] = 1;
		for (int i = 1; i < A.size(); i++) {
			int e = reverse[i];
			if (e < decreasingSubSequence[0]) {

				decreasingSubSequence[0] = e;
				decreasingRank[i] = 1;
			} else if (e > decreasingSubSequence[increasingLength - 1]) {
				decreasingSubSequence[increasingLength++] = e;
				decreasingRank[i] = increasingLength;

			} else {
				int ceil = getCeil(decreasingSubSequence, 0, increasingLength, e);
				decreasingSubSequence[ceil] = e;
				decreasingRank[i] = ceil + 1;
			}

		}
		revereseArr(decreasingRank);
		for (int i = 0; i < A.size(); i++) {
			if (ans < (increasingrank[i] + decreasingRank[i] - 1))
				ans = (decreasingRank[i] + increasingrank[i] - 1);
		}

		return ans;
	}

	private int getCeil(int array[], int lo, int length, int key) {
		int hi = length - 1;
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

	void revereseArr(int arr[]) {
		int i = 0;
		int j = arr.length - 1;
		while (i < j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}

	public static void main(String args[]) {
		Integer a1[] = { 1, 11, 2, 10, 4, 5, 2, 1 };
		BitonicSubsequence obj = new BitonicSubsequence();
		System.out.println(obj.longestSubsequenceLength(Arrays.asList(a1)));
	}

}
