package com.graph;

import java.util.Stack;

import com.datastructures.LinkedList;

public class UndirectedCycle {

	private Graph g;
	private Stack<Integer> cycle = new Stack<>();
	private boolean marked[];
	private int[] edgeTo;

	public UndirectedCycle(Graph g) {
		this.g = g;
		marked = new boolean[g.V()];
		edgeTo = new int[g.V()];
		for (int i = 0; i < g.V(); i++) {

			if (!marked[i]) {

				dfs(g, -1, i);
			}
		}

	}

	private void dfs(Graph g, int u, int v) {
		marked[v] = true;
		edgeTo[v] = u;
		for (int w : g.adjList(v)) {
			if (!marked[w]) {
				dfs(g, v, w);
			} else if (w != u) {
				for (int i = v; i != w; i = edgeTo[i]) {
					cycle.add(i);
				}

			}
		}

	}

}
