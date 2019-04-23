package com.smi;

import java.util.Scanner;

public class PatternRepresentation {

	private static String adp(String input, int currentIndex, String currentPattern) {
		if (input.length() + 1 == currentPattern.length()) {
			return currentPattern;
		}
		if (currentIndex == 0) {
			if (input.charAt(currentIndex) == 'S') {
				for (int i = 1; i <= 9; i++) {

					for (int j = i + 1; j <= 9; j++) {
						currentPattern = currentPattern + i + j;
						String result = adp(input, currentIndex + 1, currentPattern);
						if (input.length() + 1 == result.length()) {
							return result;
						} else {
							currentPattern = "";
						}
					}
				}

			} else {
				for (int i = 2; i <= 9; i++) {

					for (int j = i - 1; j >= 1; j--) {
						currentPattern = currentPattern + i + j;
						String result = adp(input, currentIndex + 1, currentPattern);
						if (input.length() + 1 == result.length()) {
							return result;
						} else {
							currentPattern = "";
						}
					}
				}
			}

		} else {
			char c = input.charAt(currentIndex);
			int currentNumber = Integer.parseInt("" + currentPattern.charAt(currentPattern.length() - 1));
			if (c == 'S') {
				if (possibleForA(currentPattern, currentNumber) == -1) {
					return currentPattern;
				}
				for (int i = currentNumber; i <= 9; i++) {
					currentNumber = possibleForA(currentPattern, currentNumber);
					if (currentNumber != -1) {
						currentPattern += currentNumber;
						String result = adp(input, currentIndex + 1, currentPattern);
						if (input.length() + 1 == result.length()) {
							return result;
						} else {
							currentPattern = currentPattern.substring(0, currentPattern.length() - 1);
						}
					}
				}

			} else {

				if (possibleForD(currentPattern, currentNumber) == -1) {
					return currentPattern;
				}
				for (int i = currentNumber; i <= 9; i++) {
					currentNumber = possibleForD(currentPattern, currentNumber);
					if (currentNumber != -1) {
						currentPattern += currentNumber;
						String result = adp(input, currentIndex + 1, currentPattern);
						if (input.length() + 1 == result.length()) {
							return result;
						} else {
							currentPattern = currentPattern.substring(0, currentPattern.length() - 1);
						}
					}
				}
			}
		}

		return "";
	}

	private static int possibleForA(String input, int current) {
		for (int j = current + 1; j <= 9; j++) {
			if (!input.contains("" + j)) {
				return j;
			}
		}
		return -1;
	}

	private static int possibleForD(String input, int current) {
		for (int j = current - 1; j >= 1; j--) {
			if (!input.contains("" + j)) {
				return j;
			}
		}
		return -1;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int testCases = Integer.parseInt(scanner.nextLine().trim());
		for (int t = 0; t < testCases; t++) {
			String input = scanner.nextLine().trim();
			System.out.println(adp(input, 0, ""));
		}
	}
}
