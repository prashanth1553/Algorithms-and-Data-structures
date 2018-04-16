package com.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LazyPrimMST {

	boolean[] marked;
	List<Edge> mst;
	double weigth;

	public LazyPrimMST(EdgeWeightedGraph G) {
		mst = new ArrayList<>();
		marked = new boolean[G.V()];
		PriorityQueue<Edge> edges = new PriorityQueue<>();
		visit(G, 0, edges);
		while (!edges.isEmpty() && mst.size() < G.V() - 1) {
			Edge e = edges.poll();
			int v = e.either(), w = e.other(v);
			if (marked[v] && marked[w]) {
				continue;
			}
			mst.add(e);
			if (!marked[v]) {
				visit(G, v, edges);
			}
			if (!marked[w]) {
				visit(G, w, edges);
			}

		}

	}

	public void visit(EdgeWeightedGraph G, int v, PriorityQueue<Edge> edges) {
		marked[v] = true;
		for (Edge e : G.adjList(v)) {
			if (!marked[e.other(v)]) {
				edges.add(e);
			}
		}
	}
}
