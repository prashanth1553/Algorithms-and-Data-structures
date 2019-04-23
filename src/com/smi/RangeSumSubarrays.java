package com.smi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RangeSumSubarrays {

	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int t = 0; t < testCases; t++) {
			String strH[] = bufferedReader.readLine().trim().split(" ");
			int n = Integer.parseInt(strH[0]);
			int a = Integer.parseInt(strH[1]);
			int b = Integer.parseInt(strH[2]);
			String arrayS[] = bufferedReader.readLine().trim().split(" ");
			int array[] = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = Integer.parseInt(arrayS[i]);
			}
			int count = 0;
			for (int i = 0; i < n; i++) {
				int sum = 0;
				for (int j = i; j < n; j++) {
					sum += array[j];
					if (sum >= a && sum <= b) {
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
}
