package com.hyend.data.storage.structures.graphs.directed;

import java.util.Set;
import java.util.Objects;
import java.util.LinkedHashSet;

public class GraphVertex<V> {
	
	public static enum Color { WHITE, GRAY, BLACK }
	
	public V v = null;
	public Color color = null;	
	public Set<GraphVertex<V>> edges = null;
	
	public GraphVertex(V v) {
		this.v = v;
		this.color = Color.WHITE;
		edges = new LinkedHashSet<GraphVertex<V>>();
	}
	
	@Override
	public boolean equals(Object obj) {			
		
		if(this == obj)
			return true;
		
		if(obj == null || !(obj instanceof GraphVertex)) 
			return false;
		
		@SuppressWarnings("unchecked")
		GraphVertex<V> that = (GraphVertex<V>) obj;
		if(this.v.equals(that.v))
			return true;		
		
		return false;
	}
	
	@Override
	public int hashCode() {		
		return Objects.hashCode(v); 
	}
	
	@Override
	public String toString() {
		
		String msg = "v = " + this.v + " Color = " + this.color + "\t->\t";
		for(GraphVertex<V> e: edges) {
			
			String edgeMsg = "e = " + e.v + " Color = " + this.color + ", ";
			msg += edgeMsg;
		}
		
		return msg;
	}	
}