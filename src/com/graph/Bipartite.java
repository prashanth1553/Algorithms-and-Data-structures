package com.graph;

public class Bipartite {

	private boolean[] marked;
	private boolean[] color;
	boolean isBipartite;

	public Bipartite(Graph G) {
		marked = new boolean[G.V()];
		color = new boolean[G.V()];
		dfs(G, 0);

	}

	private void dfs(Graph G, int v) {
		marked[v] = true;
		for (int w : G.adjList(v)) {
			if (!marked[w]) {
				color[w] = !color[v];
				dfs(G, v);
			} else if (color[w] == color[v]) {
				isBipartite = false;
			}

		}

	}

}
