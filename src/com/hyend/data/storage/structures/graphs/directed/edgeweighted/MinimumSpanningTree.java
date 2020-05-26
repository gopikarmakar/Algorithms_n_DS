package com.hyend.data.storage.structures.graphs.directed.edgeweighted;

import java.util.Set;
import java.util.List;
import java.util.TreeSet;
import java.util.SortedSet;
import java.util.ArrayList;

/**
 * MST implementation is quite same as Dijkstra's Algorithm 
 * but shortest path with least edges makes it Prim's algorithm 
 * i.e. Time Complexity is O((E + V)log(V)) 
 *  
 * @author gopi_karmakar
 */
public class MinimumSpanningTree {	
	
	/**
	 * The Time complexity is O((E + V)log(V)).
	 * Space complexity is O(E + V)
	 */
	public static <V extends Comparable<V>> List<Edge<V>> 
		mstTraversal(Set<VertexWithDistance<V>> graph, 
				VertexWithDistance<V> s) {
		
		List<Edge<V>> result = new ArrayList<>();
		SortedSet<GraphVertex<V>> bst = new TreeSet<>();
		
		// Initializing the source vertex with 0 before begin the traversal. 
		s.vertex.dwfe = new DistanceWithFewestEdges(0, 0);
		bst.add(s.vertex);				
		
		while(!bst.isEmpty()) {
			
			GraphVertex<V> v = bst.first();				
							
			if(v.parent != null) {
				Edge<V> edge = new Edge<>(v.parent, v);				
				result.add(edge);
			}								
			
			bst.remove(v);
			
			for(VertexWithDistance<V> e: v.edges) {
				
				int eDistance = v.dwfe.distance + e.distance;
				int eNumEdges = v.dwfe.minNumEdges + 1;
				
				if(e.vertex.dwfe.distance > eDistance ||
					(e.vertex.dwfe.distance == eDistance && 
					e.vertex.dwfe.minNumEdges > eNumEdges)) {
					
					bst.remove(e.vertex);
					e.vertex.parent = v;
					e.vertex.dwfe = new DistanceWithFewestEdges(eDistance, eNumEdges);
					bst.add(e.vertex);
				}
			}
		}
		return result;
	}
	
	public static class Edge<V extends Comparable<V>> {
		
		GraphVertex<V> v;
		GraphVertex<V> e;
		
		public Edge(GraphVertex<V> v, GraphVertex<V> e) {
		
			this.e = e;
			this.v = v;
		}
		
		@Override
		public String toString() {			
			return v.v + " -> " + e.v;
		}
	}
}
