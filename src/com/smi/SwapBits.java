package com.smi;

import java.util.Scanner;

public class SwapBits {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int testCases = Integer.parseInt(scanner.nextLine().trim());
		for (int t = 0; t < testCases; t++) {
			int number = Integer.parseInt(scanner.nextLine());
			int result = number;
			int i = 0;
			while (number != 0) {
				int bitOne = number & 1;
				int bitTwo = (number >> 1) & 1;
				if (bitOne != bitTwo) {
					int tempR = (1 << i) | (1 << (i + 1));
					result = result ^ tempR;

				}
				i += 2;
				number = number >> 2;
			}
			System.out.println(result);

		}

	}
}
