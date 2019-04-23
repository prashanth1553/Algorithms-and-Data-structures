package com.smi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class QuadruplesOfXOR {

	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String args[]) throws NumberFormatException, IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int t = 0; t < testCases; t++) {
			int size = Integer.parseInt(bufferedReader.readLine().trim());
			int a[] = new int[size];
			int b[] = new int[size];
			int c[] = new int[size];
			int d[] = new int[size];

			String aS[] = bufferedReader.readLine().trim().split(" ");
			convertStringToIntArray(a, aS);
			aS = bufferedReader.readLine().trim().split(" ");
			convertStringToIntArray(b, aS);
			aS = bufferedReader.readLine().trim().split(" ");
			convertStringToIntArray(c, aS);
			aS = bufferedReader.readLine().trim().split(" ");
			convertStringToIntArray(d, aS);
			HashMap<Integer, Integer> mapA = new HashMap<>(size * size);
			HashMap<Integer, Integer> mapB = new HashMap<>(size * size);
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					int xorA = a[i] ^ b[j];
					int xorB = c[i] ^ d[j];
					updateMap(mapA, xorA);
					updateMap(mapB, xorB);
				}
			}
			int count = 0;
			for (Map.Entry<Integer, Integer> entry : mapA.entrySet()) {
				if (mapB.containsKey((int) entry.getKey())) {
					int k = (int) entry.getKey();
					count += (entry.getValue() * mapB.get(k));

				}
			}
			System.out.println(count);
		}

	}

	private static void convertStringToIntArray(int ia[], String is[]) {
		for (int i = 0; i < is.length; i++) {
			ia[i] = Integer.parseInt(is[i]);
		}
	}

	private static void updateMap(HashMap<Integer, Integer> map, int key) {
		if (map.containsKey(key)) {
			map.put(key, map.get(key) + 1);
		} else {
			map.put(key, 1);
		}

	}

}
