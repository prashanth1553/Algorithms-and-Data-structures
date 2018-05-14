package com.graph;

public class KosarajuSharirSCC {

	private boolean[] marked;
	int[] id;
	private int count;

	public KosarajuSharirSCC(Digraph G) {
		marked = new boolean[G.V()];
		id = new int[G.V()];
		DepthFirstOrder dfo = new DepthFirstOrder(G.reverse());
		for (int v : dfo.reversePost()) {
			if (!marked[v]) {
				dfs(G, v);
				count++;
			}
		}
	}

	private void dfs(Digraph G, int v) {
		marked[v] = true;
		id[v] = count;
		for (int e : G.adjList(v)) {
			if (!marked[e]) {
				dfs(G, e);
			}
		}
	}

	public boolean stronglyConnected(int v, int w) {
		return id[v] == id[w];
	}
}
