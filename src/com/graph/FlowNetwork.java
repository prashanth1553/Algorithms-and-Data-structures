package com.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlowNetwork {

	private final int v;
	private List<FlowEdge>[] adj;

	public FlowNetwork(int v) {
		this.v = v;
		adj = (ArrayList<FlowEdge>[]) new ArrayList[v];
		for (int i = 0; i < v; i++) {

			adj[i] = new ArrayList<>();
		}

	}

	public void addEdge(FlowEdge e) {

		int v = e.from();
		int w = e.to();
		adj[v].add(e);
		adj[w].add(e);

	}

	public Iterator<FlowEdge> adj(int v) {
		return adj[v].listIterator();
	}

	public List<FlowEdge> adjList(int v) {
		return adj[v];
	}

	public int V() {
		return v;
	}

}
