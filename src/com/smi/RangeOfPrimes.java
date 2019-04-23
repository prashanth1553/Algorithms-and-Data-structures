package com.smi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RangeOfPrimes {
	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int t = 0; t < testCases; t++) {
			String numbers[] = bufferedReader.readLine().trim().split(" ");
			int a = Integer.parseInt(numbers[0]);
			int b = Integer.parseInt(numbers[1]);
			int r = new Double(Math.sqrt(b)).intValue();
			boolean primesTillB[] = new boolean[r];
			Arrays.fill(primesTillB, true);
			primesTillB[0] = false;
			primesTillB[1] = false;
			for (int i = 2; i <= Math.sqrt(r); i++) {
				if (primesTillB[i]) {
					for (int j = i * i; i <= r; j = j + i) {
						primesTillB[j] = false;
					}

				}
			}
			boolean primes[] = new boolean[b - a + 1 + 1];
			for (int i = 2; i <= r; i++) {
				if (primesTillB[i]) {
					int loLim = (int) (double) Math.floor(a / i) * i;
					if (loLim < a)
						loLim += i;
					for (int j = loLim; i <= b; j = j + i) {
						primes[j - loLim] = false;
					}
				}
			}
			int count = 0;
			for (int i = 0; i < primes.length; i++) {
				if (primes[i]) {
					count++;
				}
			}
			System.out.println(count);

		}
	}

}
