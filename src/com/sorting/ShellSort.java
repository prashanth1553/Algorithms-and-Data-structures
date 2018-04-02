package com.sorting;

import com.models.Cat;

public class ShellSort {

	public static void sort(Comparable[] a) {
		int N = a.length;
		int h = 1;
		while (h < N / 3) {
			h = 3 * h + 1;
		}

		while (h >= 1) {
			for (int i = h; i < N; i++) {
				for (int j = i; j > h; j -= h) {
					if (less(a[j], a[j - h])) {
						exchange(a, j, j - h);
					} else {
						break;
					}
				}
			}
			h = h / 3;
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
		Cat c5 = new Cat("z");
		Cat c7 = new Cat("y");
		Cat c6 = new Cat("x");
		Cat[] array = new Cat[] { c1, c2, c3, c4, c5, c6, c7 };
		sort(array);
		for (Cat c : array)
			System.out.println(c.getColor());
	}
}
