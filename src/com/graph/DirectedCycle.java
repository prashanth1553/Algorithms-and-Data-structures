package com.graph;

public class DirectedCycle {

	private boolean[] marked;
	private boolean hasCycle;

	public DirectedCycle(Graph G) {
		marked = new boolean[G.V()];

		for (int s = 0; s < G.V(); s++) {
			dfs(G, s, s);
		}
	}

	private void dfs(Graph G, int v, int u) {

		marked[v] = true;
		for (int w : G.adjList(v)) {
			if (!marked[w]) {
				dfs(G, w, v);
			} else if (w != u) {
				hasCycle = true;
			}

		}

	}
}
