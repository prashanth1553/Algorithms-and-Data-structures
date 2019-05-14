package com.smi.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TheKnapsackProblem {

	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int t = 0; t < testCases; t++) {
			String[] sizeAndN = bufferedReader.readLine().trim().split(" ");
			int S = strToInt(sizeAndN[0]);
			int N = strToInt(sizeAndN[1]);
			int size[] = new int[N + 1];
			int value[] = new int[N + 1];
			String[] sAnV = null;
			for (int i = 1; i <= N; i++) {
				sAnV = bufferedReader.readLine().trim().split(" ");
				size[i] = strToInt(sAnV[0]);
				value[i] = strToInt(sAnV[1]);
			}
			int dp[][] = new int[2][S + 1];
			int ans = Integer.MIN_VALUE;
			for (int j = 1; j <= N; j++) {
				for (int i = 1; i <= S; i++) {
					if (i >= size[j]) {
						if (j == 1) {
							dp[j % 2][i] = value[j];
						} else {
							dp[j % 2][i] = Math.max(dp[(j - 1) % 2][i - size[j]] + value[j], dp[(j - 1) % 2][i]);
						}
					} else {
						if (j == 1) {
							dp[j % 2][i] = 0;
						} else {
							dp[j % 2][i] = dp[(j - 1) % 2][i];
						}

					}
					ans = Math.max(ans, dp[j % 2][i]);
				}
			}
			writer.write("" + dp[N % 2][S]);
			writer.newLine();
		}
		writer.flush();
	}

	private static int strToInt(String str) {
		return Integer.parseInt(str);
	}
}
