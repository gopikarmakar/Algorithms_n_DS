package com.hyend.data.storage.structures.graphs.undirected;

/**
 * Count all self loops in a graph.
 * A self loop in a graph is an edge that connects a vertex to itself.
 * 
 * @author gopi_karmakar
 */
public class CountAllSelfLoops {

	public static void main(String[] args) {
		
		int loops = countSelfLoops(BuildUndirectedGraph.buildDefaultGraph());
		System.out.println("Total Loops = " + loops);
	}
	
	/**
	 * O(n) time complexity where n is the max degree of any vertex. 
	 */
	private static int countSelfLoops(UndirectedGraph<Integer> uGraph) {
		
		int count = 0;
		
		for(int v : uGraph.getAllVertices()) {
			
			for(int e : uGraph.getAdjacencyList(v)) {
				
				if(v == e) 
					count += 1;
			}
		}		
		return count;
	}
}
