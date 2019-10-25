package com.hyend.data.storage.structures.graphs.undirected;

import java.util.Iterator;

/**
 * Compute the degree of a vertex.
 * 
 * When there is an edge connecting two vertices, we say that the vertices
 * are adjacent to one another and that the edge is incident to both vertices. 
 * The degree of a vertex is the number of edges incident to it and in a multi-graph, 
 * loops are counted twice.
 * 
 * @author gopi_karmakar
 */
public class ComputeDegree<V> {
	
	public static void main(String[] args) {
		
		UndirectedGraph<Integer> uGraph = BuildUndirectedGraph.buildDefaultGraph();
		
		int source = 9;
		System.out.println("Max Degree Of graph = " + getMaxDegreeOfGraph(uGraph));
		System.out.println("Average Degree Of graph = " + getAvgDegreeOfGraph(uGraph));
		System.out.println("Degree Of vertex " + source + " = " + getDegreeOfAVertex(uGraph, source));	
	}
	
	/**
	 * Time complexity id O(n) where n is the maximum degree of a graph.
	 */
	private static int getMaxDegreeOfGraph(UndirectedGraph<Integer> uGraph) {
		
		int maxDegree = 0;
		
		for(int v : uGraph.getAllVertices()) {
			
			maxDegree = Math.max(maxDegree, getDegreeOfAVertex(uGraph, v));
		}
		return maxDegree;
	}
	
	private static int getAvgDegreeOfGraph(UndirectedGraph<Integer> uGraph) {
				
		return 2 * uGraph.getTotalEdges() / uGraph.getTotalVertices();
	}
	
	/**
	 * Time complexity id O(n) where n is the degree of the vertex.
	 */
	private static int getDegreeOfAVertex(UndirectedGraph<Integer> uGraph, int source) {
		
		int degree = 0;
				
		Iterator<Integer> itr = uGraph.getAdjacencyIterator(source);
		
		while(itr.hasNext()) {						
			itr.next();			
			degree += 1;
		}		
		return degree;
	}
}