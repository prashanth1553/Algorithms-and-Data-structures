package com.graph;

import java.util.LinkedList;
import java.util.Queue;

public class AcyclicLP {

	double distanceTo[];
	DirectedEdge edgeTo[];

	public AcyclicLP(DirectedEdgeWeightedGraph G, int s) {
		Topological order = new Topological(G);

		edgeTo = new DirectedEdge[G.V()];
		distanceTo = new double[G.V()];
		for (int i = 0; i < G.V(); i++) {

			distanceTo[i] = Double.NEGATIVE_INFINITY;
		}

		distanceTo[s] = 0.0;
		edgeTo[s] = null;

		for (int v : order.order()) {

			for (DirectedEdge e : G.adjList(v)) {
				relax(e);
			}

		}

	}

	private void relax(DirectedEdge edge) {
		int v = edge.from(), w = edge.to();
		
		if (distanceTo[w] < distanceTo[v] + edge.weigth()) {
			distanceTo[w] = distanceTo[v] + edge.weigth();
			edgeTo[w] = edge;

		}

	}

	public Iterable<DirectedEdge> pathTo(int v) {
		Queue<DirectedEdge> path = new LinkedList<>();
		for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.to()]) {

			path.add(e);
		}

		return path;
	}

	public double distanceTo(int v) {
		return distanceTo[v];
	}

}
