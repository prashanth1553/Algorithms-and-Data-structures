package com.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Digraph {
	private int V;
	private List<Integer>[] adj;

	public Digraph(int V) {
		this.V = V;
		adj = (ArrayList<Integer>[]) new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<>();
		}
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
	}

	public Iterator<Integer> adj(int v) {
		return adj[v].listIterator();
	}

	public List<Integer> adjList(int v) {
		return adj[v];
	}

	public int V() {
		return V;
	}

	int E() {
		int edges = 0;
		for (int i = 0; i < adj.length; i++) {
			edges += adj[i].size();
		}
		return edges / 2;
	}
	
	public Digraph reverse() {
		Digraph reverse = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adjList(v)) {
                reverse.addEdge(w, v);
            }
        }
        return reverse;
    }
}
