package com.smi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SquareFun {

	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int t = 0; t < testCases; t++) {
			String s[] = bufferedReader.readLine().trim().split(" ");
			long a = Long.parseLong(s[0]);
			long b = Long.parseLong(s[1]);
			long as = new Double(Math.sqrt(a)).longValue();
			if (as * as != a) {
				as++;
			}
			long bs = new Double(Math.sqrt(b)).longValue();
			if (a == b) {
				if (as * as == a) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
			}else {
				System.out.println(bs - as + 1);
			}
			

		}
	}
}
