package com.sorting;

public class ThreeWayQuickSort {

	public void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
	}

	private void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		partition(a, lo, hi);
	}

	private void partition(Comparable[] a, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		int i = lo;
		int lt = 0, gt = hi;
		Comparable v = a[lo];
		while (i <= gt) {
			int d = v.compareTo(a[i]);
			if (d > 0) {
				exchange(a, lo, i);
				++i;
				++lt;
			} else if (d < 0) {
				exchange(a, gt, i);
				--gt;
			} else {
				i++;
			}
		}
		partition(a, lo, lt - 1);
		partition(a, gt + 1, hi);
	}

	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public static void exchange(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
