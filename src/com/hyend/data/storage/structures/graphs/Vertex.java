package com.hyend.data.storage.structures.graphs;

import java.util.Set;
import java.util.Objects;
import java.util.LinkedHashSet;

abstract public class Vertex<V> {
	
	public static enum Color { WHITE, GRAY, BLACK }
	
	public V v = null;
	public Color color = null;
	public boolean visited = false;
	public Set<Vertex<V>> edges = null;
	
	public Vertex(V v) {
		this.v = v;
		this.visited = false;
		edges = new LinkedHashSet<Vertex<V>>();
	}
	
	@Override
	public boolean equals(Object obj) {			
		
		if(obj == null || !(obj instanceof Vertex)) 
			return false;
		
		if(this == obj)
			return true;
		
		@SuppressWarnings("unchecked")
		Vertex<V> that = (Vertex<V>) obj;
		if(this.v.equals(that.v))
			return true;		
		
		return false;
	}
	
	@Override
	public int hashCode() {		
		return Objects.hash(v); 
	}
	
	@Override
	public String toString() {
		
		String msg = "v = " + this.v + " Color = " + this.color + "\t->\t";
		for(Vertex<V> e: edges) {
			
			String edgeMsg = "e = " + e.v + " Color = " + this.color + ", ";
			msg += edgeMsg;
		}
		
		return msg;
	}	
}