package com.smi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimizeAbsoluteDistance {

	public static int solve(List<Integer> A, List<Integer> B, List<Integer> C) {

		int p1 = 0, p2 = 0, p3 = 0;
		int ans = Integer.MIN_VALUE;

		while (p1 < A.size() && p2 < B.size() && p3 < C.size()) {
			int a = A.get(p1);
			System.out.println(p2);
			int b = B.get(p2);
			int c = C.get(p3);

			int max = a;
			if (b > max) {
				max = b;
			}
			if (c > max) {
				max = c;
			}

			int min = a;
			p1++;
			if (b < min) {
				min = b;
				p1--;
				p2++;
			}
			if (c < min) {
				min = c;
				p2--;
				p3++;
			}
			int cans = Math.abs(max - min);
			if (cans < ans) {
				ans = cans;
			}

		}
		return ans;
	}

	public static void main(String args[]) {
		Integer a[] = { 1, 4, 5, 8, 10 };
		Integer b[] = { 6, 9, 15 };
		Integer c[] = { 2, 3, 6, 6 };

		List<Integer> A = Arrays.asList(a);
		List<Integer> B = Arrays.asList(b);
		List<Integer> C = Arrays.asList(c);
		solve(A, B, C);
	}
}
