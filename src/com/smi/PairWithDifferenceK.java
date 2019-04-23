package com.smi;

import java.util.Arrays;
import java.util.Scanner;

public class PairWithDifferenceK {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int testCases = Integer.parseInt(scanner.nextLine().trim());
		for (int t = 0; t < testCases; t++) {
			String[] sizeAndArray = scanner.nextLine().trim().split(" ");
			int size = Integer.parseInt(sizeAndArray[0]);
			int key = Integer.parseInt(sizeAndArray[1]);
			String row[] = scanner.nextLine().split(" ");
			int numbers[] = new int[size];
			for (int r = 0; r < size; r++) {
				numbers[r] = Integer.parseInt(row[r]);
			}
			Arrays.sort(numbers);
			int p1 = 0, p2 = size - 1;
			while (p1 < p2) {
				
				
			}

		}
	}
}
