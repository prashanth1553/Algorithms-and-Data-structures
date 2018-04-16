package com.src.dynamicconnectivity;

/* joing small tree under large trees */
public class QuickUnionUFWeighted {

	private int[] id;
	private int[] size;

	public QuickUnionUFWeighted(int n) {
		id = new int[n];
		size = new int[n];
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
		// joining small tree under large trees time complexity reduces logn as depth increase tree size doubles
		if (size[pr] > size[qr]) {
			id[qr] = pr;
			size[pr] = size[pr]+size[qr];
		} else {
			id[pr] = qr;
			size[qr] = size[pr]+size[qr];
		}

	}

	private int root(int i) {
		while (id[i] != i) {
			i = id[i];
		}
		return i;
	}

	// making every other node in path point to its grand parent
	private int rootWithPathCompression(int i) {
		while (id[i] != i) {
			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}
}
