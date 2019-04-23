package com.smi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConvertingAnagrams {

	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int t = 0; t < testCases; t++) {
			String strH[] = bufferedReader.readLine().trim().split(" ");
			String str1 = strH[0];
			String str2 = strH[1];
			int maxL = Math.max(str1.length(), str2.length());
			int c1[] = new int[26];
			int c2[] = new int[26];
			for (int i = 0; i < maxL; i++) {
				if (i < str1.length()) {
					c1[(str1.charAt(i) - 'a')]++;
				}
				if (i < str2.length()) {
					c2[(str2.charAt(i) - 'a')]++;
				}
			}
			int diff = 0;
			for (int i = 0; i < 26; i++) {
				diff += Math.abs(c1[i] - c2[i]);
			}
			System.out.println(diff);
		}
	}
}
