package com.smi;

import java.util.Scanner;

public class RightAngledTrianglePattern {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String args[]) {
		int t = Integer.parseInt(scanner.nextLine().trim());
		for (int i = 0; i < t; i++) {
			int star = Integer.parseInt(scanner.nextLine().trim());
			System.out.println("Case #"+(i+1)+":");
			for (int j = 0; j < star; j++) {
				for (int k = 0; k < star; k++) {
					if (k >= (star-1) - j) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}

				}
				System.out.println();
			}

		}

	}
}
