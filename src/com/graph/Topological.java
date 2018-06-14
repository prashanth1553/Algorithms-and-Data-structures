package com.graph;

public class Topological {

	private Iterable<Integer> order;

	public Topological(DirectedEdgeWeightedGraph G) {
		DepthFirstOrder dfs = new DepthFirstOrder(G);
		order = dfs.reversePost();
	}

	public Iterable<Integer> order() {
		return order;
	}
}
