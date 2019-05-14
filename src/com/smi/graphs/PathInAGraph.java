package com.smi.graphs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathInAGraph {

	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int t = 0; t < testCases; t++) {
			writer.write("Test Case #" + (t + 1) + "");
			writer.newLine();
			Map<Integer, boolean[]> reachable = new HashMap<>();
			String[] nAndE = bufferedReader.readLine().trim().split(" ");
			int N = strToInt(nAndE[0]);
			int E = strToInt(nAndE[1]);
			Graph graph = new Graph(N);
			for (int i = 0; i < E; i++) {
				String[] uANdV = bufferedReader.readLine().trim().split(" ");
				graph.addEdge(strToInt(uANdV[0]), strToInt(uANdV[1]));
			}
			int Q = Integer.parseInt(bufferedReader.readLine().trim());
			for (int i = 0; i < Q; i++) {
				String[] uANdV = bufferedReader.readLine().trim().split(" ");
				int u = strToInt(uANdV[0]);
				int v = strToInt(uANdV[1]);
				if (!reachable.containsKey(u)) {
					reachable.put(u, new boolean[N + 1]);
					graph.dfs(u, reachable.get(u));
				}
				if (reachable.get(u)[v]) {
					writer.write("Yes");
				} else {
					writer.write("NO");
				}
				writer.newLine();
			}

		}
		writer.flush();
	}

	private static int strToInt(String str) {
		return Integer.parseInt(str);
	}

	static class Graph {
		int V2;
		List<Integer> edges[];

		Graph(int V1) {
			this.V2 = V1 + 1;
			edges = (ArrayList<Integer>[]) new ArrayList[this.V2];
			for (int i = 1; i < this.V2; i++) {
				edges[i] = new ArrayList<Integer>();
			}
		}

		public void addEdge(int v, int w) {
			edges[v].add((Integer) w);
			edges[w].add((Integer) v);
		}

		List<Integer> edges(int v) {
			return edges(v);
		}

		public void dfs(int v, boolean marked[]) {
			marked[v] = true;
			for (int w : edges[v]) {
				if (!marked[w]) {
					dfs(w, marked);
				}
			}

		}
	}
}
