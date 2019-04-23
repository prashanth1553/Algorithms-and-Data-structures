package com.smi;

import java.util.Scanner;

public class TowerOfHanoi {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int testCases = Integer.parseInt(scanner.nextLine().trim());
		for (int t = 0; t < testCases; t++) {
			int number = Integer.parseInt(scanner.nextLine());
			System.out.println(((int) Math.pow(2, number) - 1));
			hanoi(number, 'A', 'B', 'C');
		}
	}

	public static void hanoi(int tower, char source, char temp, char dest) {
		if (tower == 0) {
			return;
		}
		hanoi(tower - 1, source, dest, temp);
		System.out.println("Move " + tower + " from " + source + " to " + dest);
		hanoi(tower - 1, temp, source, dest);
	}
}
