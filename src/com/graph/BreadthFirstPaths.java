package com.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstPaths {

	private boolean marked[];
	private int edgeTo[];
	int source;
	
	public void breadthFirstSearch(int source, Graph graph) {
		this.source = source;
		marked = new boolean[graph.V()];
		edgeTo = new int[graph.V()];
		bfs(source, graph);
	}
	
	private void bfs(int source, Graph graph){
		Queue<Integer> qu = new LinkedList<>();
		qu.add(source);
		marked[source] = true;
		while(!qu.isEmpty()){
			int v = qu.poll();
			for(int a : graph.adjList(v)){
				if(!marked[a]){
					qu.add(a);
					marked[a] = true;
					edgeTo[a] = v;
				}
			}
		}
	}
	
}
