package com.sorting;

public class BinarySearch {

	public static void main(String args[]) {

		BinarySearch object = new BinarySearch();

		int array[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(object.binarySearch(array, 0, array.length - 1, 15));
		System.out.println(object.binarySearch(array, 0, array.length - 1, 5));
	}

	private boolean binarySearch(int array[], int low, int hi, int key) {

		while (low <= hi) {
			int mid = low + (hi - low) / 2;
			if (key == array[mid]) {
				return true;
			} else if (key < array[mid]) {
				hi = mid - 1;
			} else {
				low = mid + 1;
			}

		}

		return false;
	}
}
