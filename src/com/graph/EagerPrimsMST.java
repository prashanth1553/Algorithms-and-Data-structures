package com.graph;

import com.datastructures.IndexMinPQ;

public class EagerPrimsMST {

	private Edge edgeTo[];
	private IndexMinPQ<Double> pq;
	private boolean marked[];
	private double distanceTo[];

	public EagerPrimsMST(EdgeWeightedGraph G) {
		edgeTo = new Edge[G.V()];
		pq = new IndexMinPQ<>(G.V());
		marked = new boolean[G.V()];
		distanceTo = new double[G.V()];
		for (int i = 0; i < G.V(); i++) {
			distanceTo[i] = Double.POSITIVE_INFINITY;
		}

		for (int i = 0; i < G.V(); i++) {
			if (!marked[i]) {
				prim(G, i);
			}

		}

	}

	private void prim(EdgeWeightedGraph G, int v) {

		distanceTo[v] = 0;
		visit(G, 0);
		while (!pq.isEmpty()) {
			int i = pq.delMin();
			visit(G, i);
		}
	}

	private void visit(EdgeWeightedGraph G, int v) {
		marked[v] = true;
		for (Edge e : G.adjList(v)) {
			int w = e.other(v);
			if (!marked[w]) {
				if (distanceTo[w] > e.weigth) {
					edgeTo[w] = e;
					distanceTo[w] = e.weigth;
					if (!pq.contains(w)) {
						pq.insert(w, e.weigth);
					} else {
						pq.decreaseKey(w, e.weigth);
					}

				}

			}

		}

	}

}
