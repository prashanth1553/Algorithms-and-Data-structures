package com.smi;

import java.util.Arrays;
import java.util.Scanner;

public class FindingFrequencyBinarySearch {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int size = Integer.parseInt(scanner.nextLine().trim());
		String items[] = scanner.nextLine().trim().split(" ");
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = Integer.parseInt(items[i]);
		}
		Arrays.sort(array);
		int testCases = Integer.parseInt(scanner.nextLine().trim());
		for (int t = 0; t < testCases; t++) {
			int key = Integer.parseInt(scanner.nextLine().trim());
			int p1 = binarySearLeft(array, key, 0, size - 1);
			if (p1 == -1) {
				System.out.println(0);
				continue;
			}
			int p2 = binarySearRight(array, key, p1 + 1, size - 1);
			if (p2 == -1) {
				System.out.println(1);
			} else {
				System.out.println((p2 - p1 + 1));
			}

		}
	}

	public static int binarySearLeft(int[] array, int key, int lo, int hi) {
		int mid = 0;
		int index = -1;
		while (lo <= hi) {
			mid = lo + (hi - lo) / 2;
			int mValue = array[mid];
			if (mValue == key) {
				index = mid;
				hi = mid - 1;
			} else if (mValue > key) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}

		}
		return index;
	}

	public static int binarySearRight(int[] array, int key, int lo, int hi) {
		int mid = 0;
		int index = -1;
		while (lo <= hi) {
			mid = lo + (hi - lo) / 2;
			int mValue = array[mid];
			if (mValue == key) {
				index = mid;
				lo = mid + 1;
			} else if (mValue > key) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}

		}
		return index;
	}
}
