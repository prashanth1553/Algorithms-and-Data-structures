package com.smi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NumberOfValidSubarrays {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int testCases = Integer.parseInt(scanner.nextLine().trim());
		for (int t = 0; t < testCases; t++) {
			int N = Integer.parseInt(scanner.nextLine().trim());
			String row[] = scanner.nextLine().split(" ");
			int numbers[] = new int[N];
			numbers[0] = Integer.parseInt(row[0]) == 0 ? -1 : 1;
			for (int r = 1; r < N; r++) {
				int element = Integer.parseInt(row[r]);
				numbers[r] = element == 0 ? -1 : element;
				numbers[r] = numbers[r] + numbers[r - 1];
			}
			Map<Integer, Integer> counts = new HashMap<>();
			int count = 0;
			for (int i : numbers) {
				if (numbers[i] == 0)
					count++;
				if (counts.containsKey(i)) {
					count += counts.get(i);
					counts.put(i, counts.get(i) + 1);
				} else {
					counts.put(i, 1);
				}

			}
			System.out.println(count);
		}
	}

	public static void updateCount(Map<Integer, Integer> counts, int key, int count) {
		int v = counts.get(key);
		counts.put(key, v + count);

	}
}
