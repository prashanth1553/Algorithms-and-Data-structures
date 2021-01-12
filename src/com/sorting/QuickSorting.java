package com.sorting;

public class QuickSorting {

	public static int partitionCount = 0;

	public static int partition(Comparable[] a, int lo, int hi) {

		partitionCount++;
		int i = lo, j = hi + 1;

		while (true) {
			while (less(a[++i], a[lo])) {

				if (i == hi) {
					break;
				}
			}

			while (less(a[lo], a[--j])) {

				if (lo == j) {
					break;
				}
			}
			if (i >= j)
				break;
			exchange(a, i, j);

		}
		exchange(a, lo, j);
		return j;
	}

	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public static void exchange(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void sort(Comparable[] a) {

		sort(a, 0, a.length - 1);

	}

	public static void sort(Comparable[] a, int lo, int hi) {

		if (lo >= hi) {
			return;
		}
		int mid = partition(a, lo, hi);
		sort(a, lo, mid - 1);
		sort(a, mid + 1, hi);
	}

}
