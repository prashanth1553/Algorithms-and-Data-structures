package com.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.graph.Digraph;
import com.graph.DirectedDFS;

public class RegularExpressions {

	private String regexp;
	private final int m;
	private Digraph G;

	public RegularExpressions(String regexp) {

		this.regexp = regexp;
		m = regexp.length();
		buildEpsilonTransitionGraph();

	}

	private void buildEpsilonTransitionGraph() {

		G = new Digraph(m + 1);
		Stack<Integer> operations = new Stack<>();

		for (int i = 0; i < m; i++) {

			int lp = i;

			if (regexp.charAt(i) == '(' || regexp.charAt(i) == '|') {

				operations.add(i);

			} else if (regexp.charAt(i) == ')') {

				int or = operations.pop();
				if (regexp.charAt(or) == '|') {

					lp = operations.pop();
					G.addEdge(or, i);
					G.addEdge(lp, or + 1);
				} else if (regexp.charAt(or) == '(') {
					lp = operations.pop();
				} else
					assert false;

			}

			if (i < m - 1 && regexp.charAt(i + 1) == '*') {
				G.addEdge(lp, i + 1);
				G.addEdge(i + 1, lp);
			}
			if (regexp.charAt(i) == '(' || regexp.charAt(i) == '*' || regexp.charAt(i) == ')')
				G.addEdge(i, i + 1);

		}

	}

	public boolean recognizes(String txt) {
		int N = txt.length();
		DirectedDFS dfs = new DirectedDFS(G, 0);
		List<Integer> pc = new ArrayList<>();
		for (int v = 0; v < G.V(); v++) {
			if (dfs.marked(v)) {
				pc.add(v);
			}
		}

		for (int i = 0; i < N; i++) {
			List<Integer> match = new ArrayList<>();
			for (int v : pc) {

				if (v == m) {
					continue;
				}
				if (txt.charAt(i) == regexp.charAt(v)) {
					match.add(v + 1);
				}
			}
			dfs = new DirectedDFS(G, match);
			for (int v = 0; v < G.V(); v++) {
				if (dfs.marked(v)) {
					pc.add(v);
				}
			}
		}
		for (int v : pc) {
			if (v == m) {
				return true;
			}
		}
		return false;

	}

	public static void main(String args[]) {

		String main = "ddddaaabaaaaaaaaad";
		String pattern = "a*ba*";
		RegularExpressions obj = new RegularExpressions(pattern);
		System.out.println(obj.recognizes(main));

	}
}
