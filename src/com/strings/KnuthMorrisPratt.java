package com.strings;

public class KnuthMorrisPratt {

	private int dfs[][];
	private final int R = 256;

	public int subString(String main, String pattern) {
		int N = main.length(), M = pattern.length();

		dfs = new int[R][M];
		dfs[pattern.charAt(0)][0] = 1;
		for (int i = 1, X = 0; i < M; i++) {

			for (int c = 0; c < R; c++)
				dfs[c][i] = dfs[c][X];
			dfs[pattern.charAt(i)][i] = i + 1;
			X = dfs[pattern.charAt(i)][X];
		}

		int i = 0, j = 0;
		for (; i < N && j < M; i++) {

			j = dfs[main.charAt(i)][j];
		}
		if (j == M) {
			return i - M;
		} else {
			return N;
		}
	}

	public static void main(String args[]) {

		String main = "abacadabrabc";
		String pattern = "abc";
		KnuthMorrisPratt obj = new KnuthMorrisPratt();
		System.out.println(obj.subString(main, pattern));

	}
}
