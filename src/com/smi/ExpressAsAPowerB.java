package com.smi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExpressAsAPowerB {

	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int t = 0; t < testCases; t++) {
			int key = Integer.parseInt(bufferedReader.readLine().trim());
			if (key == 1) {
				System.out.println("No");
				continue;
			}
			double logK = Math.log((double) key);
			boolean isFound = false;
			for (int i = 2; i * i <= Math.sqrt(key); i++) {
				Double log = logK / Math.log((double) i);
				if (log - log.intValue() < 0.00000001) {
					isFound = true;
					break;
				}

			}
			if (isFound) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}

}
