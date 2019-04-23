package com.smi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindingFrequencySort {

	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int size = Integer.parseInt(bufferedReader.readLine().trim());
		String items[] = bufferedReader.readLine().trim().split(" ");
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = Integer.parseInt(items[i]);
		}
		Arrays.sort(array);
		final int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		int[] queries = new int[testCases];
		int[] queriesSorted = new int[testCases];
		for (int t = 0; t < testCases; t++) {
			int key = Integer.parseInt(bufferedReader.readLine().trim());
			queries[t] = key;
			queriesSorted[t] = key;

		}
		Arrays.sort(queriesSorted);
		int[] eachCount = new int[testCases];
		int p1 = 0, p2 = 0;
		while (p1 < size && p2 < testCases) {
            if (array[p1] == queriesSorted[p2]) {
                eachCount[p2]++;
                p1++;
            } else if (array[p1] > queriesSorted[p2]) {
                int tempP2 = p2+1;
                while (tempP2 < testCases && queriesSorted[p2] == queriesSorted[tempP2]) {
                    eachCount[tempP2++] = eachCount[p2];
                }
                p2 = tempP2;
            } else {
                p1++;
            }
        }
		
		for (int i = 0; i < testCases; i++) {
			int index = binarySearch(queriesSorted, 0, testCases - 1, queries[i]);
			if (index == -1) {
				System.out.println(0);
			} else {
				System.out.println(eachCount[index]);
			}

		}

	}

	public static int binarySearch(int[] array, int lo, int hi, int key) {
		int mid = 0;
		while (lo <= hi) {
			mid = lo + (hi - lo) / 2;
			int midV = array[mid];
			if (midV == key) {
				return mid;
			} else if (midV > key) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return -1;

	}

}
