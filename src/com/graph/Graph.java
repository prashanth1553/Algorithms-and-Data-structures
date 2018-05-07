package com.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Graph implements Iterable<Number> {

	private int V;
	private int E;
	private List<Integer>[] adj;

	public Graph(int V) {
		this.V = V;
		adj = (ArrayList<Integer>[]) new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<>();
		}
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}

	public Iterator<Integer> adj(int v) {
		return adj[v].listIterator();
	}

	public List<Integer> adjList(int v) {
		return adj[v];
	}

	int V() {
		return V;
	}

	int E() {
		int edges = 0;
		for (int i = 0; i < adj.length; i++) {
			edges += adj[i].size();
		}
		return edges / 2;
	}

	public int degree(int v) {
		return adj[v].size();
	}

	public int maxDegree() {
		int max = 0;
		for (int i = 0; i < V; i++) {
			int degree = degree(i);
			if (degree > max) {
				max = degree;
			}
		}
		return max;
	}

	public double avgDegree() {
		return 2 * E() / V();
	}

	@Override
	public Iterator<Number> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
