package com.smi;

import java.util.HashMap;
import java.util.Scanner;

public class EnclosingSubstring {

	private static final Scanner scaner = new Scanner(System.in);

	public static void main(String agrs[]) {
		int testCases = Integer.parseInt(scaner.nextLine().trim());
		for (int t = 0; t < testCases; t++) {
			String[] input = scaner.nextLine().trim().split(" ");
			String pattern = input[0];
			String string = input[1];
			HashMap<Integer, Integer> patternFrequency = new HashMap<>();
			updateFrequency(0, pattern.length() - 1, pattern, patternFrequency, 1);
			HashMap<Integer, Integer> stringFrequency = new HashMap<>();
			int p1 = 0, p2 = pattern.length() - 1;
			updateFrequency(p1, p2, string, stringFrequency, 1);
			if (isMatched(patternFrequency, stringFrequency)) {
				System.out.println(pattern.length());
				continue;
			}
			p2++;
			updateFrequency(p2, p2, string, stringFrequency, 1);
			int ans = Integer.MAX_VALUE;
			while ((p1 + pattern.length() - 1) <= p2 && p2 < string.length()) {
				if (isMatched(patternFrequency, stringFrequency)) {
					if (p2 - p1 + 1 == pattern.length()) {
						ans = p2 - p1 + 1;
						break;
					}
					ans = Math.min(ans, p2 - p1 + 1);
					// remove
					updateFrequency(p1, p1, string, stringFrequency,-1);
					p1++;
				} else {
					p2++;
					if(p2 < string.length()) {
						updateFrequency(p2, p2, string, stringFrequency, 1);
					}
				}
			}
			ans = ans == Integer.MAX_VALUE ? -1 : ans;
			System.out.println(ans);

		}

	}

	private static boolean isMatched(HashMap<Integer, Integer> patternFrequency,
			HashMap<Integer, Integer> stringFrequency) {
		for (int key : patternFrequency.keySet()) {
			if (!stringFrequency.containsKey(key)) {
				return false;
			}
			if (patternFrequency.get(key) > stringFrequency.get(key)) {
				return false;
			}

		}

		return true;
	}

	private static void updateFrequency(int lo, int hi, String input, HashMap<Integer, Integer> frequency, int count) {
		for (int i = lo; i <= hi; i++) {
			int c = input.charAt(i);
			if (frequency.containsKey(c)) {
				int result = frequency.get(c) + count;
				if(result <= 0) {
					frequency.remove(c);
				}else {
					frequency.put(c, result);
				}
			} else {
				frequency.put(c, count);
			}
		}

	}
}
