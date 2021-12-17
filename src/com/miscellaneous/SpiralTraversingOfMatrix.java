package com.miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversingOfMatrix {

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ans = new ArrayList<Integer>();

		if (matrix.length == 0)
			return ans;

		int R = matrix.length, C = matrix[0].length;
		boolean[][] seen = new boolean[R][C];
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		int r = 0, c = 0, di = 0;
		int r_min = 0, r_max = R - 1;
		int c_min = 0, c_max = C - 1;

		// Iterate from 0 to R * C - 1
		int c_dr = 0;
		for (int i = 0; i < R * C; i++) {
			

		}
		return ans;
	}

	// Driver Code
	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		System.out.println(spiralOrder(a));
	}
}
