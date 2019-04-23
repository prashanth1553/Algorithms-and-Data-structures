package com.smi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameOfLetters {

	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int t = 0; t < testCases; t++) {
			int count[] = new int[26];
			String input = bufferedReader.readLine().trim();
			for (char c : input.toCharArray()) {
				count[c - 'a']++;
			}
			int xor = 0;
			for (int i = 0; i < 26; i++) {
				xor = xor ^ count[i];
			}
			if (xor == 0) {
				System.out.println("Banta");
			} else {
				System.out.println("Santa");
			}
		}
	}
}
