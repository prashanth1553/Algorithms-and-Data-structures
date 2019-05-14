package com.smi.graphs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class RottingOranges {

	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int t = 0; t < testCases; t++) {
			int N = strToInt(bufferedReader.readLine().trim());
			int matrix[][] = new int[N][N];
			for (int i = 0; i < N; i++) {
				String row = bufferedReader.readLine().trim();
				for (int j = 0; j < row.length(); j++) {
					matrix[i][j] = strToInt("" + row.charAt(j));
				}
			}
			int freshO = 0;
			int visinityX[] = { 0, -1, 0, 1 };
			int visinityY[] = { -1, 0, 1, 0 };

			Set<String> newRottenOrages = new HashSet<>();
			boolean initial = mark(matrix, newRottenOrages, visinityX, visinityY, N);
			if (!initial) {

			}
			while (!newRottenOrages.isEmpty()) {
				newRottenOrages.clear();
			}
		}
	}

	private static boolean mark(int matrix[][], Set<String> newRottenOrages, int visinityX[], int visinityY[], int N) {
		boolean isRotten = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (matrix[i][j] == 2 && !newRottenOrages.contains("" + i + j)) {
					isRotten = isRotten || mark(matrix, newRottenOrages, visinityX, visinityY, i, j, N);
				}

			}
		}
		return isRotten;
	}

	private static boolean mark(int matrix[][], Set<String> newRottenOrages, int visinityX[], int visinityY[], int i,
			int j, int N) {
		boolean isRotten = false;
		for (int k = 0; k < 4; k++) {
			int ii = i + visinityX[k];
			int jj = j + visinityY[k];
			if (ii >= 0 && ii < N && jj >= 0 && jj < N) {
				if (matrix[ii][jj] == 1) {
					isRotten = true;
					matrix[ii][jj] = 2;
					newRottenOrages.add("" + ii + jj);
				}

			}

		}

		return isRotten;
	}

	private static int strToInt(String str) {
		return Integer.parseInt(str);
	}
}
