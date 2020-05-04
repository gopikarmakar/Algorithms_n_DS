package com.hyend.data.storage.structures.graphs.undirected;

import com.hyend.data.storage.structures.graphs.Vertex;

/**
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 * 
 * @author gopi_karmakar
 */
public class TotalConnectedComponents {

	public static void main(String[] args) {
		
		UndirectedGraph<Integer> uGraph = BuildUndirectedGraph.defaultVertexGraph();		
		System.out.println(totalConnectedComponents(uGraph));
	}
	
	private static int totalConnectedComponents(UndirectedGraph<Integer> uGraph) {
		
		int count = 0;
		
		for(Vertex<Integer> v : uGraph.getVertexGraph()) {
			
			if(!v.visited) {				
				dfs(v);
				count++;
			}			
		}		
		return count;
	}
	
	private static void dfs(Vertex<Integer> v) {
		
		if(v == null) return;
		
		v.visited = true;
		for(Vertex<Integer> e : v.edges) {
			
			if(!e.visited)
				dfs(e);
		}
	}
}
