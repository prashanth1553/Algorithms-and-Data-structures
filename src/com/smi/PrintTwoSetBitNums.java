package com.smi;

import java.util.Scanner;

public class PrintTwoSetBitNums {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int testCases = Integer.parseInt(scanner.nextLine().trim());
		for (int t = 0; t < testCases; t++) {
			long input = Long.parseLong(scanner.nextLine());
			long numberOfBits = findN(input);
			long count = naturalSum(numberOfBits - 1);
			long x = numberOfBits >= 30 ? 30 : numberOfBits;
			long result = 0;
			int y = 0;
			while (y < x && count < input && y < 30) {
				result = (1 << x) | (1 << y);
				y++;
				count++;
				result = result % 1000000007;
			}
			System.out.println(result);

		}

	}

	public static long findN(long sum) {
		long l = 1, h = (sum / 2) + 1;
		long mid = 0;
		while (l <= h) {
			mid = l + (h - l) / 2;
			long s = naturalSum(mid);
			if (s == sum) {
				return mid;
			} else if (s > sum) {
				h = mid - 1;
			} else {
				l = mid + 1;
			}

		}
		return l;
	}

	public static long naturalSum(long n) {

		return (n * (n + 1)) / 2;
	}
}
