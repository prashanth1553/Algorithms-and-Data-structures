package com.strings;

public class BoyerMooreSubString {

	private final int R = 256;
	private int[] chars;

	public int subString(String main, String pattern) {
		int N = main.length(), M = pattern.length();

		chars = new int[R];
		for (int i = 0; i < R; i++)
			chars[i] = -1;

		for (int i = 0; i < M; i++)
			chars[pattern.charAt(i)] = i;

		int skip;
		for (int i = 0; i <= N - M; i += skip) {

			skip = 0;

			for (int j = M - 1; j >= 0; j--) {

				if (pattern.charAt(j) != main.charAt(i + j)) {

					skip = Math.max(1, j - chars[main.charAt(i + j)]);
					break;
				}

			}

			if (skip == 0) {
				return i;
			}
		}

		return N;
	}

	public static void main(String args[]) {

		String main = "abacadabrabc";
		String pattern = "abc";
		BoyerMooreSubString obj = new BoyerMooreSubString();
		System.out.println(obj.subString(main, pattern));

	}
}
