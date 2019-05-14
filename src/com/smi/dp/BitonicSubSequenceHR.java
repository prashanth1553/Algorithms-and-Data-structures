package com.smi.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BitonicSubSequenceHR {

	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int t = 0; t < testCases; t++) {
			int size = Integer.parseInt(bufferedReader.readLine().trim());
			String items[] = bufferedReader.readLine().trim().split(" ");
			int[] array = new int[size];
			for (int i = 0; i < size; i++) {
				array[i] = Integer.parseInt(items[i]);
			}
			int[] increasingrank = new int[size];
			int[] decreasingRank = new int[size];

			int[] increasingSubSequence = new int[size];
			int[] decreasingSubSequence = new int[size];

			// increasing part
			increasingSubSequence[0] = array[0];
			increasingrank[0] = 1;
			for (int i = 1; i < size; i++) {
				int e = array[i];
				increasingrank[i] = 1;
				for (int j = i - 1; j >= 0; j--) {
					if (e >= array[j]) {
						increasingrank[i] = Math.max(increasingrank[i], increasingrank[j] + 1);
					}
				}

			}
			// decreasing part
			int[] reverse = new int[size];
			for (int i = size - 1; i >= 0; i--) {
				reverse[size - 1 - i] = array[i];
			}

			decreasingSubSequence[0] = reverse[0];
			decreasingRank[0] = 1;
			for (int i = 1; i < size; i++) {
				int e = reverse[i];
				decreasingRank[i] = 1;
				for (int j = i - 1; j >= 0; j--) {
					if (e >= reverse[j]) {
						decreasingRank[i] = Math.max(decreasingRank[i], decreasingRank[j] + 1);
					}
				}
					
			}
			int ans = Integer.MIN_VALUE;
			int answerIn = 0;
			revereseArr(decreasingRank);
			for (int i = 0; i < size; i++) {
				if (ans < (increasingrank[i] + decreasingRank[i] - 1))
					ans = (decreasingRank[i] + increasingrank[i] - 1);

			}
			writer.write("" + ans);
			writer.newLine();
		}
		writer.flush();
	}

	private static int getCeil(int array[], int lo, int length, int key) {
		int hi = length - 1;
		int ceil = 0;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int e = array[mid];
			if (e == key) {
				return mid;
			} else if (e > key) {
				ceil = mid;
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}

		}
		return ceil;
	}

	static void revereseArr(int arr[]) {
		int i = 0;
		int j = arr.length - 1;
		while (i < j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}

}
