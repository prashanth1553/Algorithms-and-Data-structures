package com.smi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DistinctElementsInWindow {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int testCases = Integer.parseInt(scanner.nextLine().trim());
		for (int t = 0; t < testCases; t++) {
			String numberAndWindow[] = scanner.nextLine().split(" ");
			int N = Integer.parseInt(numberAndWindow[0]);
			int K = Integer.parseInt(numberAndWindow[1]);
			String row[] = scanner.nextLine().split(" ");
			int numbers[] = new int[N];
			for (int r = 0; r < N; r++) {
				numbers[r] = Integer.parseInt(row[r]);
			}

			Map<Integer, Integer> counter = new HashMap<>();
			for (int j = 0; j < K; j++) {
				updateCounter(counter, numbers[j], 1);
			}
			String result = "";
			result += counter.size() + " ";
			for (int i = 1; i <= N - K; i++) {
				updateCounter(counter, numbers[i - 1], -1);
				updateCounter(counter, numbers[i + K - 1], 1);
				result += counter.size() + " ";
			}
			System.out.println(result.trim());

		}
	}

	private static void updateCounter(Map<Integer, Integer> counter, int key, int q) {
		if (!counter.containsKey(key)) {
			counter.put(key, 0);
		}
		int c = counter.get(key);
		c += q;
		if (c <= 0) {
			counter.remove(key);
		} else {
			counter.put(key, c);
		}

	}
}
