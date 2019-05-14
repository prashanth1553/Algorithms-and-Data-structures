package com.smi.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MaximumNonAdjacentSubsequenceSum {

	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int t = 0; t < testCases; t++) {
			int ans = Integer.MIN_VALUE;
			int N = Integer.parseInt(bufferedReader.readLine().trim());
			String input[] = bufferedReader.readLine().trim().split(" ");
			int a = Integer.parseInt(input[0]);
			if (N == 1) {
				writer.write("" + a);
				continue;
			}
			int b = Integer.parseInt(input[1]);
			if (N == 2) {
				writer.write("" + Math.max(a, b));
				continue;
			}
			ans = Math.max(a, b);
			for (int i = 2; i < N; i++) {
				int c = Math.max(a + Integer.parseInt(input[i]), b);
				int temp = a;
				a = Math.max(a, b);
				b = Math.max(temp + Integer.parseInt(input[i]), Integer.parseInt(input[i]));
				ans = Math.max(ans, c);
				ans = Math.max(ans, Integer.parseInt(input[i]));
			}
			writer.write("" + ans);
			writer.newLine();

		}

		writer.flush();
	}
	
	
}
