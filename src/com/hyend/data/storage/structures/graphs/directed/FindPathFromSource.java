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
public class FindPathFromSource<V> {

	private Set<V> visited = null;
	
	public FindPathFromSource() {
		
		visited = new LinkedHashSet<>();
	}
	
	public static void main(String[] args) {
		
		FindPathFromSource<Integer> path = new FindPathFromSource<>();
		
		DirectedGraph<Integer> diGraph = BuildDirectedGraph.buildDefaultGraph();
		
		//path.dfs(diGraph, 2);
		
		path.bfs(diGraph, 2);
		
		System.out.println(path.visited);
	}
	
	/**
	 * DFS traversal of a graph
	 * DFS marks all the vertices connected to a given source in time 
	 * proportional to the sum of their degrees
	 *
	 * Time complexity is O(v + e) where v = number of vertices and
	 * e = maximum degree of any vertex called edges.
	 */
	private void dfs(DirectedGraph<V> diGraph, V source) {		
		
		visited.add(source);
				
		for(V e : diGraph.getAdjacencySet(source)) {
			
			if(!visited.contains(e)) {
				
				dfs(diGraph, e);
			}
		}
	}
	
	/**
	 * BFS traversal of a graph
	 * 
	 * Time complexity is O(v + e) where v = number of vertices and
	 * e = maximum degree of any vertex called edges.
	 */
	private void bfs(DirectedGraph<V> diGraph, V source) {
		
		Queue<V> queue = new LinkedList<>();
		
		queue.add(source);
		
		while(!queue.isEmpty()) {
			
			V v = queue.remove();
			visited.add(v);
			
			for(V e : diGraph.getAdjacencySet(v)) {
				
				if(!visited.contains(e)) {
					queue.add(e);
					visited.add(e);
				}
			}
		}
	}
}