package com.hyend.data.storage.structures.graphs.directed;

import java.util.Set;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a source vertex find the connected path from source.
 * 
 * @author gopi_karmakar
 */
public class FindPathFromSource {
	
	public static void main(String[] args) {
		
		Set<Integer> visited = new LinkedHashSet<>();
		
		DirectedGraph<Integer> diGraph = BuildDirectedGraph.buildDefaultGraph();
		
		Integer source = 2;
		dfs(diGraph, visited, source);
		
		//bfs(diGraph, visited, 2);
		
		System.out.println(visited);
	}
	
	/**
	 * DFS traversal of a graph
	 * DFS marks all the vertices connected to a given source in time 
	 * proportional to the sum of their degrees
	 *
	 * Time complexity is O(v + e) where v = number of vertices and
	 * e = maximum degree of any vertex called edges.
	 */
	private static void dfs(DirectedGraph<Integer> diGraph, Set<Integer> visited, Integer source) {		
		
		visited.add(source);
				
		for(int e : diGraph.getAdjacencySet(source)) {
			
			if(!visited.contains(e)) {
				
				dfs(diGraph, visited, e);
			}
		}
	}
	
	/**
	 * BFS traversal of a graph
	 * 
	 * Time complexity is O(v + e) where v = number of vertices and
	 * e = maximum degree of any vertex called edges.
	 */
	private void bfs(DirectedGraph<Integer> diGraph, Set<Integer> visited, Integer source) {
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(source);
		
		while(!queue.isEmpty()) {
			
			int v = queue.remove();
			visited.add(v);
			
			for(int e : diGraph.getAdjacencySet(v)) {
				
				if(!visited.contains(e)) {
					queue.add(e);
					visited.add(e);
				}
			}
		}
	}
}