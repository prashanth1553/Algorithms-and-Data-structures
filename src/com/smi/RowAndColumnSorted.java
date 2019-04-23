package com.smi;

public class RowAndColumnSorted {

	public static void main(String args[]) {

		int mat[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
		System.out.println(searchRowAndColumnSorted(mat, 1));
		System.out.println(searchRowAndColumnSorted(mat, 10));
		System.out.println(searchRowAndColumnSorted(mat, 20));
		
		System.out.println("////////////////");
		int fully[][] = { { 1, 5, 9 }, { 14, 20, 21 }, { 30, 34, 43 } };
		System.out.println(fullySortedMatrix(fully, 1));
		System.out.println(fullySortedMatrix(fully, 100));
		System.out.println(fullySortedMatrix(fully, 5));
	}

	public static boolean searchRowAndColumnSorted(int mat[][], int key) {
		int rowL = mat.length;
		int colL = mat[0].length;
		int row = 0;
		int column = mat[0].length - 1;
		while (row < rowL && column >= 0) {
			int element = mat[row][column];
			if (element == key) {
				return true;
			} else if (element < key) {
				row++;
			} else {
				column--;
			}
		}
		return false;
	}

	public static boolean fullySortedMatrix(int mat[][], int key) {
		int rowL = mat.length;
		int colL = mat[0].length;
		int lo = 0, hi = rowL * colL - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int midV = mat[mid / rowL][mid % rowL];
			if (midV == key) {
				return true;
			} else if (midV < key) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}

		}

		return false;
	}
}
