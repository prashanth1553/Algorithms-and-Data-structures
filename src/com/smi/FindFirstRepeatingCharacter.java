package com.smi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindFirstRepeatingCharacter {

	private final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String args[]) throws NumberFormatException, IOException {

		int testCases = Integer.parseInt(reader.readLine());
		for (int t = 0; t < testCases; t++) {
			String input = reader.readLine();
			int found[] = new int[26];
			for (char C : input.toCharArray()) {
				found[C - 'a']++;
			}
			String result = ".";
			for (char C : input.toCharArray()) {
				if (found[C - 'a'] > 1) {
					result = "" + C;
					break;
				}

			}
			System.out.println(result);
		}

	}

}
