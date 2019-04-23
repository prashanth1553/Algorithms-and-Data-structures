package com.smi;

import java.util.Arrays;
import java.util.Scanner;

public class PowerGame {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int testCases = Integer.parseInt(scanner.nextLine().trim());
		for (int t = 0; t < testCases; t++) {
			int N = Integer.parseInt(scanner.nextLine().trim());
			String a[] = scanner.nextLine().split(" ");
			int teamA[] = new int[N];
			for (int r = 0; r < N; r++) {
				teamA[r] = Integer.parseInt(a[r]);
			}

			String b[] = scanner.nextLine().split(" ");
			int teamB[] = new int[N];
			for (int r = 0; r < N; r++) {
				teamB[r] = Integer.parseInt(b[r]);
			}
			Arrays.sort(teamA);
			Arrays.sort(teamB);
			int p1 = 0, p2 = 0;
			int c = 0;
			while (p1 < N && p2 < N) {
				if (teamA[p1] > teamB[p2]) {
					c++;
					p1++;
					p2++;
				} else if (teamA[p1] == teamB[p2]) {
					p1++;
				} else {
					p1++;
				}

			}
			System.out.println(c);

		}
	}
}
