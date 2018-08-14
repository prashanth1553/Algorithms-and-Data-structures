package com.strings;

public class MSDStringSort {

	int R = 256;

	public void sort(String[] a, String[] aux, int lo, int hi, int d) {

		if (hi <= lo) {
			return;
		}
		int count[] = new int[R + 2];
		for (int i = lo; i <= hi; i++) {
			count[charAt(a[i], d) + 2]++;
		}
		for (int r = 0; r < R + 1; r++) {
			count[r + 1] += count[r];
		}
		for (int i = lo; i <= hi; i++) {
			aux[count[charAt(a[i], d) + 1]++] = a[i];
		}
		for (int i = lo; i <= hi; i++) {
			a[i] = aux[i - lo];
		}

		for (int r = 0; r < R + 1; r++) {
			sort(a, aux, lo + count[r], lo + count[r + 1] - 1, d + 1);
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
