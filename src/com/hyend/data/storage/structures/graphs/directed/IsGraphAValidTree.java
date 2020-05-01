package com.hyend.data.storage.structures.graphs.directed;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A Amazon Interview Question
 * 
 * Check whether the given graph is a valid tree
 *  
 * NOTE: An acyclic connected graph is also known to be a Tree.
 * 
 * Variant: Check whether the given diGraph is an cyclic or acyclic free graph.
 * 
 * @author gopi_karmakar
 */
public class IsGraphAValidTree {

	public static void main(String[] args) {
						
		Integer[][] validTree = {{1, 0}, {0, 2}, {0, 3}, {3, 4}};
		Integer[][] invalidTree = {{1, 0}, {0, 2}, {2, 1}, {0, 3}, {3, 4}};
		
		DirectedGraph<Integer> diGraph = BuildDirectedGraph.buildGraph(invalidTree);
				
		System.out.println(!isItATree(diGraph, new boolean[2*diGraph.vertices()], 
							diGraph.getAllVertices().iterator().next()));
		
		System.out.println(!isItATree(diGraph));
	}
	
	/**
	 * A DFS Approach
	 * Time complexity id O(|v| + |e|) where v = number of vertices and
	 * e = maximum degree of any vertex called edges.
	 */
	private static boolean isItATree(DirectedGraph<Integer> diGraph, boolean[] visited, Integer v) {
		
		if(diGraph.getAdjacencySet(v).isEmpty())
			return false;
		
		visited[v] = true;
		
		for(Integer e : diGraph.getAdjacencySet(v)) {
			if(!visited[e]) {
				if(isItATree(diGraph, visited, e))
					return true;
			}
			else if(v != e) // Checking for self cycles.
				return true;
		}
		return false;				
	}	
	
	/**
	 * A BFS Approach
	 * Time complexity id O(|v| + |e|) where v = number of vertices and
	 * e = maximum degree of any vertex called edges.
	 */
	private static boolean isItATree(DirectedGraph<Integer> diGraph) {
		
		boolean isCyclic = false;
		
		boolean[] marked = new boolean[2*diGraph.vertices()];	
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(diGraph.getAllVertices().iterator().next());
		
		while(!queue.isEmpty()) {
			
			int v = queue.poll();
			marked[v] = true;
			
			for(int e : diGraph.getAdjacencySet(v)) {
				
				if(!marked[e]) {
					marked[e] = true;
					queue.add(e);
				}
				else {
					if(v != e) { // Checking for self cycles.
						isCyclic = true;
						break;						
					}
				}
			}			
			if(isCyclic) break;
		}
		return isCyclic;
	}
}
