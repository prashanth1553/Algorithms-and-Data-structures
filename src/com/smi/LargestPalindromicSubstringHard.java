package com.smi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestPalindromicSubstringHard {

	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	private static final int prime = 101;
	private static final int modulo = 100000007;
	private static long powerArray[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int t = 0; t < testCases; t++) {
			int totalLegnth = Integer.parseInt(bufferedReader.readLine().trim());
			String inputString = bufferedReader.readLine().trim();
			long forwardHash[] = new long[inputString.length()];
			long backwardHash[] = new long[inputString.length()];
			computePowerArray(totalLegnth + 1);
			computeHash(inputString, totalLegnth, forwardHash, backwardHash);
			// even length
			int lo = 0, hi = totalLegnth - 1, mid;
			int ans = 1;
			while (lo <= hi) {
				mid = lo + (hi - lo) / 2;
				if (searchKWindowpolindrome(2 * mid - 1, totalLegnth-1, forwardHash, backwardHash)) {
					ans = Math.max(ans, 2 * mid - 1);
					break;
				} else {
					hi -= 2;
				}
			}
			lo = 0;
			hi = totalLegnth - 1;
			while (lo <= hi) {
				mid = lo + (hi - lo) / 2;
				if (searchKWindowpolindrome(mid * 2, totalLegnth, forwardHash, backwardHash)) {
					ans = Math.max(ans, mid*2);
					break;
				} else {
					hi -= 2;
				}
			}
			System.out.println(ans);
		}
	}

	private static boolean searchKWindowpolindrome(int k, int totalL, long forwardHash[], long backwardHash[]) {
		for (int i = 0; i <= (totalL - k + 1); i++) {
			if (check(i, i + k - 1, forwardHash, backwardHash)) {
				return true;
			}
		}

		return false;
	}

	private static void computePowerArray(int length) {
		powerArray = new long[length];
		powerArray[0] = 1l;
		for (int i = 1; i < length; i++) {
			powerArray[i] = (powerArray[i - 1] * prime) % modulo;

		}

	}

	private static void computeHash(String inputString, int totalLegnth, long forwardHash[], long backwardHash[]) {
		for (int i = 0; i < totalLegnth; i++) {
			char c = inputString.charAt(i);
			long currentFHash = (c * powerArray[i + 1]) % modulo;
			if (i == 0) {
				forwardHash[i] = currentFHash;
			} else {
				forwardHash[i] = (forwardHash[i - 1] + currentFHash) % modulo;
			}
		}
		for (int i = totalLegnth - 1; i >= 0; i--) {
			char c = inputString.charAt(i);
			long currentBHash = (c * powerArray[totalLegnth - i]) % modulo;
			if (i == totalLegnth - 1) {
				backwardHash[i] = currentBHash;
			} else {
				backwardHash[i] = (backwardHash[i + 1] + currentBHash) % modulo;
			}
		}

	}

	private static boolean check(int i, int j, long forwardHash[], long backwardHash[]) {
		long fh = 0;
		if (i == 0) {
			fh = forwardHash[j];
		} else {
			fh = (forwardHash[j] - forwardHash[i - 1] + modulo) % modulo;
		}
		long bh = 0;
		if (j == backwardHash.length - 1) {
			bh = backwardHash[i];
		} else {
			bh = (backwardHash[i] - backwardHash[j + 1] + modulo) % modulo;
		}

		long smallestPowerOfF = i + 1;
		long smallestPowerOfB = backwardHash.length - j;

		int d = (int) Math.abs(smallestPowerOfF - smallestPowerOfB);
		if (smallestPowerOfF > smallestPowerOfB) {
			bh = (bh * powerArray[d]) % modulo;
		} else if (smallestPowerOfF < smallestPowerOfB) {
			fh = (fh * powerArray[d]) % modulo;
		}

		return fh == bh;
	}

	public static void main12(String args[]) throws IOException {
		String inputString = "aabbaat";
		int totalLegnth = inputString.length();

		long forwardHash[] = new long[inputString.length()];
		long backwardHash[] = new long[inputString.length()];
		computePowerArray(totalLegnth + 1);
		computeHash(inputString, totalLegnth, forwardHash, backwardHash);
		// verifying whether rolling hash working or not
		System.out.println(check(0, 5, forwardHash, backwardHash));
	}

}
