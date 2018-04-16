package com.src.dynamicconnectivity;

public class Perculates {

	private int[] id;
	private int[] size;
	private int gridSize;

	public Perculates(int n) {
		gridSize = n;
		id = new int[n * n + 2];
		size = new int[n * n + 2];
		int total = n * n;
		for (int i = 0; i < total; i++) {
			id[i] = i;
		}
		id[n * n] = n * n; // top virtual spot
		id[n * n + 1] = n * n + 1; // bottom virtual spot
		connectTopVirtualSpot();
		connectBottomVirtualSpot();
		createPredefinedGrid();
	}

	public boolean isConnected(int p, int q) {
		return root(p) == root(q);
	}

	public void union(int p, int q) {
		int pr = root(p);
		int qr = root(q);
		// joining small tree under large trees time complexity reduces logn as
		// depth increase tree size doubles
		if (size[pr] > size[qr]) {
			id[qr] = pr;
			size[pr] = size[pr] + size[qr];
		} else {
			id[pr] = qr;
			size[qr] = size[pr] + size[qr];
		}

	}

	// making every other node in path point to its grand parent
	private int root(int i) {
		while (id[i] != i) {
			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}

	private void connectTopVirtualSpot() {
		for (int i = 0; i < gridSize; i++) {
			union(i, gridSize * gridSize);
		}
	}

	private void connectBottomVirtualSpot() {
		for (int i = gridSize * gridSize - gridSize; i < gridSize * gridSize; i++) {
			union(i, gridSize * gridSize + 1);
		}
	}

	private void createPredefinedGrid() {
		union(0, 1);
		union(3, 8);
		union(8, 13);
		union(13, 14);
		union(15, 20);
		union(20, 21);
		union(23, 24);
	}

	public static void main(String[] args) {
		int size = 5;
		Perculates obj = new Perculates(size);
		System.out.println("top parent conection check" + obj.isConnected(13, size * size));
		System.out.println("bottom parent conection check" + obj.isConnected(size * size - 1, size * size + 1));
//		obj.openAHole(16);
		obj.openAHole(12);
//		obj.openAHole(18);
		//obj.union(19, 14);
		//obj.union(19, 24);
		System.out.println("is system perculates" + obj.isConnected(size * size, size * size + 1));
	}

	private void openAHole(int open) {
		// opening the left
		if ((open%gridSize)>0) {
			union(open - 1, open);
		}
		// opening the right
		if ((open%gridSize)<(gridSize-1)) {
			union(open, open + 1);
		}

		// opening the top
		if ((open - gridSize) >= 0 ) {
			union(open, open - gridSize);
		}

		// opening the bottom
		if ((open + gridSize) < gridSize*gridSize) {
			union(open, open +gridSize);
		}

	}
}
