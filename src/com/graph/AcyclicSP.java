package com.graph;

public class AcyclicSP {

	double distanceTo[];
	DirectedEdge edgeTo[];

	public AcyclicSP(DirectedEdgeWeightedGraph G, int s) {
		Topological order = new Topological(G);

		edgeTo = new DirectedEdge[s];
		distanceTo = new double[s];
		for (int i = 0; i < s; i++) {

			distanceTo[i] = Double.POSITIVE_INFINITY;
		}

		distanceTo[0] = 0.0;
		edgeTo[0] = null;

		for (int v : order.order()) {

			for (DirectedEdge e : G.adjList(v)) {
				relax(e);
			}

		}

	}

	private void relax(DirectedEdge edge) {
		int v = edge.from(), w = edge.to();

		if (distanceTo[w] > distanceTo[v] + edge.weigth()) {
			distanceTo[w] = distanceTo[v] + edge.weigth();
			edgeTo[w] = edge;

		}

	}
}
