package com.smi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencySort {

	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int t = 0; t < testCases; t++) {
			int size = Integer.parseInt(bufferedReader.readLine().trim());
			String items[] = bufferedReader.readLine().trim().split(" ");
			int[] array = new int[size];
			Map<Integer, Integer> frequency = new HashMap<>(size);
			for (int i = 0; i < size; i++) {
				int element = Integer.parseInt(items[i]);
				array[i] = element;
				if (frequency.containsKey(element)) {
					frequency.put(element, frequency.get(element) + 1);
				} else {
					frequency.put(element, 1);
				}
			}
			sort(0, size - 1, array, frequency);
			String result = Arrays.stream(array).mapToObj(i -> String.valueOf(i)).collect(Collectors.joining(" "));

			System.out.println(result);

		}
	}

	public static void sort(int lo, int hi, int[] array, Map<Integer, Integer> frequency) {
		if (lo >= hi) {
			return;
		}
		int partition = partition(lo, hi, array, frequency);
		sort(lo, partition - 1, array, frequency);
		sort(partition + 1, hi, array, frequency);

	}

	private static int partition(int lo, int hi, int[] array, Map<Integer, Integer> frequency) {
		int pivot = lo;
		int i = lo + 1, j = hi;
		while (true) {
			while (i < hi && less(i, pivot, array, frequency)) {
				i++;
			}

			while (j > lo && less(pivot, j, array, frequency)) {
				j--;
			}

			if (i < j) {
				swap(i++, j--, array);
			} else {
				break;
			}

		}
		swap(j, pivot, array);
		return j;

	}

	private static boolean less(int x, int y, int[] array, Map<Integer, Integer> frequency) {
		int xE = array[x];
		int yE = array[y];
		if (frequency.get(xE) == frequency.get(yE)) {
			return xE < yE;
		}
		return frequency.get(xE) < frequency.get(yE);
	}

	private static void swap(int x, int y, int[] array) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}
}
