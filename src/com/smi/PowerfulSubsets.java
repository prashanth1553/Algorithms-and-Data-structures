package com.smi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PowerfulSubsets {

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
			boolean isFound = false;
			for (int i = 0; i <= 30; i++) {
				int result = Integer.MAX_VALUE;
				for (int j = 0; j < size; j++) {
					if (((array[j] >> i) & 1) == 1) {
						result = result & array[j];
					}
				}
				if (result != 0 && (result & (result - 1)) == 0) {
					isFound = true;
					break;
				}
			}
			if (isFound) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}
	}
}
