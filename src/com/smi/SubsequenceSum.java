package com.smi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class SubsequenceSum {

	private final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String args[]) throws NumberFormatException, IOException {

		int testCases = Integer.parseInt(reader.readLine());
		for (int t = 0; t < testCases; t++) {
			int count = 0;
			String input[] = reader.readLine().trim().split(" ");
			int N = Integer.parseInt(input[0]);
			long A = Long.parseLong(input[1]);
			long B = Long.parseLong(input[2]);
			String areaS[] = reader.readLine().trim().split(" ");
			long rectArea[] = new long[N];
			for (int i = 0; i < N; i++) {
				rectArea[i] = Long.parseLong(areaS[i]);
			}
			boolean isEven = N % 2 == 0;
			int middle = isEven ? N / 2 : (N / 2) + 1;
			int half = N / 2;
			int totalSubSequences = (int) (double) Math.pow(2, middle) - 1;
			int secondTotalSubSequences = (int) (double) Math.pow(2, N / 2) - 1;
			long firstPart[] = new long[totalSubSequences];
			TreeMap<Long, Long> secondHalf = new TreeMap<>();
			for (int i = 1; i <= totalSubSequences; i++) {
				int temp = i;
				long v1 = 0;
				long v2 = 0;
				for (int b = 0; b < 31; b++) {
					if (((temp >> b) & 1) != 0) {
						v1 += rectArea[b];
						if (i <= secondTotalSubSequences) {
							if (isEven) {
								v2 += rectArea[half + b];
							} else {
								v2 += rectArea[half + 1 + b];
							}
						}
					}
				}
				firstPart[i - 1] = v1;
				if (isWithinLimits(A, B, v1)) {
					count++;
				}
				if (i <= secondTotalSubSequences) {
					if (isWithinLimits(A, B, v2)) {
						count++;
					}
					if (secondHalf.containsKey(v2)) {
						secondHalf.put(v2, secondHalf.get(v2) + 1);
					} else {
						secondHalf.put(v2, 1l);
					}
				}
			}
			for (long e : firstPart) {
				SortedMap<Long, Long> between = secondHalf.subMap(A - e, true, B - e, true);
				for (Entry<Long, Long> entry : between.entrySet()) {
					count += entry.getValue();
				}
			}
			if (isWithinLimits(A, B, 0)) {
				count++;
			}

			System.out.println(count);
		}
	}

	public static boolean isWithinLimits(long A, long B, long key) {

		return A <= key && B >= key;

	}
}
