package com.hyend.data.storage.structures.graphs.undirected;

import java.util.Set;

/**
 * Find is there any path exist between two given vertices.
 * 
 * @author gopi_karmakar
 */
public class FindExistenceOfAPath {

	public static void main(String[] args) {
		
		int source = 10;
		int destination = 12;
		
		System.out.println("Is there any path between " + source + " and " + 
							destination + " = " + isAnyPathExist(source,  destination));
	}
	
	/**
	 * Time complexity is O(v + e) where v = number of vertices and
	 * e = maximum degree of any vertex called edges.
	 */
	private static boolean isAnyPathExist(int source, int destination) {
		
		FindPathFromSource<Integer> path = new FindPathFromSource<>();
		
		Set<Integer> visitedPath = path.bfsPathSearch(BuildUndirectedGraph.buildDefaultGraph(), source);			
		
		return visitedPath.contains(source) && visitedPath.contains(destination);
	}
}
