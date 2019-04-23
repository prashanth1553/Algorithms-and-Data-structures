package com.smi;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Interleavings {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String args[]) {

		int testCases = Integer.parseInt(scanner.nextLine().trim());
		for (int t = 0; t < testCases; t++) {
			String row[] = scanner.nextLine().split(" ");
			String a = row[0];
			String b = row[1];
			System.out.println("Case #" + (t + 1) + ":");
			interleavings(a, b, a.length() + b.length(), "", 0, 0);

		}

	}

	public static void interleavings(String a, String b, int totalL, String result, int aIndex, int bIndex) {

		if (totalL == result.length()) {
			System.out.println(result);
			return;
		}

		if (bIndex < b.length() && aIndex < a.length()) {
			if (b.charAt(bIndex) < a.charAt(aIndex)) {
				interleavings(a, b, totalL, result + b.charAt(bIndex), aIndex, bIndex + 1);
				interleavings(a, b, totalL, result + a.charAt(aIndex), aIndex + 1, bIndex);
			} else {
				interleavings(a, b, totalL, result + a.charAt(aIndex), aIndex + 1, bIndex);
				interleavings(a, b, totalL, result + b.charAt(bIndex), aIndex, bIndex + 1);
			}

		} else if (bIndex < b.length()) {
			interleavings(a, b, totalL, result + b.charAt(bIndex), aIndex, bIndex + 1);
		} else if (aIndex < a.length()) {
			interleavings(a, b, totalL, result + a.charAt(aIndex), aIndex + 1, bIndex);
		}

	}
}
