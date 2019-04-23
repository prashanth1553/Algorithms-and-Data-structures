package com.smi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximumContiguousSubsequence {

	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int t = 0; t < testCases; t++) {
			int size = Integer.parseInt(bufferedReader.readLine().trim());
			String items[] = bufferedReader.readLine().trim().split(" ");
			int[] array = new int[size];
			for (int i = 0; i < size; i++) {
				array[i] = Integer.parseInt(items[i]);
			}
			Arrays.sort(array);
			int currentContigousSubsequenceCount = 1;
			int previousContigousSubsequenceCount = 1;
			for (int i = 1; i < size; i++) {
				if (array[i] == array[i - 1] + 1) {
					currentContigousSubsequenceCount++;
				} else {
					if (currentContigousSubsequenceCount > previousContigousSubsequenceCount) {
						previousContigousSubsequenceCount = currentContigousSubsequenceCount;
					}
					currentContigousSubsequenceCount = 1;
				}
			}
			if (currentContigousSubsequenceCount > previousContigousSubsequenceCount) {
				previousContigousSubsequenceCount = currentContigousSubsequenceCount;
			}
			System.out.println(previousContigousSubsequenceCount);
		}
	}
}
