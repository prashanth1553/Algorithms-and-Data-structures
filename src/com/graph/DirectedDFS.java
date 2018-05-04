package com.graph;

public class DirectedDFS {

	private boolean[] marked;
	private int count;

	public DirectedDFS(Digraph G, int s) {
		marked = new boolean[G.V()];
		dfs(G, s);
	}

	public DirectedDFS(Digraph G, Iterable<Integer> sources) {
		marked = new boolean[G.V()];
		for (int v : sources) {
			if (!marked[v])
				dfs(G, v);
		}
	}

	private void dfs(Digraph G, int s) {
		count++;
		marked[s] = true;
		for (int v : G.adjList(s)) {
			if (!marked[v]) {
				dfs(G, v);
			}

		}

	}

	public int count() {
		return count;
	}

	public boolean marked(int v) {
		return marked[v];
	}

}
