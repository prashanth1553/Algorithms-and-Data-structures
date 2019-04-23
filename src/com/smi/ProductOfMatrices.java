package com.smi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductOfMatrices {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int testCases = Integer.parseInt(scanner.nextLine().trim());
		for (int t = 0; t < testCases; t++) {
			String firstMatrxi[] = scanner.nextLine().trim().split(" ");
			int r1, c1, r2, c2;
			r1 = Integer.parseInt(firstMatrxi[0]);
			c1 = Integer.parseInt(firstMatrxi[1]);
			List<Integer[]> matrix1 = readMatrix(r1, c1);
			String secondMatrxi[] = scanner.nextLine().trim().split(" ");
			r2 = Integer.parseInt(secondMatrxi[0]);
			c2 = Integer.parseInt(secondMatrxi[1]);
			List<Integer[]> matrix2 = readMatrix(r2, c2);
			List<Integer[]> result = new ArrayList<>(r1);
			for (int i = 0; i < r1; i++) {
				String eachRow = "";
				for (int j = 0; j < c2; j++) {
					int sum = 0;
					for (int k = 0; k < r2; k++) {
						sum += (matrix1.get(i)[k] * matrix2.get(k)[j]);

					}
					eachRow += sum + " ";
				}
				System.out.println(eachRow);

			}

		}

	}

	public static List<Integer[]> readMatrix(int r1, int c1) {
		List<Integer[]> matrix1 = new ArrayList<>(r1);
		for (int i = 0; i < r1; i++) {
			Integer row[] = new Integer[c1];
			String eachRow[] = scanner.nextLine().trim().split(" ");
			for (int c = 0; c < c1; c++) {
				row[c] = Integer.parseInt(eachRow[c]);
			}
			matrix1.add(row);
		}
		return matrix1;
	}
}
