package com.smi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CollectingWater {

	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int t = 0; t < testCases; t++) {
			int N = Integer.parseInt(bufferedReader.readLine().trim());
			String strH[] = bufferedReader.readLine().trim().split(" ");
			int heigth[] = new int[N];
			int rightMax[] = new int[N];
			heigth[N - 1] = Integer.parseInt(strH[N - 1]);
			rightMax[N - 1] = Integer.parseInt(strH[N - 1]);
			for (int i = N - 2; i >= 0; i--) {
				heigth[i] = Integer.parseInt(strH[i]);
				rightMax[i] = Math.max(heigth[i], rightMax[i + 1]);
			}
			int leftMax = heigth[0];
			int totalWater = 0;
			for (int i = 1; i < N - 1; i++) {
				leftMax = Math.max(leftMax, heigth[i]);
				int h = Math.min(leftMax, rightMax[i]);
				int each = h - heigth[i];
				System.out.println("Water accumulated on top of Building-" + (i + 1) + ":" + each);
				totalWater += each;
			}
			System.out.println(totalWater);
		}
	}
}
