package com.smi;

import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int testCases = Integer.parseInt(scanner.nextLine().trim());
		for (int t = 0; t < testCases; t++) {
			String[] workersAndJobs = scanner.nextLine().trim().split(" ");
			int numberOfForms = Integer.parseInt(workersAndJobs[0]);
			int numberOfCows = Integer.parseInt(workersAndJobs[1]);
			int[] formLocations = new int[numberOfForms];
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < numberOfForms; i++) {
				int lo = Integer.parseInt(scanner.nextLine().trim());
				formLocations[i] = lo;
				if (lo > max) {
					max = lo;
				}
				if (lo < min) {
					min = lo;
				}
			}
			Arrays.sort(formLocations);
			int lo = 0, hi = max - min, mid = 0;
			int ans = 0;
			while (lo <= hi) {
				mid = lo + (hi - lo) / 2;
				if (isValid(formLocations, mid, numberOfCows)) {
					ans = mid;
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}

			}
			System.out.println(ans);
		}
	}

	private static boolean isValid(int[] formLocations, int distance, int totalCowCount) {

		int currentDistance = 0;
		int placedCowCount = 1;
		int previousPlacedLocation = 0;
		for (int i = 1; i < formLocations.length && placedCowCount <= totalCowCount; i++) {
			currentDistance = Math.abs(formLocations[i] - formLocations[previousPlacedLocation]);
			if (currentDistance >= distance) {
				placedCowCount++;
				previousPlacedLocation = i;
			}
		}
		return placedCowCount >= totalCowCount;
	}
}
