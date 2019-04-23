package com.smi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagrams {

	private final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String args[]) throws NumberFormatException, IOException {

		int testCases = Integer.parseInt(reader.readLine());
		for (int t = 0; t < testCases; t++) {
			String input[] = reader.readLine().trim().split(" ");
			String str1 = input[0];
			String str2 = input[1];
			if (str1.length() != str2.length()) {
				System.out.println("False");
				continue;
			}
			String result = "True";
			int s1[] = new int[26];
			int s2[] = new int[26];
			char C = ' ';
			for (int i = 0; i < str1.length(); i++) {
				C = str1.charAt(i);
				s1[C - 'a']++;
				C = str2.charAt(i);
				s2[C - 'a']++;
			}
			for (int i = 0; i < 26; i++) {
				if (s1[i] != s2[i]) {
					result = "False";
					break;
				}
			}
			System.out.println(result);
		}

	}
}
