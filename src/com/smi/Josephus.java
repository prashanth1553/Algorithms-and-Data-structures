package com.smi;

public class Josephus {
	// 1 2 3 4 5 6 7 8 9

	private int josephus(int n, int k) {
		if (n == 0) {
			return 1;
		}
		return (josephus(n - 1, k) + k) % n;

	}
}
