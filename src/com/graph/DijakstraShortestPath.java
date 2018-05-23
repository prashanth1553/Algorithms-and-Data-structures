package com.graph;

import java.util.Stack;

import com.datastructures.IndexMinPQ;

public class DijakstraShortestPath {

	double distanceTo[];
	DirectedEdge edgeTo[];

	IndexMinPQ<Double> pq;

	public DijakstraShortestPath(DirectedEdgeWeightedGraph G, int s) {

		distanceTo = new double[s];
		edgeTo = new DirectedEdge[s];

		for (int i = 0; i < G.V(); i++)
			distanceTo[i] = Double.MAX_VALUE;

		distanceTo[s] = 0;

		pq = new IndexMinPQ<>(G.V());
		pq.insert(s, 0.0);

		while (!pq.isEmpty()) {

			int v = pq.delMin();
			for (DirectedEdge edge : G.adjList(v)) {
				relax(edge);
			}

		}

	}

	public double distanceTo(int v) {
		return distanceTo(v);
	}

	public Iterable<DirectedEdge> pathTo(int v) {
		Stack<DirectedEdge> path = new Stack<>();
		for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
			path.add(e);
		}
		return path;

	}

	private void relax(DirectedEdge edge) {

		int v = edge.from(), w = edge.to();
		if (distanceTo[w] > distanceTo[v] + edge.weigth()) {
			edgeTo[w] = edge;
			distanceTo[w] = distanceTo(v) + edge.weigth();
			if (pq.contains(w)) {
				pq.decreaseKey(w, distanceTo(w));
			} else {
				pq.insert(w, distanceTo(w));
			}
		}
	}
}
