package com.graph;

public class Edge implements Comparable<Edge> {

	double weigth;
	int v;
	int w;

	public Edge(double weigth, int v, int w) {
		this.weigth = weigth;
		this.v = v;
		this.w = w;
	}

	public int either() {
		return v;
	}

	public int other(int vertex) {
		if (vertex == v)
			return w;
		else if (vertex == w)
			return v;
		else
			throw new IllegalArgumentException("Illegal endpoint");
	}

	@Override
	public int compareTo(Edge o) {
		return Double.compare(weigth, o.weigth);
	}

}
