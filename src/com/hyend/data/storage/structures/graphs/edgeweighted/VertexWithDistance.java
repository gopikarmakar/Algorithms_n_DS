package com.hyend.data.storage.structures.graphs.edgeweighted;

import java.util.Objects;

public class VertexWithDistance<V extends Comparable<V>> {

	public int distance;
	public GraphVertex<V> vertex;
	
	public VertexWithDistance(GraphVertex<V> vertex) {
		this(vertex, 0);
	}
	
	public VertexWithDistance(GraphVertex<V> vertex, int distance) {
		this.vertex = vertex;
		this.distance = distance;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj == null || !(obj instanceof VertexWithDistance))
			return false;
		
		if(this == obj)
			return true;
		
		@SuppressWarnings("unchecked")
		VertexWithDistance<V> that = (VertexWithDistance<V>) obj;
		return (this.vertex.v.equals(that.vertex.v));					
	}
	
	@Override
	public int hashCode() {			
		return Objects.hash(this.vertex.v);
	}
	
	@Override
	public String toString() {
		
		String msg = "v = " + this.vertex.v + " d = " + this.distance + "\t->\t";
		
		for(VertexWithDistance<V> e: this.vertex.edges) {
			
			String edgeMsg = " v = " + e.vertex.v + ", d = " + e.distance;
			msg += edgeMsg;
		} 
		return msg;
	}
}
