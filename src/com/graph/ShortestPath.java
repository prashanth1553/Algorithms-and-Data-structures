package com.graph;

import java.util.Stack;

public class ShortestPath {

	double distanceTo[];
	DirectedEdge edgeTo[];
	int s;

	public ShortestPath(DirectedEdgeWeightedGraph G, int s) {

		distanceTo = new double[s];
		edgeTo = new DirectedEdge[s];
		this.s = s;
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
}
