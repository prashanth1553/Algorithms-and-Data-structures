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

	public int other(int v) {
		if (this.v == v) {
			return this.w;
		}
		if (this.w == v) {
			return this.v;
		}
		throw new IllegalArgumentException("wrong vertex");
	}

	public double residualCapacityTo(int v) {
		if (this.v == v) {
			return flow;
		} else {

			return capacity - flow;
		}

	}

	public void addResidualFlowTo(int v, double delta) {
		if (this.v == v) {
			flow -= delta;

		} else {
			flow += delta;
		}

	}
}
