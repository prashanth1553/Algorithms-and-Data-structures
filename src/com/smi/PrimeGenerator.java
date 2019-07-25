package com.smi;

import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PrimeGenerator {
	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int t = 0; t < testCases; t++) {
			String numbers[] = bufferedReader.readLine().trim().split(" ");
			int a = Integer.parseInt(numbers[0]);
			int b = Integer.parseInt(numbers[1]);
			int sqrtOfB = (int) Math.round(Math.sqrt(b));
			boolean primesTillB[] = new boolean[sqrtOfB+1];
			Arrays.fill(primesTillB, true);
			primesTillB[0] = false;
			primesTillB[1] = false;

			for (int i = 2; i <= sqrtOfB; i++) {
				if (primesTillB[i]) {
					for (int j = i * i; j <= sqrtOfB; j = j + i) {
						primesTillB[j] = false;
					}

				}

			}

			boolean finalPrimes[] = new boolean[b - a + 1];
			Arrays.fill(finalPrimes, true);
			if(a == 1) {
				finalPrimes[0] = false;
			}
			for (int i = 2; i <= sqrtOfB; i++) {
				if (primesTillB[i]) {
					int indexToStart = 0;
					int actualIndexToStart = i * i;
					if (actualIndexToStart == a) {
						indexToStart = 0;
					} else if (actualIndexToStart > a) {
						indexToStart = actualIndexToStart - a ;
					} else {
						int r = a % i;
						indexToStart = r == 0 ? 0 : i - r;
					}

					for (int j = indexToStart; j < finalPrimes.length; j = j + i) {
						finalPrimes[j] = false;
					}

				}
			}

			int count = 0;
			for (int i = 0; i < finalPrimes.length; i++) {
				if (finalPrimes[i]) {
//					System.out.println(a + i + " , ");
					count++;
				}
			}
			System.out.println(count);

		}
	}

	// 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97
	// 13
	
	// 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, and 199.
}
