package com.graph;

import java.util.ArrayList;
import java.util.List;

public class DirectedEdgeWeightedGraph {

	private List<DirectedEdge>[] adj;
	private int V;
	private int E;

	public DirectedEdgeWeightedGraph(int v) {
		V = v;
		adj = (ArrayList<DirectedEdge>[]) new ArrayList[V];
		for (int i = 0; i < V; i++) {

			adj[i] = new ArrayList<>();
		}

	}

	public void addEdge(DirectedEdge edge) {

		adj[edge.from()].add(edge);
		E++;
	}

	int V() {
		return V;
	}

	int E() {
		return E;
	}

	public List<DirectedEdge> adjList(int v) {
		return adj[v];
	}
}
