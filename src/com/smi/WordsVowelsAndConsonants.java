package com.smi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class WordsVowelsAndConsonants {

	private final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String args[]) throws NumberFormatException, IOException {

		int testCases = Integer.parseInt(reader.readLine());
		Set<Character> vowels = new HashSet<>();
		vowels.add('a');
		vowels.add('A');
		vowels.add('e');
		vowels.add('E');
		vowels.add('i');
		vowels.add('I');
		vowels.add('o');
		vowels.add('O');
		vowels.add('u');
		vowels.add('U');
		for (int t = 0; t < testCases; t++) {
			String input = reader.readLine();
			input = input.trim();
			int w = input.length() > 0 ? 1 : 0;
			int v = 0, c = 0;
			int currentIndex = 0;
			int lastSpace = -100;
			for (char C : input.toCharArray()) {
				if (" ".equals("" + C)) {
					if (currentIndex - 1 != lastSpace) {
						w++;
					}
					lastSpace = currentIndex;
				} else if (vowels.contains(C)) {
					v++;
				} else {
					c++;
				}
				currentIndex++;
			}
			System.out.println(w + " " + v + " " + c);
		}

	}
}
