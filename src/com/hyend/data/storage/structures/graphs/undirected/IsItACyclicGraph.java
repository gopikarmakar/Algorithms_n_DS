package com.hyend.data.storage.structures.graphs.undirected;

import java.util.Set;
import java.util.Queue;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Find is it a graph cyclic or acyclic
 * 
 * @author gopi_karmakar
 */
public class IsItACyclicGraph {

	public static void main(String[] args) {
		
		boolean isCyclic = bfs(BuildUndirectedGraph.buildDefaultGraph());
		System.out.println("Is It A Cyclic Graph = " + isCyclic);		
	}
	
	/**
	 * O(n) time complexity. Where n is the maximum degree of any vertex.
	 */
	private static boolean bfs(UndirectedGraph<Integer> uGraph) {
		
		boolean isCyclic = false;
		
		Set<Integer> visited = new HashSet<>();
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(uGraph.getAllVertices().iterator().next());
		
		while(!queue.isEmpty()) {
			
			int v = queue.remove();
			
			for(int e : uGraph.getAdjacencyList(v)) {
				
				if(!visited.contains(e)) {
					visited.add(e);
					queue.add(e);
				}
				else {
					if(v != e) {
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
