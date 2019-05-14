package com.smi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MaximumCircularSubarraySum {

	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int t = 0; t < testCases; t++) {
			int n = Integer.parseInt(bufferedReader.readLine().trim());
			String arrayS[] = bufferedReader.readLine().trim().split(" ");
			int max = Integer.MIN_VALUE, currentMax = 0;
			int start = 0, currentStart = 0, newStartPositiveStart = -1, end = 0;
			boolean isFirstIteration = true;
			for (int i = 0; i < n; i++) {

				if (i == newStartPositiveStart && !isFirstIteration) {
					break;
				}

				int e = Integer.parseInt(arrayS[i]);
				if (e >= 0 && newStartPositiveStart == -1) {
					newStartPositiveStart = i;
				}
				currentMax += e;
				if (currentMax > max) {
					max = currentMax;
					start = currentStart;
					end = i;
				}
				if (currentMax < 0) {
					if (i + 1 == n || !isFirstIteration) {
						break;
					}
					currentMax = 0;
					currentStart = i + 1;
					newStartPositiveStart = -1;
				} else if (i + 1 == n) {
					if (newStartPositiveStart == 0) {
						break;
					} else {
						i = -1;
						isFirstIteration = false;
					}
				}

			}
			writer.write("" + max);
			writer.newLine();

		}
		writer.flush();
	}
}
