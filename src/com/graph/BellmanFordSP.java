package com.graph;

public class BellmanFordSP {

	double distanceTo[];
	DirectedEdge edgeTo[];

	public BellmanFordSP(DirectedEdgeWeightedGraph G, int s) {

		distanceTo = new double[G.V()];
		edgeTo = new DirectedEdge[G.V()];
		for (int i = 0; i < G.V(); i++)
			distanceTo[i] = Double.POSITIVE_INFINITY;

		distanceTo[s] = 0;
		for (int pass = 0; pass < G.V(); pass++)
			for (int v = 0; v < G.V(); v++)
				for (DirectedEdge e : G.adjList(v))
					relax(e);

	}

	private void relax(DirectedEdge edge) {
		int v = edge.from(), w = edge.to();

		if (distanceTo[w] > distanceTo[v] + edge.weigth()) {

			distanceTo[w] = distanceTo[v] + edge.weigth();
			edgeTo[w] = edge;

		}

	}

}
