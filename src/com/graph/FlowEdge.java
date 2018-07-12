package com.graph;

public class FlowEdge {

	private int v;
	private int w;
	private double capacity;
	private double flow;

	public FlowEdge(int v, int w, double capacity) {
		this.v = v;
		this.w = w;
		this.capacity = capacity;
	}

	public int from() {
		return v;
	}

	public int to() {
		return w;
	}

	public int other(int vertex) {
		if (this.v == vertex) {
			return this.w;
		}
		if (this.w == vertex) {
			return this.v;
		}
		throw new IllegalArgumentException("wrong vertex");
	}

	public double residualCapacityTo(int vertex) {
		if (this.v == vertex) {
			return flow;
		} else if (w == vertex) {

			return capacity - flow;
		}

		throw new IllegalArgumentException("Illegal vertex");
	}

	public void addResidualFlowTo(int vertex, double delta) {
		if (this.v == vertex) {
			flow -= delta;

		} else if (this.w == vertex) {
			flow += delta;
		}

		throw new IllegalArgumentException("Illegal vertex");
	}
}
