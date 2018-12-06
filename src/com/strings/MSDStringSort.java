package com.strings;

public class MSDStringSort {

	int R = 256;

	private void sort(String a[], String aux[], int lo, int high, int d) {

		if (high <= lo) {
			return;
		}
		int r[] = new int[R + 2];
		for (int i = lo; i <= high; i++) {

			r[charAt(a[i], d) + 2]++;
		}
		for (int i = 0; i < R + 1; i++) {

			r[i + 1] += r[i];
		}
		for (int i = lo; i <= high; i++) {

			aux[r[charAt(a[i], d) + 1]++] = a[i];

		}

		for (int i = lo; i <= high; i++) {
			a[i] = aux[i - lo];
		}

		for (int i = 0; i < R + 1; i++) {

			sort(a, aux, lo + r[i], lo + r[i + 1] - 1, d + 1);
		}

	}

	public void sort(String[] a) {
		String[] aux = new String[a.length];
		sort(a, aux, 0, a.length - 1, 0);

	}

	private int charAt(String s, int d) {
		if (d < s.length()) {
			return s.charAt(d);
		}
		return -1;
	}

	public static void main(String args[]) {
		MSDStringSort obj = new MSDStringSort();
		String[] a = { "d", "bca", "acb", "abc", "bac", "cab", "a", "b", "aa" };
		obj.sort(a);
		int n = a.length;
		for (int i = 0; i < n; i++)
			System.out.println(a[i]);
	}
}
