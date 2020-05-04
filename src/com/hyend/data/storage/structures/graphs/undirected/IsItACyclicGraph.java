package com.hyend.data.storage.structures.graphs.undirected;

import java.util.Set;

import com.hyend.data.storage.structures.graphs.directed.BuildDirectedGraph;
import com.hyend.data.storage.structures.graphs.directed.DirectedGraph;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Find whether an undirected graph is cyclic or acyclic.
 * 
 * Variant: Is the Graph also a valid tree.
 * 
 * @author gopi_karmakar
 */
public class IsItACyclicGraph {

	public static void main(String[] args) {		
		
		UndirectedGraph<Integer> uGraph = BuildUndirectedGraph.createDefault();
		
		System.out.println(isCyclic(uGraph, new boolean[2 * uGraph.vertices()], 
				uGraph.getAllVertices().iterator().next()));
		
		System.out.println(isCyclic(uGraph));		
	}
	
	/**
	 * A DFS Approach
	 * Time complexity id O(|v| + |e|) where v = number of vertices and
	 * e = maximum degree of any vertex called edges.
	 */
	private static boolean isCyclic(UndirectedGraph<Integer> diGraph, boolean[] visited, Integer v) {
		
		visited[v] = true;
		
		for(Integer e : diGraph.getAdjacencySet(v)) {
			if(!visited[e]) {
				if(isCyclic(diGraph, visited, e))
					return true;
			}
			else if(v != e)
				return true;
		}
		return false;				
	}
	
	/**
	 * A BFS Approach
	 * Time complexity id O(|v| + |e|) where v = number of vertices and
	 * e = maximum degree of any vertex called edges.
	 */
	private static boolean isCyclic(UndirectedGraph<Integer> uGraph) {
		
		boolean isCyclic = false;
		
		boolean[] marked = new boolean[uGraph.vertices()+1];	
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(uGraph.getAllVertices().iterator().next());
		
		while(!queue.isEmpty()) {
			
			int v = queue.poll();
			marked[v] = true;
			
			for(int e : uGraph.getAdjacencySet(v)) {
				
				if(!marked[e]) {
					marked[e] = true;
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