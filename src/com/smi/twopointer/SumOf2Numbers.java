package com.smi.twopointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*Given an array, check if there exists 2 elements of the array such that their sum is equal to the sum of the remaining elements of the array.*/
public class SumOf2Numbers {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int t = Integer.parseInt(scanner.nextLine().trim());
		for (int i = 0; i < t; i++) {
			final int n = Integer.parseInt(scanner.nextLine().trim());
			int[] arr = new int[n];
			int c = 0;
			long sum = 0l;
			for (String s : scanner.nextLine().trim().split(" ")) {
				arr[c] = Integer.parseInt(s);
				sum += arr[c];
				c++;
			}
			if (isSumOfTwoNumbers(sum, arr)) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}

	}

	public static boolean isSumOfTwoNumbers(long sum, int[] input) {
		if (sum % 2 != 0) {
			return false;
		}
		Arrays.sort(input);
		int p1 = 0, p2 = input.length - 1;
		while (p1 < p2) {
			long cSum = input[p1] + input[p2];
			long deductedSum = sum - cSum;
			if (cSum == deductedSum) {
				return true;
			} else if (cSum > deductedSum) {
				p2--;
			} else {
				p1++;
			}
		}
		return false;
	}

	public static boolean isSumOfTwoNumbersBruteForce(long sum, int[] input) {
		if (sum % 2 != 0) {
			return false;
		}
		for (int i = 0; i < input.length; i++) {
			for (int j = i + 1; j < input.length; j++) {
				long cSum = input[i] + input[j];
				long deductedSum = sum - cSum;
				if (cSum == deductedSum) {
					return true;
				}
			}
		}

		return false;
	}

	/*
	 * with hashing
	 */
	public static boolean isSumOfTwoNumbersHashing(long sum, int[] input) {
		if (sum % 2 != 0) {
			return false;
		}
		long halfS = sum / 2;
		Set<Integer> processElements = new HashSet<>();
		for (int i = 0; i < input.length; i++) {
			if (processElements.contains((int) (halfS - input[i]))) {
				return true;
			}
			processElements.add(input[i]);

		}

		return false;
	}
}
