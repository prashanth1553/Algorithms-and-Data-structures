package com.smi.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ArrangingDominos {

	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	private static final int mod = (int) 1e9 + 7;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		int queries[] = new int[testCases];
		int max = Integer.MIN_VALUE;
		for (int t = 0; t < testCases; t++) {
			int q = Integer.parseInt(bufferedReader.readLine().trim());
			queries[t] = q;
			max = Math.max(max, q);
		}
		long ans[] = new long[max + 1];
		ans[0] = 1l;
		ans[1] = 1l;
		ans[2] = 2l;
		for (int i = 3; i <= max; i++) {
			long answer = (ans[i - 1] + ans[i - 2]) % mod;
			if (i >= 5) {
				answer = (answer + (8l * ans[i - 5]) % mod) % mod;
			}
			ans[i] = answer;
		}

		for (int i = 0; i < testCases; i++) {
			writer.write(ans[queries[i]] + "");
			writer.newLine();
		}
		writer.flush();
	}
}
