package com.smi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

import com.datastructures.LinkedList;

public class MakeMyTripQ1 {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int activeInactive[] = new int[8];
		for (int i = 0; i < 8; i++) {
			activeInactive[i] = scanner.nextInt();
		}
		int numberOfDays = scanner.nextInt();
		int left, right, previousState = 0;
		for (int i = 0; i < numberOfDays; i++) {
			for (int j = 0; j < 8; j++) {
				left = j == 0 ? 0 : previousState;
				right = j == (8 - 1) ? 0 : activeInactive[j + 1];
				previousState = activeInactive[j];
				if (left == right) {
					activeInactive[j] = 0;
				} else {
					activeInactive[j] = 1;
				}

			}
			previousState = 0;
		}
		System.out.println(Arrays.toString(activeInactive));
		
	}

	////////////////

	static Map<Integer, Integer> map = new HashMap<>();
	static String res = "";

	static void insert(int i, int value) {
		Integer val = map.get(i);
		if (val != null) {
			map.put(i, val + value);
		} else {
			map.put(i, value);
		}
	}

	static void get(int r1, int r2) {
		int s = 0;
		for (int i = r1; i <= r2; i++) {
			Integer val = map.get(i);
			if (val != null) {
				s += val;
			}
		}
		res += s + " ";
	}
	
	public static void main1(String as[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine().split(" ")[1]);
		res = "";
		for (int t = 0; t < T; t++) {

			String[] input = br.readLine().split(" ");

			if (Integer.parseInt(input[0]) == 1) {
				insert(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
			} else {
				get(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
			}
			bw.write(Arrays.toString(res.split(" ")));
			bw.write("\n");
		}
		bw.flush();
	}
}
