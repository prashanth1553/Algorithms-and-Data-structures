package com.smi;

import java.util.Arrays;
import java.util.List;

public class RotatedSortedArray {

	public static int search(final List<Integer> a, int b) {

		int lo = 0, hi = a.size() - 1;
		int mid = 0;
		while (lo <= hi) {
			mid = lo + (hi - lo) / 2;
			int midV = a.get(mid);
			boolean midInLeft = midV >= a.get(lo);
			if (midV == b) {
				return mid;
			} else if (midInLeft) {
				if (b >= a.get(lo) && b <= midV) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}

			} else {
				if (b <= a.get(hi) && b >= midV) {
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			}

		}
		return -1;
	}

	public static int searchFindDingD(final List<Integer> a, int b) {

		int lo = 0, hi = a.size() - 1;
		int d = 0;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int midV = a.get(mid);
			if (midV >= a.get(0)) {
				lo = mid + 1;
			} else {
				d = mid;
				hi = mid - 1;

			}
		}
		System.out.println(d);
		int ans = binarySearch(0, d - 1, a, b);
		if (ans == -1) {
			ans = binarySearch(d, a.size()-1, a, b);
		}

		return ans;
	}

	private static int binarySearch(int lo, int hi, List<Integer> a, int key) {
		int mid = 0;
		while (lo <= hi) {
			mid = lo + (hi - lo) / 2;
			int midV = a.get(mid);
			if (midV == key) {
				return mid;
			} else if (midV > key) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}

		}

		return -1;
	}

	public static void main(String args[]) {
		Integer arr[] = { 5, 6, 7, 8, 10, 1, 2, 3 };
		System.out.println(search(Arrays.asList(arr), 100));
		System.out.println(search(Arrays.asList(arr), -1));
		System.out.println(search(Arrays.asList(arr), 9));
		System.out.println(search(Arrays.asList(arr), 10));
		System.out.println("/////////////////");
		System.out.println(searchFindDingD(Arrays.asList(arr), 100));
		System.out.println(searchFindDingD(Arrays.asList(arr), -1));
		System.out.println(searchFindDingD(Arrays.asList(arr), 9));
		System.out.println(searchFindDingD(Arrays.asList(arr), 10));
	}
}
