package com.miscellaneous;

import java.util.ArrayList;
import java.util.Collections;

public class CountingTriangles {

	public int nTriang(ArrayList<Integer> A) {
		int total = 0;
		int mod = 1000000007;
		Collections.sort(A);
		int n = A.size();
		for (int i = n - 1; i >= 1; i--) {
			int l = 0, h = i - 1;
			while (l < h) {
				int sum = A.get(l) + A.get(h);
				if (sum > A.get(i)) {
					total = (total + (h - l)) % mod;
					h--;
				} else {
					l++;
				}

			}

		}
		return total;

	}

	public static void main(String args[]) {

		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(1);
		a.add(1);
		CountingTriangles obj = new CountingTriangles();

		System.out.println(obj.nTriang(a));
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length < 0) {
			return false;
		}
		int rowSize = matrix.length;
		int colSize = matrix[0].length;
		int row = -1;
		int low = 0, hi = rowSize - 1;
		while (low <= hi) {
			int mid = low + (hi - low) / 2;
			int midV = matrix[mid][0];
			if (midV == target) {
				return true;
			}
			if (midV > target) {
				hi = mid - 1;
			} else {
				row = mid;
				low = mid + 1;
			}

		}

		if (row >= 0 && row < rowSize) {
			low = 0;
			hi = colSize - 1;
			while (low <= hi) {
				int mid = low + (hi - low) / 2;
				int midV = matrix[row][mid];
				if (midV == target) {
					return true;
				}
				if (midV > target) {
					hi = mid - 1;
				} else {
					low = mid + 1;
				}

			}

		}

		return false;
	}
}
