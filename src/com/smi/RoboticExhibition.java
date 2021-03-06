package com.smi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RoboticExhibition {

	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int t = 0; t < testCases; t++) {
			int n = Integer.parseInt(bufferedReader.readLine().trim());
			String arrayS[] = bufferedReader.readLine().trim().split(" ");
			int robots[] = new int[n];
			for (int i = 0; i < n; i++) {
				robots[i] = Integer.parseInt(arrayS[i]);
			}
			Arrays.sort(robots);
			int result = 1;
			for (int i = 0; i < n && robots[i] <= result; i++) {
				result += robots[i];
			}

			System.out.println(result);

		}
	}

}
