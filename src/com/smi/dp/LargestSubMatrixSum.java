package com.smi.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class LargestSubMatrixSum {

	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int t = 0; t < testCases; t++) {
			int N, M;
			String[] size = bufferedReader.readLine().trim().split(" ");
			N = strToInt(size[0]);
			M = strToInt(size[1]);
			int[][] matrix = new int[N][M];
			for (int i = 0; i < N; i++) {
				String[] row = bufferedReader.readLine().trim().split(" ");
				for (int j = 0; j < M; j++) {
					matrix[i][j] = strToInt(row[j]);
				}

			}
			int ans = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				int columnsum[] = new int[M];
				for (int j = i; j < N; j++) {
					int carry = 0;
					for (int k = 0; k < M; k++) {
//						for (int c = i; c <= j; c++) {
//							carry += matrix[c][k];
//						}
						columnsum[k] += matrix[j][k];
						carry += columnsum[k];
						ans = Math.max(ans, carry);
						carry = carry < 0 ? 0 : carry;
					}

				}
				Arrays.fill(columnsum, 0);

			}
			writer.write("" + ans);
			writer.newLine();

		}
		writer.flush();
	}

	private static int strToInt(String str) {
		return Integer.parseInt(str);
	}
}
