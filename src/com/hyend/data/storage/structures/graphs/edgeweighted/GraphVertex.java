package com.hyend.data.storage.structures.graphs.edgeweighted;

import java.util.Set;
import java.util.List;
import java.util.Objects;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class GraphVertex<V extends Comparable<V>> implements Comparable<GraphVertex<V>> {

	public V v; 
	public GraphVertex<V> parent;
	
	//public Set<VertexWithDistance<V>> edges = null;
	
	public List<VertexWithDistance<V>> edges = null;
	
	public DistanceWithFewestEdges distanceWithFewestEdges = 
			new DistanceWithFewestEdges(Integer.MAX_VALUE, 0); 	
	
	public GraphVertex(V v) {
		this.v = v;
		//edges = new LinkedHashSet<>();
		edges = new ArrayList<>();
	}

	@Override
	public int compareTo(GraphVertex<V> vertex) {
					
		if(distanceWithFewestEdges.distance != vertex.distanceWithFewestEdges.distance) {
			
			return Integer.compare(distanceWithFewestEdges.distance, vertex.distanceWithFewestEdges.distance);
		}
		
		if(distanceWithFewestEdges.minNumEdges != vertex.distanceWithFewestEdges.minNumEdges) {
			
			return Integer.compare(distanceWithFewestEdges.minNumEdges, vertex.distanceWithFewestEdges.minNumEdges);
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
				this.distanceWithFewestEdges.distance == that.distanceWithFewestEdges.distance && 
				this.distanceWithFewestEdges.minNumEdges == that.distanceWithFewestEdges.minNumEdges);					
	}
	
	@Override
	public int hashCode() {			
		return Objects.hash(this.distanceWithFewestEdges.distance, this.distanceWithFewestEdges.minNumEdges);
	}
}
