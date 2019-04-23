package com.smi;

import java.util.Scanner;

public class SumOfArrayElements {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main1(String[] args) {
		int t = Integer.parseInt(scanner.nextLine().trim());
		for (int i = 0; i < t; i++) {
			int size = Integer.parseInt(scanner.nextLine().trim());
			long sum = 0;
			String[] elements = scanner.nextLine().split(" ");
			for (int arr = 0; arr < size; arr++) {
				sum += Integer.parseInt(elements[arr]);
			}
			System.out.println(sum);

		}
	}
	
	public static void main(String[] args) {
		int t = 1;
		for (int i = 0; i < t; i++) {
			int size = 1000;
			long sum = 0;
			for (int arr = 0; arr < size; arr++) {
				sum += Long.parseLong("1000000000000000");
			}
			System.out.println(sum);

		}
	}
}
