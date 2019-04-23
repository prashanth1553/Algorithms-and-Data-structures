package com.smi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;

public class FarewellParty {

	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String args[]) throws NumberFormatException, IOException {
		int testCases = Integer.parseInt(reader.readLine().trim());
		for (int t = 0; t < testCases; t++) {
			int numberOfSlots = Integer.parseInt(reader.readLine().trim());
			int startA[] = new int[numberOfSlots];
			int endA[] = new int[numberOfSlots];
			for (int i = 0; i < numberOfSlots; i++) {
				String slots[] = reader.readLine().trim().split(" ");
				int start = Integer.parseInt(slots[0]);
				startA[i] = start;
				int end = Integer.parseInt(slots[1]);
				endA[i] = end;
			}
			int finalResult = 0, current = 0;
			Arrays.sort(startA);
			Arrays.sort(endA);
			int i = 0, j = 0;
			while (i < numberOfSlots && j < numberOfSlots) {
				if (startA[i] <= endA[j]) {
					current++;
					finalResult = Math.max(finalResult, current);
					i++;
				} else {
					current--;
					j++;
				}

			}
			System.out.println(finalResult);
		}

	}

}
