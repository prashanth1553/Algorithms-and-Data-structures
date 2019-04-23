package com.smi;

import java.util.Scanner;

public class SmallerElements {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String args[]) {
		int testCases = Integer.parseInt(scanner.nextLine().trim());
		for (int t = 0; t < testCases; t++) {
			int size = Integer.parseInt(scanner.nextLine().trim());
			String items[] = scanner.nextLine().trim().split(" ");
			int[] array = new int[size];
			for (int i = 0; i < size; i++) {
				array[i] = Integer.parseInt(items[i]);
			}
			int[] aux = new int[size];
			System.out.println(sort(array, aux, 0, size - 1));
		}
	}

	private static int sort(int[] array, int[] aux, int lo, int hi) {
		if (lo >= hi) {
			return 0;
		}
		int mid = lo + (hi - lo) / 2;
		int count = 0;
		count += sort(array, aux, lo, mid);
		count += sort(array, aux, mid + 1, hi);
		count += merge(array, aux, lo, hi, mid);
		return count;
	}

	private static int merge(int[] array, int[] aux, int lo, int hi, int mid) {
		for (int k = lo; k <= hi; k++) {
			aux[k] = array[k];
		}
		int count = 0;
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				array[k] = aux[j++];
			} else if (j > hi) {
				array[k] = aux[i++];
				count += (hi - mid);
			} else if (aux[i] > aux[j]) {
				count += 1;
				array[k] = aux[j++];
			} else {
				array[k] = aux[i++];
			}

		}
		return count;
	}
}
