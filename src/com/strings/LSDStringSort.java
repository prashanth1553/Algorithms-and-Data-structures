package com.strings;

public class LSDStringSort {

	public static void sort(String[] a, int w) {

		int R = 256;
		int N = a.length;
		String[] aux = new String[N];
		
		for (int ch = w - 1; ch >= 0; ch--) {

			int[] count = new int[R + 1];
			for (int j = 0; j < N; j++) {
				count[a[j].charAt(ch) + 1]++;
			}
			for (int j = 0; j < R; j++) {
				count[j + 1] += count[j];
			}
			for (int j = 0; j < N; j++) {
				int p = count[a[j].charAt(ch)]++;
				aux[p] = a[j];
			}
			for (int j = 0; j < a.length; j++) {
				a[j] = aux[j];
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
