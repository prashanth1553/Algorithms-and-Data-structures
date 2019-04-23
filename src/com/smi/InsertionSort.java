package com.smi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InsertionSort {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int testCases = Integer.parseInt(scanner.nextLine().trim());
		for (int t = 0; t < testCases; t++) {
			int N = Integer.parseInt(scanner.nextLine().trim());
			String row[] = scanner.nextLine().split(" ");
			int numbers[] = new int[N];
			for (int r = 0; r < N; r++) {
				numbers[r] = Integer.parseInt(row[r]);
			}

			String result = "";
			for (int i = 1; i < N; i++) {
				int iThIndex = i;
				for (int j = i; j > 0; j--) {
					if (numbers[j] < numbers[j - 1]) {
						swap(numbers, j, j - 1);
							iThIndex = j - 1;

					} else {
						break;
					}

				}
				result += iThIndex + " ";
			}
			System.out.println(result.trim());
		}
	}

	public static void swap(int numbers[], int a, int b) {
		int temp = numbers[a];
		numbers[a] = numbers[b];
		numbers[b] = temp;

	}

}
