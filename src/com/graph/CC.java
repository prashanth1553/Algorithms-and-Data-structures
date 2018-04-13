package com.graph;

public class CC {

	private boolean marked[];
	private int id[]; // connected component number
	private int count; // connected component count

	public CC(Graph graph) {
		marked = new boolean[graph.V()];
		id = new int[graph.V()];
		for(int i = 0; i < graph.V(); i++){
			if(!marked[i]){
				dfs(graph, i);
				count++;
			}
			
		}
		
	}
	private void dfs(Graph graph, int v){
		marked[v]  = true;
		id[v] = count;
		for(int a : graph.adjList(v)){
			if(!marked[a]){
				dfs(graph, a);
			}
			
		}
		
	}
	

}
