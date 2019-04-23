package com.smi;

import java.util.Arrays;
import java.util.Scanner;

public class SubsetsOfArray {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String args[]) {
		int testCases = Integer.parseInt(scanner.nextLine().trim());
		for (int t = 0; t < testCases; t++) {

			int n = Integer.parseInt(scanner.nextLine().trim());
			String strArray[] = scanner.nextLine().split(" ");
			int items[] = new int[n];
			for (int i = 0; i < n; i++) {
				items[i] = Integer.parseInt(strArray[i]);
			}
			Arrays.sort(items);
			subSets(items, -1, "");
			System.out.println();
		}

	}

	public static void subSets(int items[], int index, String subSet) {
		if(!subSet.isEmpty()) {
			System.out.println(subSet.trim());
		}
		for (int i = index + 1; i < items.length; i++) {
			subSet += " " + items[i];
			subSets(items, i, subSet);
			subSet = subSet.substring(0, subSet.length() - 2);
		}

	}

}
