package com.smi;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {

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

			for (int i = 0; i < N; i++) {
				int swapIndex = i;
				for (int j = i + 1; j < N; j++) {
					if (numbers[j] < numbers[swapIndex]) {
						swapIndex = j;
					}

				}
				swap(numbers, swapIndex, i);
				System.out.println(swapIndex + " ");
			}
			System.out.println(Arrays.toString(numbers));
		}
	}

	public static void swap(int numbers[], int a, int b) {
		int temp = numbers[a];
		numbers[a] = numbers[b];
		numbers[b] = temp;

	}

}
