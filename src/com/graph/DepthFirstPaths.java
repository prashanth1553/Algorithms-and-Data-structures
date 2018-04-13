package com.graph;

import java.util.Iterator;
import java.util.Stack;

public class DepthFirstPaths {

	private boolean marked[];
	private int edgeTo[];
	int source;

	public void depthFirstSearch(int source, Graph graph) {
		this.source = source;
		marked = new boolean[graph.V()];
		edgeTo = new int[graph.V()];
		dfs(source, graph);
	}

	private void dfs(int v, Graph graph) {
		marked[v] = true;
		for (int adjacent : graph.adjList(v)) {
			if (!marked[adjacent]) {
				edgeTo[adjacent] = v;
				dfs(adjacent, graph);
			}
		}
	}

	boolean hasPathTo(int v) {
		return marked[v];
	}

	public Iterator<Integer> pathTo(int v) {
		if (!marked[v]) {
			return null;
		}
		Stack<Integer> path = new Stack<>();
		for (int i = v; i != source; i = edgeTo[i]) {
			path.add(i);
		}
		path.add(source);
		return path.iterator();

	}

}
