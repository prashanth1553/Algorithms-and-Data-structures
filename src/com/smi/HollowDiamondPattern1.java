package com.smi;

public class HollowDiamondPattern1 {

	public static void main(String args[]) {
		int n = 7;
		int mid = n / 2;
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n; j++) {
				if (Math.abs(i - j) == mid || i + j == mid) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}

			}
			System.out.println();
		}
		for (int i = 0; i <= n / 2; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j || (n - 1 - i) == j) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}

			}
			System.out.println();
		}

	}
}
