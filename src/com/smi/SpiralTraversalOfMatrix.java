package com.smi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpiralTraversalOfMatrix {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String args[]) {
		int t = Integer.parseInt(scanner.nextLine().trim());
		for (int i = 0; i < t; i++) {
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

			int rowStart = 0, rowEnd = N - 1, colStart = 0, colEnd = N - 1;
			while (rowStart <= rowEnd && colStart <= colEnd) {

				for (int j = colStart; j <= colEnd; j++) {
					System.out.print(rowList.get(rowStart)[j] + " ");
				}
				rowStart++;

				for (int j = rowStart; j <= rowEnd; j++) {
					System.out.print(rowList.get(j)[colEnd] + " ");
				}

				colEnd--;

				if (colEnd >= colStart) {
					for (int j = colEnd; j >= colStart; j--) {
						System.out.print(rowList.get(rowEnd)[j] + " ");
					}
				}

				rowEnd--;

				if (rowEnd >= rowStart) {
					for (int j = rowEnd; j >= rowStart; j--) {
						System.out.print(rowList.get(j)[colStart] + " ");
					}
				}
				colStart++;

			}
			System.out.println();
		}

	}

}
