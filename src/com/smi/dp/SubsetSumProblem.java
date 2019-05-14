package com.smi.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SubsetSumProblem {

	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int t = 0; t < testCases; t++) {
			String[] sizeAndN = bufferedReader.readLine().trim().split(" ");
			int N = strToInt(sizeAndN[0]);
			int S = strToInt(sizeAndN[1]);
			int set[] = new int[N + 1];
			String items[] = bufferedReader.readLine().trim().split(" ");
			for (int i = 1; i <= N; i++) {
				set[i] = strToInt(items[i - 1]);
			}
			boolean[][] dp = new boolean[N + 1][S + 1];
			for (int i = 0; i <= N; i++) {
				dp[i][0] = true;
			}
			for (int i = 1; i <= S; i++) {
				dp[0][i] = false;
			}
			for (int i = 1; i <= N; i++) {

				for (int j = 1; j <= S; j++) {
					if (j >= set[i]) {
						dp[i][j] = dp[i - 1][j] || dp[i - 1][j - set[i]];
					} else {
						dp[i][j] = dp[i - 1][j];
					}

				}
			}
			String result = dp[N][S] ? "YES" : "NO";
			writer.write(result);
			writer.newLine();
		}
		writer.flush();
	}

	private static int strToInt(String str) {
		return Integer.parseInt(str);
	}
}
