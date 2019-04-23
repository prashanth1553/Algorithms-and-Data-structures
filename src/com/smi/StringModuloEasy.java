package com.smi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringModuloEasy {

	private final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String args[]) throws NumberFormatException, IOException {

		int testCases = Integer.parseInt(reader.readLine());
		for (int t = 0; t < testCases; t++) {
			String input[] = reader.readLine().trim().split(" ");
			String N = input[0];
			int D = Integer.parseInt(input[1]);
			int mod = 0;
			for (int i = 0; i < N.length(); i++) {
				mod = ((10 * mod) % D + (Integer.parseInt("" + N.charAt(i)))) % D;
			}
			System.out.println(mod);
		}
	}
}
