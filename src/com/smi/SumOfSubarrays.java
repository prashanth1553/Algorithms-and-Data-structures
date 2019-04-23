package com.smi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfSubarrays {

	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(bufferedReader.readLine().trim());
		String array[] = bufferedReader.readLine().trim().split(" ");
		long rectArea[] = new long[N];
		rectArea[0] = Long.parseLong(array[0]);
		for (int i = 1; i < N; i++) {
			rectArea[i] = rectArea[i - 1] + Long.parseLong(array[i]);
		}
		int Q = Integer.parseInt(bufferedReader.readLine().trim());
		while (Q != 0) {
			String qarray[] = bufferedReader.readLine().trim().split(" ");
			int i = Integer.parseInt(qarray[0]);
			int j = Integer.parseInt(qarray[1]);
			if (i == j) {
				System.out.println(0);
			} else if (i == 0) {
				System.out.println(rectArea[j]);
			} else {
				System.out.println(rectArea[j] - rectArea[i - 1]);
			}
			Q--;
		}
	}
}
