package com.smi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class WindowMaximum {

	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int t = 0; t < testCases; t++) {
			String windowAndItemSize[] = bufferedReader.readLine().trim().split(" ");
			int size = Integer.parseInt(windowAndItemSize[0]);
			int k = Integer.parseInt(windowAndItemSize[1]);
			String itemsS[] = bufferedReader.readLine().trim().split(" ");
			int itemsI[] = new int[size];
			for (int i = 0; i < size; i++) {
				itemsI[i] = Integer.parseInt(itemsS[i]);
			}
			int sum = 0;
			Deque<Integer> deque = new ArrayDeque<>(k);

			for (int i = 0; i < k; i++) {
				while (!deque.isEmpty() && itemsI[deque.peekLast()] <= itemsI[i]) {
					deque.removeLast();
				}
				deque.addLast(i);
			}

			if (size == 1) {
				System.out.println(itemsI[deque.peekLast()]);
				continue;
			}
			sum += itemsI[deque.peekFirst()];
			for (int i = 1; i <= size - k; i++) {
				if (deque.peekFirst() == i - 1) {
					deque.removeFirst();
				}
				while (!deque.isEmpty() && itemsI[deque.peekLast()] <= itemsI[i + k - 1]) {
					deque.removeLast();
				}
				deque.addLast(i + k - 1);
				sum += itemsI[deque.peekFirst()];

			}
			System.out.println(sum);

		}
	}

}
