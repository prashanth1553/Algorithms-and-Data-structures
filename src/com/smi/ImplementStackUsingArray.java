package com.smi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ImplementStackUsingArray {

	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	private static int items[];
	private static int size = 0;

	public static void main(String[] args) throws IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		items = new int[testCases];
		for (int t = 0; t < testCases; t++) {
			String op[] = bufferedReader.readLine().trim().split(" ");
			if (op.length == 2) {
				push(Integer.parseInt(op[1]));
			} else {
				if (isEmpty()) {
					System.out.println("Empty");
				} else {
					System.out.println(pop());
				}
			}

		}

	}

	private static void push(int x) {
		items[size++] = x;
	}

	private static int pop() {
		return items[--size];
	}

	private static boolean isEmpty() {
		return size == 0;
	}

}
