package com.smi;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfPairs {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int testCases = Integer.parseInt(scanner.nextLine().trim());
		for (int t = 0; t < testCases; t++) {
			String[] rect1 = scanner.nextLine().trim().split(" ");
			int N = Integer.parseInt(rect1[0]);
			int k = Integer.parseInt(rect1[1]);
			String row[] = scanner.nextLine().split(" ");
			int numbers[] = new int[N];
			for (int r = 0; r < N; r++) {
				numbers[r] = Integer.parseInt(row[r]);
			}
			Arrays.sort(numbers);
			int p1 = 0, p2 = N - 1;
			boolean isFound = false;
			while (p1 < p2) {
				long sum = numbers[p1] + numbers[p2];
				if (sum == k) {
					isFound = true;
					break;
				} else if (sum > k) {
					p2--;
				} else {
					p1++;
				}
			}
			if (isFound) {
				System.out.println("True");
			} else {
				System.out.println("False");
			}
		}

	}

}
