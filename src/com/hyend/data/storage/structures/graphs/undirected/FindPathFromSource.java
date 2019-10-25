package com.hyend.data.storage.structures.graphs.undirected;

import java.util.Set;
import java.util.Queue;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedHashSet;

/**
 * Given a source vertex find the connected path from source.
 * 
 * @author gopi_karmakar
 */
public class FindPathFromSource<V> {

	private Set<Integer> visitedPath = null;
	
	public FindPathFromSource() {
		
		visitedPath = new LinkedHashSet<>();
	}
	
	public static void main(String[] args) {
	
		FindPathFromSource<Integer> path = new FindPathFromSource<>();					
		
		Integer source = 5;
		
		//pathToSource.dfsPathSearch(BuildUndirectedGraph.buildDefaultGraph(), source);
		
		path.bfsPathSearch(BuildUndirectedGraph.buildDefaultGraph(), source);
		
		System.out.println(path.visitedPath);
	}
	
	public Set<Integer> getVisitedPath() {
		return visitedPath;
	}
	
	/**
	 * DFS traversal of a graph
	 * DFS marks all the vertices connected to a given source in time 
	 * proportional to the sum of their degrees
	 *
	 * O(n) Time complexity
	 */
	public void dfsPathSearch(UndirectedGraph<Integer> uGraph, int source) {

		visitedPath.add(source);
		
		Iterator<Integer> itr = uGraph.getAdjacencyIterator(source);
		
		while(itr.hasNext()) {
			
			int e = itr.next();
			
			if(!visitedPath.contains(e)) {
			
				dfsPathSearch(uGraph, e);
			}			
		}		
	}
	
	/**
	 * BFS traversal of a graph
	 * 
	 * O(n) Time complexity
	 */
	public Set<Integer> bfsPathSearch(UndirectedGraph<Integer> uGraph, int source) {
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(source);		
		visitedPath.add(source);
		
		while(!queue.isEmpty()) {
			
			int v = queue.remove();
			
			Iterator<Integer> itr = uGraph.getAdjacencyIterator(v);
			
			while(itr.hasNext()) {
				
				int e = itr.next();
				if(!visitedPath.contains(e)) {
					
					queue.add(e);
					visitedPath.add(e);
				}				
			}
		}
		return visitedPath;
	}	
}