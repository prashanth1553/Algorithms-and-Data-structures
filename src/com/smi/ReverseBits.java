package com.smi;

import java.util.Scanner;

public class ReverseBits {

	private static final Scanner scanner = new Scanner(System.in);
	public static final int mod = 1000000007;

	public static void main(String[] args) {
		int testCases = Integer.parseInt(scanner.nextLine().trim());
		for (int t = 0; t < testCases; t++) {
			long number = Long.parseLong(scanner.nextLine());
			long revers = 0;
			int i = 0;
			while (number != 0) {
				if ((number & 1) != 0) {
					revers = (revers | ((1l) << (31 - i)));
				}
				number = number >> 1;
				i++;
			}
			System.out.println(revers);
		}
	}
}
