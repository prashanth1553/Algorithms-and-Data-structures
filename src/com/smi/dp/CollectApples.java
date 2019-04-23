package com.smi.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CollectApples {

	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	private static final int mod = (int) 1e9 + 7;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int t = 0; t < testCases; t++) {
			String[] nAndM = bufferedReader.readLine().trim().split(" ");
			int N = Integer.parseInt(nAndM[0]);
			int M = Integer.parseInt(nAndM[1]);
			int apples[][] = new int[N][M];
			for (int i = 0; i < N; i++) {
				String[] row = bufferedReader.readLine().trim().split(" ");
				for (int j = 0; j < M; j++) {
					apples[i][j] = Integer.parseInt(row[j]);
				}
			}
			int ans = Integer.MIN_VALUE;
			// updating for rows
			for (int i = 1; i < M; i++) {
				apples[0][i] = (apples[0][i - 1] + apples[0][i]) % mod;
				ans = Math.max(ans, apples[0][i]);
			}
			// updating for columns
			for (int j = 1; j < N; j++) {
				apples[j][0] = (apples[j - 1][0] + apples[j][0]) % mod;
				ans = Math.max(ans, apples[j][0]);
			}

			for (int i = 1; i < N; i++) {
				for (int j = 1; j < M; j++) {
					apples[i][j] = (apples[i][j] + Math.max(apples[i - 1][j], apples[i][j - 1])) % mod;
					ans = Math.max(ans, apples[i][j]);
				}

			}
			writer.write(ans + "");
			writer.newLine();
		}

		writer.flush();
	}
}
