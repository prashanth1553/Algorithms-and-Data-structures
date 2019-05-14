package com.smi.graphs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PathInAMatrix {

	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	private static final int mod = (int) 1e9 + 7;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int t = 0; t < testCases; t++) {
			String nAndK[] = bufferedReader.readLine().trim().split(" ");
			int N = Integer.parseInt(nAndK[0]);
			int M = Integer.parseInt(nAndK[1]);
			int B = Integer.parseInt(nAndK[2]);
			long matrix[][] = new long[N][M];
			matrix[0][0] = 1l;
			for (int i = 0; i < B; i++) {
				String block[] = bufferedReader.readLine().trim().split(" ");
				int r = Integer.parseInt(block[0]);
				int c = Integer.parseInt(block[1]);
				matrix[r][c] = -1;
			}
			long ans = 0;
			if (!((matrix[0][0] == -1) || (matrix[N - 1][M - 1] == -1))) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (matrix[i][j] != -1) {
							long current = matrix[i][j];
							if (i - 1 >= 0 && matrix[i - 1][j] != -1) {
								current = (current + matrix[i - 1][j]) % mod;
							}
							if (j - 1 >= 0 && matrix[i][j - 1] != -1) {
								current = (current + matrix[i][j - 1]) % mod;
							}
							if (i - 1 >= 0 && j - 1 >= 0 && matrix[i - 1][j - 1] != -1) {
								current = (current + matrix[i - 1][j - 1]) % mod;
							}

							matrix[i][j] = current;
						}
					}

				}

			}
			ans = matrix[N - 1][M - 1];
			if (ans == -1) {
				ans = 0;
			}
			writer.write("" + ans);
			writer.newLine();
		}
		writer.flush();
	}
}
