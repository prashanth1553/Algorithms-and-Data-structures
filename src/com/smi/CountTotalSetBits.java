package com.smi;

public class CountTotalSetBits {
	int mod = 1000000007;

	public int solve(int A) {
		int ans = 0;
		if (A == 0) {
			return 0;
		}
		int x = largestPowerOf2Inrange(A) % mod;
		ans = (x * ((1 << (x - 1)) % mod)) % mod;
		ans = (ans + (A - (1 << x) + 1) % mod) % mod;
		int rest = A - (1 << x);
		ans = (ans + solve(rest) % mod) % mod;
		return ans;
	}

	private int largestPowerOf2Inrange(int n) {
		int x = 0;
		while ((1 << x) <= n) {
			x++;
		}

		return x - 1;
	}
}
