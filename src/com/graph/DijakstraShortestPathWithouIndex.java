package com.graph;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class DijakstraShortestPathWithouIndex {

	private DirectedEdge[] edgeTo;
	private double[] distanceTo;
	private Set<Integer> settled;

	public DijakstraShortestPathWithouIndex(DirectedEdgeWeightedGraph G, int s) {
		edgeTo = new DirectedEdge[G.V()];
		distanceTo = new double[G.V()];
		settled = new HashSet<>();
		for (int i = 0; i < G.V(); i++) {
			distanceTo[i] = Double.MAX_VALUE;
		}
		PriorityQueue<Node> pq = new PriorityQueue<>(
				(Node e1, Node e2) -> Double.compare(e1.getWeigth(), e2.getWeigth()));
		distanceTo[s] = 0;
		pq.add(new Node(s, 0));
		while (settled.size() < G.V()) {
			Node n = pq.poll();
			if (settled.add(n.v)) {
				for (DirectedEdge edge : G.adjList(n.v)) {
					relax(edge, pq);
				}
			}
		}

	}

	private void relax(DirectedEdge edge, PriorityQueue<Node> pq) {
		int v = edge.from(), w = edge.to();
		if (distanceTo[w] > distanceTo[v] + edge.weigth()) {
			distanceTo[w] = distanceTo[v] + edge.weigth();
			edgeTo[w] = edge;
			pq.add(new Node(w, distanceTo[w]));
		}
	}

	static class Node {

		private int v;
		private double weigth;

		public Node(int v, double weigth) {
			super();
			this.v = v;
			this.weigth = weigth;
		}

		public double getWeigth() {
			return weigth;
		}

		public void setWeigth(double weigth) {
			this.weigth = weigth;
		}

	}

}
