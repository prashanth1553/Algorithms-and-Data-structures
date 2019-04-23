package com.smi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeCoins {

	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int t = 0; t < testCases; t++) {
			int number = Integer.parseInt(bufferedReader.readLine().trim());
			if (number % 6 == 0) {
				System.out.println("Banta");
			} else {
				System.out.println("Santa");
			}

		}

	}
}
