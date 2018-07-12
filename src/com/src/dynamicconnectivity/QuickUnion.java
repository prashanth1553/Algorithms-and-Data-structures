package com.src.dynamicconnectivity;

public class QuickUnion {

	private int[] id;

	public QuickUnion(int n) {
		id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}

	public boolean isConnected(int p, int q) {
		return root(p) == root(q);
	}

	public void union(int p, int q) {
		int pr = root(p);
		int qr = root(q);
		id[pr] = qr;
	}

	private int root(int i) {
		while (id[i] != i) {
			i = id[i];
		}
		return i;
	}
}
