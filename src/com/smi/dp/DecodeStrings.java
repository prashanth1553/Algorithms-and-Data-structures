package com.smi.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DecodeStrings {

	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	private static final int mod = (int) 1e9 + 7;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int t = 0; t < testCases; t++) {
			int N = Integer.parseInt(bufferedReader.readLine().trim());
			String input = bufferedReader.readLine().trim();
			long sum[] = new long[N];
			sum[0] = 1l;
			int e = getIfromC(input.charAt(1));
			int p = getIfromC(input.charAt(0));
			if (p == 1 || (p == 2 && e <= 5)) {
				sum[1] = 2l;
			} else {
				sum[1] = 1l;
			}

			for (int i = 2; i < input.length(); i++) {
				e = getIfromC(input.charAt(i));
				p = getIfromC(input.charAt(i - 1));
				long current = sum[i - 1];
				if (p == 1 || (p == 2 && e <= 5)) {
					current = (current + sum[i - 2]) % mod;
				}
				sum[i] = current;
			}

			writer.write("" + sum[N - 1]);
			writer.newLine();
		}

		writer.flush();
	}

	private static int getIfromC(char c) {
		return Integer.parseInt("" + c);
	}

}
