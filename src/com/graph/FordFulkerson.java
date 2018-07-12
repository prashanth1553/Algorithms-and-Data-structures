package com.graph;

import java.util.LinkedList;
import java.util.Queue;

public class FordFulkerson {

	private boolean marked[];
	private FlowEdge edgeTo[];
	double value;

	public FordFulkerson(FlowNetwork G, int s, int t) {

		value = 0;

		while (hasAugmentingPath(G, s, t)) {
			double bottle = Double.POSITIVE_INFINITY;
			for (int v = t; v != s; v = edgeTo[v].other(v)) {

				bottle = Math.min(bottle, edgeTo[v].residualCapacityTo(v));
			}

			for (int v = t; v != s; v = edgeTo[v].other(v)) {
				edgeTo[v].addResidualFlowTo(v, bottle);
			}

			value += bottle;

		}

	}

	public boolean hasAugmentingPath(FlowNetwork G, int s, int t) {
		marked = new boolean[G.V()];
		edgeTo = new FlowEdge[G.V()];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);
		while (!queue.isEmpty()) {

			int v = queue.poll();
			for (FlowEdge e : G.adjList(v)) {

				int w = e.other(v);
				if (e.residualCapacityTo(w) > 0 && !marked[w]) {

					edgeTo[w] = e;
					marked[w] = true;
					queue.add(w);

				}

			}

		}

		return marked[t];
	}

}
