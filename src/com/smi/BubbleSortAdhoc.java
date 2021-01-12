package com.smi;

import java.util.Scanner;

public class BubbleSortAdhoc {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int testCases = Integer.parseInt(scanner.nextLine().trim());
		for (int t = 0; t < testCases; t++) {
			int N = Integer.parseInt(scanner.nextLine().trim());
			String row[] = scanner.nextLine().split(" ");
			int numbers[] = new int[N];
			for (int r = 0; r < N; r++) {
				numbers[r] = Integer.parseInt(row[r]);
			}
			int swapCount = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - 1 - i; j++) {
					if (numbers[j] > numbers[j + 1]) {
						int temp = numbers[j];
						numbers[j] = numbers[j + 1];
						numbers[j + 1] = temp;
						swapCount++;
					}

				}

			}
			System.out.println(swapCount);
		}

	}
}
