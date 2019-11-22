package com.hyend.data.storage.structures.graphs.edgeweighted;

import java.util.Set;
import java.util.LinkedHashSet;

public class GraphVertex<V extends Comparable<V>> implements Comparable<GraphVertex<V>>{

	public V v;
	public Set<VertexWithDistance<V>> edges = null; 
	
	public GraphVertex(V v) {
		this.v = v;
		this.edges = new LinkedHashSet<>();
	}
	
	@Override
	public int compareTo(GraphVertex<V> obj) {
		
		return this.v.compareTo(obj.v);
	}
}
