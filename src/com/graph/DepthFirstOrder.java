package com.graph;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstOrder {
	private boolean[] marked; // marked[v] = has v been marked in dfs?
	private int[] pre; // pre[v] = preorder number of v
	private int[] post; // post[v] = postorder number of v
	private List<Integer> preorder; // vertices in preorder
	private List<Integer> postorder; // vertices in postorder
	private int preCounter; // counter or preorder numbering
	private int postCounter; // counter for postorder numbering

	public DepthFirstOrder(Digraph G) {
		pre = new int[G.V()];
		post = new int[G.V()];
		postorder = new ArrayList<>();
		preorder = new ArrayList<>();
		marked = new boolean[G.V()];
		for (int v = 0; v < G.V(); v++)
			if (!marked[v])
				dfs(G, v);
	}

	public DepthFirstOrder(DirectedEdgeWeightedGraph G) {
		pre = new int[G.V()];
		post = new int[G.V()];
		postorder = new ArrayList<>();
		preorder = new ArrayList<>();
		marked = new boolean[G.V()];
		for (int v = 0; v < G.V(); v++)
			if (!marked[v])
				dfs(G, v);
	}

	private void dfs(Digraph G, int v) {
		marked[v] = true;
		preorder.add(v);
		pre[v] = preCounter++;
		for (int w : G.adjList(v)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}
		postorder.add(v);
		post[v] = postCounter++;
	}

	private void dfs(DirectedEdgeWeightedGraph G, int v) {
		marked[v] = true;
		pre[v] = preCounter++;
		preorder.add(v);
		for (DirectedEdge e : G.adjList(v)) {
			int w = e.to();
			if (!marked[w]) {
				dfs(G, w);
			}
		}
		postorder.add(v);
		post[v] = postCounter++;
	}

	public Iterable<Integer> post() {
		return postorder;
	}

	public Iterable<Integer> pre() {
		return preorder;
	}

	public Iterable<Integer> reversePost() {
		// Stack<Integer> reverse = new Stack<Integer>();
		// for (int v : postorder)
		// reverse.push(v);
		// return reverse;
		List<Integer> reverse = new ArrayList<>(postorder.size());
		for (int i = postorder.size() - 1; i >= 0; i--) {
			reverse.add(postorder.get(i));
		}
		return reverse;
	}
}
