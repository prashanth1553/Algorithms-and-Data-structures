package com.miscellaneous;

import java.util.Arrays;

public class PythagoreanTriplet {

	public static void main(String agrs[]) {

		int arr[] = { 3, 1, 4, 6, 5 };
		isTriplet(arr);
		isTripletSorting(arr);

	}

	static boolean isTriplet(int arr[]) {
		int l = arr.length;
		for (int i = 0; i < l; i++) {

			for (int j = i + 1; j < l; j++) {

				for (int k = j + 1; k < l; k++) {
					int x = arr[i] * arr[i], y = arr[j] * arr[j], z = arr[k] * arr[k];

					if (x == y + z || y == x + z || z == x + y) {
						System.out.println("Pythagorean  " + arr[i] + ", " + arr[j] + ", " + arr[k]);
						return true;
					}
				}

			}

		}
		return false;

	}

	static boolean isTripletSorting(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; i++)
			arr[i] = arr[i] * arr[i];

		Arrays.sort(arr);

		for (int i = n - 1; i >= 2; i--) {
			int l = 0, r = i - 1;
			while (l < r) {

				if (arr[i] == arr[l] + arr[r]) {
					System.out.println("Pythagorean  " + arr[i] + ", " + arr[l] + ", " + arr[r]);
					return true;
				}

				if (arr[l] + arr[r] < arr[i])
					l++;
				else
					r--;
			}

		}

		return false;
	}

}
