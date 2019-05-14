package com.smi.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class ComputenCr {

	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	private static final int mod = (int) 1e9 + 7;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		int maxN = Integer.MIN_VALUE;
		int maxR = Integer.MIN_VALUE;
		int queriesN[] = new int[testCases];
		int queriesR[] = new int[testCases];
		for (int t = 0; t < testCases; t++) {
			String nAndR[] = bufferedReader.readLine().trim().split(" ");
			int N = Integer.parseInt(nAndR[0]);
			int R = Integer.parseInt(nAndR[1]);
			queriesN[t] = N;
			queriesR[t] = R;
			maxN = Math.max(maxN, N);
			maxR = Math.max(maxR, R);
		}
		long answer[][] = new long[maxN + 1][maxR + 1];
		Arrays.fill(answer[0], 0l);
		for (int i = 0; i <= maxN; i++) {
			answer[i][0] = 1;
		}
		answer[0][0] = 1;
		for (int i = 1; i <= maxN; i++) {
			for (int j = 1; j <= maxR && j <= i; j++) {
				answer[i][j] = (answer[i - 1][j - 1] + answer[i - 1][j]) % mod;
			}
		}

		for (int i = 0; i < testCases; i++) {
			writer.write("" + answer[queriesN[i]][queriesR[i]]);
			writer.newLine();
		}
		writer.flush();
	}
}
