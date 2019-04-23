package com.smi;

import java.util.Scanner;
import java.util.Stack;

public class ReverseTheSentence {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int testCases = Integer.parseInt(scanner.nextLine().trim());
		for (int t = 0; t < testCases; t++) {
			String input[] = scanner.nextLine().trim().split(" ");
			Stack<String> items = new Stack<>();
			for (String item : input) {
				items.push(item);
			}
			while (!items.isEmpty()) {
				String pop = items.pop();
				if (items.isEmpty()) {
					System.out.print(pop);
				} else {
					System.out.print(pop + " ");
				}
			}
			System.out.println();
		}
	}

}
