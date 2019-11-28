package com.hyend.data.storage.structures.graphs.directed;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A Google Interview Question
 * In a binary tree, mistakenly one extra invalid edge has been added. 
 * Given the root node, find and remove the invalid edge from the tree and return the root. 
 * 
 * NOTE: An acyclic connected graph is also known as free tree.
 * 
 * Variant: Convert a Directed Cyclic Graph in to a Directed Acyclic Graph(DAG). 
 * 
 * For e.g: Here 3-5 is an extra invalid edge. Either remove a link between 2-5 or 3-5 to
 * 			make it a valid binary tree.
 * 
 * 			 		1
 * 				  /	  \
 * 		 		2		3
 * 			  /	  \   /
 * 			4		5
 * 
 * @author gopi_karmakar
 */
public class RectifyInvalidBinaryTree<V> {

	public static void main(String[] args) {
		
		Integer[][] tree = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 5}};						
		
		DirectedGraph<Integer> diGraph = BuildDirectedGraph.buildGraph(tree);
		System.out.println("Tree Before Fixed:");
		diGraph.printGraph();
		
		System.out.println("Tree After Fixed:");
		DirectedGraph<Integer> rectifiedDiGraph = rectifyTree(diGraph);
		rectifiedDiGraph.printGraph();
	}
	
	 /**
	  * A BFS Approach. Time complexity is O(v + e) where v = number of vertices	  
	  * and e = maximum degree of any vertex called edges.
	  */	 
	private static DirectedGraph<Integer> rectifyTree(DirectedGraph<Integer> diGraph) {		
		
		Queue<Integer> queue = new LinkedList<>();
				
		boolean[] marked = new boolean[2 * diGraph.vertices()];
		
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
					/**
					 * As the question say that just one extra invalid edge has been added 
					 * So just return as soon as the extra invalid edge found and fixed.
					 * Since the ConcurrentModificationException can occur if we modify 
					 * graph while traversing else take the copy of graph and modify the copy and return.
					 */
					diGraph.disconnectVertices(v, e);					
					return diGraph;					
				}
			}
		}
		return diGraph;
	}
}
