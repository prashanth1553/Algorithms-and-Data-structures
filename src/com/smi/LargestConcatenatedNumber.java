package com.smi;

import java.util.Scanner;

public class LargestConcatenatedNumber {

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
			sort(numbers, 0, N-1);
			String result = "";
			for (int i = numbers.length - 1; i >= 0; i--) {
				result += numbers[i];
			}
			System.out.println(result);
		}

	}

	public static void sort(int array[], int lo, int hi) {
		if (lo >= hi) {
			return;
		}

		int i = lo + 1, j = hi;
		int p = lo;
		while (i <= j) {
			if (less(array[i], array[p])) {
				swap(array, i, p);
				i++;
				p++;
			} else if (!less(array[i], array[p])) {
				swap(array, j, i);
				j--;
			} else {
				i++;
			}

		}
		sort(array, lo, p - 1);
		sort(array, j + 1, hi);

	}

	public static boolean less(int aO, int bO) {
		long a = Long.parseLong(aO + "" + bO);
		long b = Long.parseLong(bO + "" + aO);
		return a < b;
	}

	public static void swap(int numbers[], int a, int b) {
		int temp = numbers[a];
		numbers[a] = numbers[b];
		numbers[b] = temp;

	}

}
