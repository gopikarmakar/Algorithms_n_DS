package com.hyend.data.storage.structures.graphs.edgeweighted;

import java.util.Set;
import java.util.TreeSet;
import java.util.SortedSet;

/**
 * The time complexity is that of the basic implementation of 
 * Dijkstra's algorithm, i.e., O((E + V)log(V)).
 * 
 * Space complexity is O(E + V)
 * 
 * @author gopi_karmakar
 */
public class ShortestPath<V extends Comparable<V>> {

	public static <V  extends Comparable<V>> GraphVertex<V> shortestPath(
			Set<VertexWithDistance<V>> graph, GraphVertex<V> s, GraphVertex<V> t) {
		
		SortedSet<GraphVertex<V>> bst = new TreeSet<>();
		
		s.distanceWithFewestEdges = new DistanceWithFewestEdges(0, 0);
		bst.add(s);				
		
		while(!bst.isEmpty()) {
			
			GraphVertex<V> v = bst.first();			
			if(v.equals(t))
				break;
			
			bst.remove(v);
			
			for(VertexWithDistance<V> e: v.edges) {
				
				int eDistance = v.distanceWithFewestEdges.distance + e.distance;
				int eNumEdges = v.distanceWithFewestEdges.minNumEdges + 1;
				
				if(e.vertex.distanceWithFewestEdges.distance > eDistance ||
					(e.vertex.distanceWithFewestEdges.distance == eDistance && 
					e.vertex.distanceWithFewestEdges.minNumEdges > eNumEdges)) {
					
					bst.remove(e.vertex);
					e.vertex.parent = v;
					e.vertex.distanceWithFewestEdges = new DistanceWithFewestEdges(eDistance, eNumEdges);
					bst.add(e.vertex);
				}
			}
		}
		return t;		
	}
}
