package com.smi;

import java.util.Scanner;

public class LargestPalindromicSubstring {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int testCases = Integer.parseInt(scanner.nextLine().trim());
		for (int t = 0; t < testCases; t++) {
			int N = Integer.parseInt(scanner.nextLine());
			String input = scanner.nextLine().trim();
			System.out.println(Math.max(oddLengthPolindrome(input), evenLengthPolindrome(input)));
		}
	}

	private static int oddLengthPolindrome(String input) {
		int ans = 1;
		for (int i = 1; i < input.length(); i++) {
			int p1 = i - 1, p2 = i + 1;
			while (p1 >= 0 && p2 < input.length()) {
				if (input.charAt(p1) == input.charAt(p2)) {
					ans = Math.max(ans, (p2 - p1 + 1));
					p1--;
					p2++;
				} else {
					break;
				}
			}
		}

		return ans;
	}

	private static int evenLengthPolindrome(String input) {
		int ans = 1;
		for (int i = 1; i < input.length(); i++) {
			if (input.charAt(i) != input.charAt(i - 1)) {
				continue;
			}
			ans = Math.max(ans, 2);
			int p1 = i - 2, p2 = i + 1;
			while (p1 >= 0 && p2 < input.length()) {
				if (input.charAt(p1) == input.charAt(p2)) {
					ans = Math.max(ans, (p2 - p1 + 1));
					p1--;
					p2++;
				} else {
					break;
				}
			}
		}

		return ans;
	}
}
