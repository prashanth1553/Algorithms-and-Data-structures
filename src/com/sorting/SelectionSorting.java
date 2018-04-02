package com.sorting;

import com.models.Cat;

@SuppressWarnings("rawtypes")
public class SelectionSorting {

	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i + 1; j < N; j++) {
				if (less(a[j], a[min])) {
					min = j;
				}
			}
			exchange(a, i, min);
		}

	}

	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public static void exchange(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void main(String args[]) {

		Cat c1 = new Cat("a");
		Cat c2 = new Cat("d");
		Cat c3 = new Cat("b");
		Cat c4 = new Cat("e");
		Cat[] array = new Cat[] { c1, c2, c3, c4 };
		SelectionSorting.sort(array);
		for (Cat c : array)
			System.out.println(c.getColor());
	}
}
