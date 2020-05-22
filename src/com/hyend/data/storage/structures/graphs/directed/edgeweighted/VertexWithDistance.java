package com.hyend.data.storage.structures.graphs.directed.edgeweighted;

import java.util.Objects;

/**
 * This class is required because a GraphVertex can have many 
 * incoming edges with different distances and if we maintain
 * the distance in GraphVertex class then we can't maintain
 * the multiple distances for the same GraphVertex instead it'll
 * overwrite the distances with latest one and as a result it'll
 * only hold only one lastly added distance. So to maintain the 
 * multiple distances for the same GraphVertex we create new object 
 * of this class for every new distance and add as a edges for the
 * main GraphVertex.
 * 
 * @author gopi_karmakar
 */
public class VertexWithDistance<V extends Comparable<V>> {
	
	int distance;
	GraphVertex<V> vertex;
	
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
		String msg = this.vertex.v + " = " + this.distance + "\t->\t";
		for(VertexWithDistance<V> e: this.vertex.edges) {
			
			String edgeMsg = e.vertex.v + " = " + e.distance + ",  ";
			msg += edgeMsg;
		} 
		return msg;
	}
}