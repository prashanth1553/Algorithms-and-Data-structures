package com.miscellaneous;

import java.util.Arrays;

public class NutsAndBolts {

	public void matchPairs(char nuts[], char bolts[]) {
		matchPairs(nuts, bolts, 0, nuts.length - 1);
	}

	private void matchPairs(char nuts[], char bolts[], int low, int high) {

		if (high <= low) {

			return;
		}
		int partition = partition(nuts, low, high, bolts[low]);
		partition(bolts, low, high, nuts[partition]);
		matchPairs(nuts, bolts, low, partition - 1);
		matchPairs(nuts, bolts, partition + 1, high);

	}

	private int partition(char arr[], int low, int high, char pivot) {

		int i = low, j = high + 1;
		while (true) {

			while (arr[++i] <= pivot) {
				if (i == high) {
					break;
				}
				if (pivot == arr[i]) {
					exchange(i, low, arr);
					--i;
				}

			}
			while (pivot <= arr[--j]) {

				if (j == low) {
					break;
				}
				if (pivot == arr[j]) {
					exchange(j, low, arr);
					++j;
				}
			}
			if (i >= j) {
				break;
			}
			exchange(i, j, arr);

		}
		exchange(low, j, arr);

		return j;
	}

	private void exchange(int i, int j, char arr[]) {
		char temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

	public static void main(String args[]) {
		char nuts[] = { '@', '-', '^', '&', '$', '%', };
		char bolts[] = { '$', '%', '^', '@', '&', '-' };
		NutsAndBolts obj = new NutsAndBolts();
		obj.matchPairs(nuts, bolts, 0, nuts.length - 1);

		System.out.println(Arrays.toString(nuts));
		System.out.println(Arrays.toString(bolts));

	}
}
