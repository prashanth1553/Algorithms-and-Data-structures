package com.smi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiagonalTraversalOfMatrix {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String args[]) {
		int t = Integer.parseInt(scanner.nextLine().trim());
		for (int i = 0; i < t; i++) {
			System.out.println("Test Case #" + (i + 1) + ":");
			int N = Integer.parseInt(scanner.nextLine().trim());
			List<int[]> rowList = new ArrayList<int[]>(N);
			for (int a = 0; a < N; a++) {
				String row[] = scanner.nextLine().split(" ");
				int rowInt[] = new int[row.length];
				for (int r = 0; r < row.length; r++) {
					rowInt[r] = Integer.parseInt(row[r]);
				}
				rowList.add(rowInt);
			}
			for (int j = 0; j < N; j++) {
				int sum = 0;
				for (int k = N - 1, jj = j; k >= 0 && jj >= 0; k--, jj--) {
					sum += rowList.get(jj)[k];
				}
				if (j == 0) {
					System.out.print(sum);
				} else {
					System.out.print(" " + sum);
				}

			}
			for (int j = N - 2; j >= 0; j--) {
				int sum = 0;
				for (int k = j, jj = N - 1; k >= 0 && jj >= 0; k--, jj--) {
					sum += rowList.get(jj)[k];
				}
				System.out.print(" " + sum);
			}
			System.out.println();
		}

	}
}
