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
			int sqrtOfB = (int) Math.round(Math.sqrt(b))+1;
			boolean primesTillB[] = new boolean[sqrtOfB];
			Arrays.fill(primesTillB, true);
			primesTillB[0] = false;
			primesTillB[1] = false;
			for (int i = 2; i <= Math.sqrt(sqrtOfB); i++) {
				if (primesTillB[i]) {
					for (int j = i * i; j < primesTillB.length; j += i) {
						primesTillB[j] = false;
					}

				}

			}
			boolean finalPrimes[] = new boolean[b - a + 1];
			Arrays.fill(finalPrimes, Boolean.TRUE);
			for (int i = 2; i <= Math.sqrt(b); i++) {
				if (primesTillB[i]) {
					int markingStart = i; // condier it as number
					int x = 0;
					if (a  == markingStart) {
						x = markingStart;
					} 
					else if (a % markingStart == 0) {
						x = 0;
					} else if (a < markingStart) {
						x = 2 * markingStart - a;
					} else {
						x = markingStart - a % markingStart;
						x +=markingStart;
					}

					for (int j = x; j <= (b - a); j = j + i) {
						finalPrimes[j] = false;
					}
				}

			}
			for (int i = 0; i < finalPrimes.length; i++) {
				if (finalPrimes[i]) {
					System.out.println(a + i);
				}
			}
			System.out.println();
		}
	}

}
