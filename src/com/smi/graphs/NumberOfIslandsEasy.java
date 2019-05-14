package com.smi.graphs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NumberOfIslandsEasy {

	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int t = 0; t < testCases; t++) {

			String[] nAndE = bufferedReader.readLine().trim().split(" ");
			int R = strToInt(nAndE[0]);
			int C = strToInt(nAndE[1]);
			boolean[][] matrix = new boolean[R][C];
			for (int i = 0; i < R; i++) {
				String row = bufferedReader.readLine().trim();
				for (int j = 0; j < row.length(); j++) {
					matrix[i][j] = row.charAt(j) == '1';
				}
			}
			int colN[] = { -1, 0, 1, 1, 1, 0, -1, -1 };
			int rowN[] = { -1, -1, -1, 0, 1, 1, 1, 0 };
			int c = 0;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (matrix[i][j]) {
						c++;
						visit(matrix, i, j, rowN, colN, R, C);
					}
				}
			}
			writer.write("" + c);
			writer.newLine();
		}
		writer.flush();
	}

	private static void visit(boolean[][] matrix, int r, int c, int rowN[], int colN[], int rows, int colums) {
		matrix[r][c] = false;
		for (int i = 0; i < 8; i++) {
			int R = r + rowN[i];
			int C = c + colN[i];
			if (R >= 0 && R < rows && C >= 0 && C < colums && matrix[R][C]) {
				visit(matrix, R, C, rowN, colN, rows, colums);
			}

		}
	}

	private static int strToInt(String str) {
		return Integer.parseInt(str);
	}

}
