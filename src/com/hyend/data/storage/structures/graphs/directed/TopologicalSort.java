package com.hyend.data.storage.structures.graphs.directed;

import java.util.Set;
import java.util.Deque;
import java.util.HashSet;
import java.util.ArrayDeque;

/**
 * Given a directed acyclic graph, print the topological order of this graph.
 *
 * Do DFS by keeping visited. Put the vertex which are completely explored into a stack.
 * Pop from stack to get sorted order.
 * 
 * @author gopi_karmakar
 */
public class TopologicalSort {
	
	public static void main(String[] args) {
		
		Integer[][] data = {{1, 3}, {1, 2}, {3, 4}, {5, 6}, {6, 3}, {3, 8}, {8, 11}};
		DirectedGraph<Integer> diGraph = BuildDirectedGraph.buildGraph(data);		
						
		Set<Integer> visited = new HashSet<>();
		Deque<Integer> stack = new ArrayDeque<>();
		
		for(int v : diGraph.getAllVertices()) {
			if(!visited.contains(v))
				topologicalSort(diGraph, v, visited, stack);
		}
		
		diGraph.printGraph();
		System.out.println();
		System.out.println(stack);
	}

	/**
	 * The topological ordering computation is O(V + E) and dominates the computation time.
	 */
	public static void topologicalSort(DirectedGraph<Integer> diGraph, int v, Set<Integer> visited, Deque<Integer> stack) {

		visited.add(v);
		
		for(int e: diGraph.getAdjacencySet(v)) {
			
			if(!visited.contains(e)) {
				topologicalSort(diGraph, e, visited, stack);
			}
		}
		stack.addFirst(v);
	}	
}