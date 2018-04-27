package com.strings;

public class SubStringSearchBruteForce {

	public static int subString2(String main, String pattern) {
		int N = main.length(), M = pattern.length();
		int i, j;
		for (i = 0, j = 0; i < N && j < M; i++) {

			if (main.charAt(i) == pattern.charAt(j)) {
				j++;
			} else {
				i -= j;
				j = 0;

			}
		}
		if (j == M) {
			return i - M;
		}
		return N;

	}

	public static int subString1(String main, String pattern) {

		int N = main.length(), M = pattern.length();
		for (int i = 0; i <= N - M; i++) {

			int j;
			for (j = 0; j < M; j++) {
				if (main.charAt(i + j) != pattern.charAt(j)) {
					break;
				}
			}
			if (j == M) {
				return i;
			}
		}

		return N;
	}

	public static int subString(String main, String pattern) {
		int l1 = main.length(), l2 = pattern.length();
		int j = 0;
		for (int i = 0; i < l2; i++) {
			if (i >= l1) {
				break;
			}
			if (main.charAt(j + i) == pattern.charAt(i)) {
				if (i + 1 == pattern.length()) {
					return j;
				}
			} else {
				++j;
				i = -1;
			}

		}
		return l1;

	}

	public static void main(String args[]) {

		String main = "abacadabrabc";
		String pattern = "abc";
		System.out.println(subString2(main, pattern));

	}

}
