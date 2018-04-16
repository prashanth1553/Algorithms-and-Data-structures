package com.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstOrder {
	private boolean[] marked; // marked[v] = has v been marked in dfs?
	private int[] pre; // pre[v] = preorder number of v
	private int[] post; // post[v] = postorder number of v
	private Queue<Integer> preorder; // vertices in preorder
	private Queue<Integer> postorder; // vertices in postorder
	private int preCounter; // counter or preorder numbering
	private int postCounter; // counter for postorder numbering

	public DepthFirstOrder(Digraph G) {
		pre = new int[G.V()];
		post = new int[G.V()];
		postorder = new LinkedList<>();
		preorder = new LinkedList<>();
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

	public Iterable<Integer> post() {
		return postorder;
	}

	public Iterable<Integer> pre() {
		return preorder;
	}

	public Iterable<Integer> reversePost() {
		Stack<Integer> reverse = new Stack<Integer>();
		for (int v : postorder)
			reverse.push(v);
		return reverse;
	}
}
