package com.smi;

import java.util.Scanner;

public class FindingMissingNumber {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = Integer.parseInt(scanner.nextLine().trim());
		for (int i = 0; i < t; i++) {
			int N = Integer.parseInt(scanner.nextLine().trim());
			String[] arItems = scanner.nextLine().split(" ");
			long sum = 0;
			for (String it : arItems) {
				sum += Integer.parseInt(it);
			}
			N++;
			long actualSum = (N * (N + 1)) / 2;
			System.out.println(actualSum - sum);
		}
	}
}
