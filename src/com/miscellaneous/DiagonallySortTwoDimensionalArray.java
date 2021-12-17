package com.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DiagonallySortTwoDimensionalArray {

	public static void main(String args[]) {

		int array[][] = { { 10, 6, 3 }, { 8, 5, 2 }, { 7, 4, 9 } };
		for (int ar[] : array) {
			System.out.println(Arrays.toString(ar));
		}
		System.out.println("After Sorting");
		diagonalSort(array);
		for (int ar[] : array) {
			System.out.println(Arrays.toString(ar));
		}
	}

	private static void diagonalSort(int mat[][]) {

		// incrementing column and finding diagonals
		// UPPER DIAGOANL
		int row = mat.length;
		int col = mat[0].length;

		for (int i = 0; i < col; i++) {
			int r = 0, c = i; // (0,1), (1, 2),
			List<Integer> diagonal = new ArrayList<>();
			while (r < row && c < col) {
				diagonal.add(mat[r][c]);
				r++;
				c++;
			}
			Collections.sort(diagonal);

			// keeping back the elements
			r = 0;
			c = i;
			int sortedI = 0;
			while (r < row && c < col) {
				mat[r][c] = diagonal.get(sortedI);
				sortedI++;
				r++;
				c++;

			}

		}

		// incrementing rows and finding diagonals
		// LOWER DIAGOANL
		for (int i = 1; i < row; i++) {
			int r = i, c = 0;
			List<Integer> diagonal = new ArrayList<>();
			while (r < row && c < col) {
				diagonal.add(mat[r][c]);
				r++;
				c++;
			}
			Collections.sort(diagonal);
			r = i;
			c = 0;
			int sortedI = 0;
			while (r < row && c < col) {
				mat[r][c] = diagonal.get(sortedI);
				r++;
				c++;
				sortedI++;
			}
		}

	}
}
