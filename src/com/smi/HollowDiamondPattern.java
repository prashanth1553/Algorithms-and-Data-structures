package com.smi;

import java.util.Scanner;

public class HollowDiamondPattern {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String args[]) {
		int t = Integer.parseInt(scanner.nextLine().trim());
		for (int i = 0; i < t; i++) {
			int star = Integer.parseInt(scanner.nextLine().trim());
			System.out.println("Case #" + (i + 1) + ":");
			int halfStar = (star / 2) + 1;
			for (int j = 1; j <= halfStar; j++) {
				for (int k = 1; k <= star; k++) {
					if (halfStar - j + 1 == k || halfStar + j - 1 == k) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}

				}
				System.out.println();
			}
			for (int j = halfStar + 1; j <= star; j++) {
				for (int k = 1; k <= star; k++) {
					if (j - halfStar + 1 == k || halfStar + star - j == k) {
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
