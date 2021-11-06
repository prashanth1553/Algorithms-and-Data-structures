package com.miscellaneous;

public class AlphabetCombinationCount {

	public static long count(String input, int currentIndex) {
		if (currentIndex >= input.length()) {
			return 1;
		}
		long count = 0l;

		if (input.charAt(currentIndex) == '0') {
			return 0;
		}
		int i = currentIndex;
		count += count(input, i + 1);
		if (i < input.length() - 1 && Integer.parseInt(input.substring(i, i + 2)) <= 26) {
			count += count(input, i + 2);
		}

		return count;
	}

	public static void main(String args[]) {

		System.out.println(count("2101", 0));
		System.out.println(count("2110", 0));
	}

}
