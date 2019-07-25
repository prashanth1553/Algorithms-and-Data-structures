package com.smi.binarysearch;

public class FindTheElementThatAppearsOnceInASortedArray {

	public static void onceOccurredElement(int array[]) {
		int lo = 0, hi = array.length - 1;

		while (lo <= hi) {
			if (lo == hi) {
				System.out.println("The Once element is " + array[lo]);
				break;

			}

			int mid = lo + (hi - lo) / 2;

			if (mid % 2 == 0) {
				if (array[mid] == array[mid + 1]) {
					lo = mid + 2;
				} else {
					hi = mid;
				}

			} else {

				if (array[mid] == array[mid - 1]) {
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}

			}

		}

	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 2, 4, 4, 5, 5, 6, 6, 7 };
		onceOccurredElement(arr);
	}
}
