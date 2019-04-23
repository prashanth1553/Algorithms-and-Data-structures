package com.smi;

import java.util.Scanner;

public class ComputePower {

	private static final Scanner scanner = new Scanner(System.in);
	public static final int mod = 1000000007;

	public static void main(String[] args) {
		int testCases = Integer.parseInt(scanner.nextLine().trim());
		for (int t = 0; t < testCases; t++) {
			String[] arItems = scanner.nextLine().split(" ");
			long a = Long.parseLong(arItems[0]);
			long b = Long.parseLong(arItems[1]);

			if (a == 0) {
				System.out.println(0);
			} else {
				System.out.println(pow(a, b));
			}
		}
	}

	public static long pow(long a, long b) {
		if (b == 1) {
			return a;
		}
		if (b == 0) {
			return 1;
		}
		long halfPower = (pow(a, b / 2) % mod);
		long fullPower = (halfPower * halfPower) % mod;

		if (b % 2 != 0) {
			fullPower = (fullPower * a) % mod;
		}
		return fullPower;
	}
}
