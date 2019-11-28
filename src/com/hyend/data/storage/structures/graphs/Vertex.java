package com.hyend.data.storage.structures.graphs;

import java.util.Set;
import java.util.Objects;
import java.util.LinkedHashSet;

public class Vertex<V extends Comparable<V>> {
	
	public static enum Color { WHITE, GRAY, BLACK }
		
	public V v = null;	
	public Color color = null;
	
	public boolean visited = false;
	
	public int distance;
	
	// For Bridges and Articulation Points
	public int lowerTime = 0;
	public int discoveryTime = 0;	
	
	public Vertex<V> parent = null;
	public Set<Vertex<V>> edges = null;
	
	public Vertex() {
		edges = new LinkedHashSet<Vertex<V>>();
	}		
	
	public Vertex(V v) {
		this(v, false);
	}
	
	public Vertex(V v, boolean isVisited) {
		this.v = v;
		this.visited = isVisited;
		this.color = Color.WHITE;
		edges = new LinkedHashSet<Vertex<V>>();
	}
	
	public Vertex(Vertex<V> v) {
		this(v.v);
	}
	
	public void setVertex(Vertex<V> vertex) {
		this.v = vertex.v;
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
		
		String msg = this.v + "\t->\t";
		for(Vertex<V> e: edges) {
			
			String edgeMsg = e.v + " ";
			msg += edgeMsg;
		}		
		return msg;
	}
}