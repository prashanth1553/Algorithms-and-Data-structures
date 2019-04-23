package com.smi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RoboticExhibition {

	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int t = 0; t < testCases; t++) {
			int n = Integer.parseInt(bufferedReader.readLine().trim());
			String arrayS[] = bufferedReader.readLine().trim().split(" ");
			int robots[] = new int[n];
			int sum = 0;
			for (int i = 0; i < n; i++) {
				robots[i] = Integer.parseInt(arrayS[i]);
				sum += robots[i];
			}
			Arrays.sort(robots);
			int lo = robots[0] + 1, hi = sum + 1;
			for (int i = lo; i <= hi; i++) {
				if (!isValid(robots, i, n)) {
					System.out.println(i);
					break;
				}
			}

		}
	}

	private static boolean isValid(int robots[], int key, int n) {
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += robots[j];
				if (sum == key) {
					return true;
				} else if (sum > key) {
					break;
				}
			}
		}

		return false;
	}
}
