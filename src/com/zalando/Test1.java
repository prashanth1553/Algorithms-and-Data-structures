package com.zalando;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Test1 {

	public static void main(String args[]) {
		Test1 obj = new Test1();
		// System.out.println(obj.solution("8"));
		// System.out.println(obj.solution("ccaaffddecee"));
		int a = 2 * 1000000000;
		System.out.println(a);
		int[] A = { 5, 2, 4, 6, 3, 7 };
		System.out.println(obj.solution(A));

		Optional.ofNullable("").map(String::toString);

	}

	public int solution(int[] A) {
		int ans = Integer.MAX_VALUE;
		int length = A.length;
		int[] rightMin = new int[length];
		rightMin[length - 1] = length - 1;
		for (int i = length - 2; i >= 0; i--) {
			if (A[i] < A[rightMin[i + 1]]) {
				rightMin[i] = i;
			} else {
				rightMin[i] = i + 1;
			}
		}
		int leftMin = 0;
		for (int i = 1; i < length - 1; i++) {
			ans = Math.min(ans, A[leftMin] + A[rightMin[i + 1]]);
			if (A[i] < A[leftMin]) {
				leftMin = i;
			}
		}

		return ans;

	}

	public int solution2(String S) {
		int countOfEachCharacter[] = new int[26];
		for (char c : S.toCharArray()) {
			countOfEachCharacter[c - 'a']++;
		}
		int removalCount = 0;
		Set<Integer> countConsidered = new HashSet<>(S.length());
		for (int i : countOfEachCharacter) {
			if (i != 0) {
				if (countConsidered.contains(i)) {
					int numberOfReduced = 0;
					while (i > 0) {
						i--;
						numberOfReduced++;
						if (i != 0) {
							if (!countConsidered.contains(i)) {
								countConsidered.add(i);
								removalCount += numberOfReduced;
								break;
							}
						} else {
							removalCount += numberOfReduced;
						}
					}

				} else {
					countConsidered.add(i);
				}
			}

		}

		return removalCount;
	}

	public int solution1(String S) {
		if (S.length() <= 2) {
			return Integer.parseInt(S);
		}
		int ans = Integer.MIN_VALUE;
		int previousDigit = Character.getNumericValue(S.charAt(0));
		for (int i = 1; i < S.length(); i++) {
			int currentDigit = Character.getNumericValue(S.charAt(i));
			ans = Math.max(ans, 10 * previousDigit + currentDigit);
			previousDigit = currentDigit;
		}

		return ans;
	}
}
