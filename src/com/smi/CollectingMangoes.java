package com.smi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class CollectingMangoes {

	private final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	private int items[];

	private int index;

	public CollectingMangoes(int N) {
		items = new int[N <= 8 ? 8 : N / 4];
	}

	public static void main(String args[]) throws NumberFormatException, IOException {

		int testCases = Integer.parseInt(reader.readLine());
		for (int t = 0; t < testCases; t++) {
			System.out.println("Case " + (t + 1) + ":");
			int N = Integer.parseInt(reader.readLine());
			CollectingMangoes mangoes = new CollectingMangoes(N);
			CollectingMangoes max = new CollectingMangoes(N);
			for (int i = 0; i < N; i++) {
				String op[] = reader.readLine().trim().split(" ");
				if (op.length == 1) {
					if (op[0].equals("Q")) {
						if (max.isEmpty()) {
							System.out.println("Empty");
						} else {
							System.out.println(max.peek());
						}
					} else {
						if (!mangoes.isEmpty()) {
							mangoes.pop();
							max.pop();
						}
					}
				} else {
					int mango = Integer.parseInt(op[1]);
					if (max.isEmpty() || mango > max.peek()) {
						max.push(mango);
					} else {
						max.push(max.peek());
					}
					mangoes.push(mango);
				}
			}
		}
	}

	private void resize(int size) {
		int array[] = new int[size];
		for (int i = 0; i < index; i++) {
			array[i] = items[i];
		}
		items = array;
	}

	private void push(int item) {
		if (index == items.length) {
			resize(2 * index);
		}
		items[index++] = item;
	}

	private boolean isEmpty() {
		return index == 0;
	}

	private int pop() {
		return items[--index];
	}

	private int peek() {
		return items[index - 1];
	}

}
