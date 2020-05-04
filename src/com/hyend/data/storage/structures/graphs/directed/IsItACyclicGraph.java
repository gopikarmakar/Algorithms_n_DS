package com.hyend.data.storage.structures.graphs.directed;

import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

/**
 * Check whether the given graph is a cyclic.
 * 
 * @author gopi_karmakar
 */
public class IsItACyclicGraph<V> {

	public static void main(String[] args) {
		
		DirectedGraph<Integer> diGraph = BuildDirectedGraph.createDefault();		
		
		System.out.println(isCyclic(diGraph));
	}
	
	/**
	 * Time complexity O(v + e)
	 */
	private static boolean isCyclic(DirectedGraph<Integer> diGraph) {
		
		diGraph.printGraph();
		
		Queue<Integer> queue = new LinkedList<>();
		
		boolean[] marked = new boolean[diGraph.vertices()+1];
		
		Stack<Integer> stack = new Stack<>();
		
		int v = diGraph.getAllVertices().iterator().next();
		
		queue.add(v);
		stack.add(v);		
		
		boolean isCyclic = false;
		
		while(!queue.isEmpty()) {
			
			v = queue.poll();
			marked[v] = true;
			
			for(int e : diGraph.getAdjacencySet(v)) {
				
				if(!marked[e]) {
					
					marked[e] = true;
					queue.add(e);
					stack.add(e);
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
		
		System.out.println(stack);
		return isCyclic;
	}
}