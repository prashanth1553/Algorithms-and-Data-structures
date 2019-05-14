package com.smi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxSubarraySum {

	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int t = 0; t < testCases; t++) {
			int n = Integer.parseInt(bufferedReader.readLine().trim());
			String arrayS[] = bufferedReader.readLine().trim().split(" ");
			int max = Integer.MIN_VALUE, currentMax = 0;
			int start = 0, end = 0, currentStart = 0;
			for (int i = 0; i < n; i++) {
				int e = Integer.parseInt(arrayS[i]);
				currentMax += e;
				if (currentMax > max) {
					max = currentMax;
					start = currentStart;
					end = i;
				}
				if (currentMax < 0) {
					currentStart = i + 1;
					currentMax = 0;
				}

			}
			System.out.println(max + " " + start + " " + end);

		}
	}

}
