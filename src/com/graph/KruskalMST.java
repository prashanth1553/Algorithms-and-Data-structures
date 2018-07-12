package com.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.src.dynamicconnectivity.QuickUnionWeighted;

public class KruskalMST {

	List<Edge> mst;
	double weigth;

	public KruskalMST(EdgeWeightedGraph G) {
		mst = new ArrayList<>();
		Queue<Edge> pq = new PriorityQueue<>();
		for (Edge e : G.edges()) {
			pq.add(e);
		}
		QuickUnionWeighted uf = new QuickUnionWeighted(G.V());
		while (!pq.isEmpty() && mst.size() < G.V()-1) {
			Edge e = pq.poll();
			int v = e.either();
			int w = e.other(v);
			if (!uf.isConnected(v, w)) {
				mst.add(e);
				weigth += e.weigth;
				uf.union(v, w);
			}

		}
	}
}
