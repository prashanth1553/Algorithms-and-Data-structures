package com.smi;

import java.util.Scanner;

public class RabinKarpStringMatchingAlgorithm {

	private static final Scanner scanner = new Scanner(System.in);
	private static final int prime = 101;
	private static long power[] = null;
	private static int mod = 10000007;

	public static void main(String[] args) {
		int testCases = Integer.parseInt(scanner.nextLine().trim());
		for (int t = 0; t < testCases; t++) {
			String inputArray[] = scanner.nextLine().trim().split(" ");
			String key = inputArray[0];
			int M = key.length();
			String input = inputArray[1];
			int N = input.length();
			power = new long[key.length() + 1];
			power[0] = 1;
			for (int i = 1; i < power.length; i++) {
				power[i] = (prime * power[i - 1]) % mod;
			}
			long keyHash = hash(key, M);
			long initialHash = hash(input.substring(0, M), M);
			int count = 0;
			if (keyHash == initialHash) {
				count++;
			}
			for (int i = 1; i < (N - M + 1); i++) {
				long currentHash = (initialHash - ((input.charAt(i - 1) * (power[M])) % mod) + mod) % mod;
				currentHash = (currentHash * power[1]) % mod;
				currentHash = (currentHash + (input.charAt(i + M - 1) * (power[1])) % mod) % mod;
				if (keyHash == currentHash) {
					count++;
				}
				initialHash = currentHash;
			}
			System.out.println(count);
		}
	}

	private static long hash(String str, int M) {
		long hash = 0;
		for (int i = 0; i < str.length(); i++) {
			hash = (hash + ((str.charAt(i) * (power[M - i])) % mod) % mod) % mod;
		}
		return hash;
	}

}
