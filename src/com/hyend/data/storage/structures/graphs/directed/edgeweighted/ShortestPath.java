package com.hyend.data.storage.structures.graphs.directed.edgeweighted;

import java.util.TreeSet;
import java.util.SortedSet;

/**
 * It's a Dijkstra + Prim's algorithm. 
 * Shortest path with least edges makes it a prim's algorithm. 
 * 
 * The time complexity is that of the basic implementation of 
 * Dijkstra's + Prim's algorithm, i.e., O((E + V)log(V)).
 * 
 * Space complexity is O(E + V)
 * 
 * @author gopi_karmakar
 */
public class ShortestPath {

	public static <V  extends Comparable<V>> GraphVertex<V> shortestPath(
		GraphVertex<V> s, GraphVertex<V> t) {
		
		SortedSet<GraphVertex<V>> bst = new TreeSet<>();
		
		// Initializing the source vertex with 0 before begin the traversal.
		s.dwfe = new DistanceWithFewestEdges(0, 0);
		bst.add(s);				
		
		while(!bst.isEmpty()) {
			
			GraphVertex<V> v = bst.first();			
			if(v.equals(t))
				break;
			
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
		return t;		
	}
}
