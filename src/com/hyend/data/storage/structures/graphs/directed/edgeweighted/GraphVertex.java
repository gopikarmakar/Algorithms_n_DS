package com.hyend.data.storage.structures.graphs.directed.edgeweighted;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

/**
 * Holds the every vertex and it's adjacency list
 * with it's parent's added distance. 
 * 
 * @author gopi_karmakar
 */
public class GraphVertex<V extends Comparable<V>> implements Comparable<GraphVertex<V>> {

	public V v; 
	public GraphVertex<V> parent;
	
	public List<VertexWithDistance<V>> edges = null;
	
 	// Required to start every source vertex with a initial value.
	public DistanceWithFewestEdges dwfe = 
			new DistanceWithFewestEdges(Integer.MAX_VALUE, 0); 	
	
	public GraphVertex(V v) {
		this.v = v;
		edges = new ArrayList<>();		
	}

	@Override
	public int compareTo(GraphVertex<V> vertex) {
					
		if(dwfe.distance != vertex.dwfe.distance) {
			
			return Integer.compare(dwfe.distance, vertex.dwfe.distance);
		}
		
		if(dwfe.minNumEdges != vertex.dwfe.minNumEdges) {
			
			return Integer.compare(dwfe.minNumEdges, vertex.dwfe.minNumEdges);
		}
		
		return v.compareTo(vertex.v);
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj == null || !(obj instanceof GraphVertex))
			return false;
		
		if(this == obj)
			return true;
		
		@SuppressWarnings("unchecked")
		GraphVertex<V> that = (GraphVertex<V>) obj;
		return (this.v.equals(that.v) &&
				this.dwfe.distance == that.dwfe.distance && 
				this.dwfe.minNumEdges == that.dwfe.minNumEdges);					
	}
	
	@Override
	public int hashCode() {			
		return Objects.hash(this.dwfe.distance, this.dwfe.minNumEdges);
	}
}
