package com.graph;

import java.util.Stack;

public class DigraphCycle {

	boolean marked[];
	int edgeTo[];
	boolean onStack[];
	Stack<Integer> stack;

	public DigraphCycle(Digraph G) {

		marked = new boolean[G.V()];
		onStack = new boolean[G.V()];
		for (int v = 0; v < G.V(); v++) {
			if (!marked[v]) {
				dfs(G, v);
			}
		}

	}

	private void dfs(Digraph G, int v) {

		marked[v] = true;
		onStack[v] = true;
		for (int w : G.adjList(v)) {
			if (stack != null) {
				return;
			}

			if (!marked[w]) {
				dfs(G, w);
				edgeTo[w] = v;
			} else if (onStack[w]) {

				stack = new Stack<>();
				for (int i = edgeTo[v]; i != w; i = edgeTo[i]) {

					stack.push(i);
				}
				stack.push(w);
				stack.push(v);
			}

		}
		onStack[v] = false;

	}
	
    /*public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);

        DirectedCycle finder = new DirectedCycle(G);
        if (finder.hasCycle()) {
            StdOut.print("Directed cycle: ");
            for (int v : finder.cycle()) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }

        else {
            StdOut.println("No directed cycle");
        }
        StdOut.println();
    }*/

}
