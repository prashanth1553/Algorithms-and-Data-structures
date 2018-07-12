package com.src.dynamicconnectivity;

public class QuickFind {

	private int [] id;
	
	public QuickFind(int n){
		id = new int[n];
		for(int i=0;i<n;i++){
			id[i] = i;
		}
	}
	public void union(int p, int q){
		int pid = id[p];
		int qid = id[q];
		for(int i =0;i<id.length;i++){
			if(pid == id[i]){
				id[i]=qid;
			}
		}
	}
	public boolean isConnected(int p, int q){
		return id[p]==id[q];
	}
}
