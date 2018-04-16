package com.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EdgeWeightedGraph {

	private int V;
	private List<Edge>[] adj;

	public EdgeWeightedGraph(int V) {
		if (V < 0)
			throw new IllegalArgumentException("Number of vertices must be nonnegative");
		this.V = V;
		adj = (ArrayList<Edge>[]) new ArrayList[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new ArrayList<Edge>();
		}
	}
	
	int V() {
		return V;
	}

	public void addEdge(Edge e) {
		int v = e.either();
		int w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
	}

	public Iterator<Edge> adj(int v) {
		return adj[v].listIterator();
	}

	public List<Edge> adjList(int v) {
		return adj[v];
	}

	public Iterable<Edge> edges() {
		List<Edge> list = new ArrayList<Edge>();
		for (int v = 0; v < V; v++) {
			int selfLoops = 0;
			for (Edge e : adjList(v)) {
				if (e.other(v) > v) {
					list.add(e);
				}
				// add only one copy of each self loop (self loops will be
				// consecutive)
				else if (e.other(v) == v) {
					if (selfLoops % 2 == 0)
						list.add(e);
					selfLoops++;
				}
			}
		}
		return list;
	}
}
