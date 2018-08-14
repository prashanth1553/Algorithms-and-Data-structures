package com.strings;

public class LSDStringSort {

	public static void sort(String[] a, int w) {

		int R = 256;
		int N = a.length;
		String[] aux = new String[N];

		for (int ch = w - 1; ch >= 0; ch--) {

			int[] count = new int[R + 1];

			for (int i = 0; i < a.length; i++) {

				count[a[i].charAt(ch) + 1]++;

			}

			for (int r = 0; r < R; r++) {
				count[r + 1] += count[r];

			}
			for (int i = 0; i < a.length; i++) {

				aux[count[a[i].charAt(ch) ]++] = a[i];
			}

			for (int i = 0; i < a.length; i++) {
				a[i] = aux[i];
			}
		}

	}

	public static void main(String args[]) {
		String[] a = { "cba", "bca", "acb", "abc", "bac", "cab" };
		sort(a, 3);
		int n = a.length;
		for (int i = 0; i < n; i++)
			System.out.println(a[i]);
	}

}
