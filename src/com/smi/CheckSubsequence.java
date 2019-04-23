package com.smi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckSubsequence {

	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int t = 0; t < testCases; t++) {
			String strH[] = bufferedReader.readLine().trim().split(" ");
			String key = strH[0];
			String target = strH[1];
			int p1 = 0;
			int p2 = 0;
			if (key.length() > target.length()) {
				System.out.println("No");
				continue;
			}
			while (p1 < key.length() && p2 < target.length()) {
				if (key.charAt(p1) == target.charAt(p2)) {
					p1++;
					p2++;
				} else {
					p2++;
				}
			}
			if (p1 == key.length()) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}

		}
	}
}
