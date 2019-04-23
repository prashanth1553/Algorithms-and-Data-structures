package com.smi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RotationOfMatrix {

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
				for (int k = N-1; k >= 0; k--) {
					if(k == N-1) {
						System.out.print(rowList.get(k)[j]);
					}else {
						System.out.print(" "+rowList.get(k)[j]);
					}
					
				}
				System.out.println();
			}

		}

	}
}
