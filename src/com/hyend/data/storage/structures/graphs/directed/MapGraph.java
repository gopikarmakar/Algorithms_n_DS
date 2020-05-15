package com.hyend.data.storage.structures.graphs.directed;

import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashSet;

import com.hyend.data.storage.structures.graphs.Vertex;

class MapGraph<V extends Comparable<V>> {

	private Map<V, Set<V>> mappedGraph = null;
	private Map<V, Set<V>> reversedMappedGraph = null;
	private Map<V, Vertex<V>> mappedVertexGraph = null;
	private Map<V, Vertex<V>> reversedMappedVertexGraph = null;
	
	public MapGraph() {
		mappedGraph = new HashMap<>();		
		mappedVertexGraph = new HashMap<>();
		reversedMappedGraph = new HashMap<>(); 
		reversedMappedVertexGraph = new HashMap<>(); 
	}
	
	public void connectVertices(V v, V e) {			
		
		Set<V> adjList = mappedGraph.getOrDefault(v, new LinkedHashSet<>());
		/**
		 * Since it's diGraph so we are sure that there's a link b/w V -> E
		 * but the vice versa isn't the case for diGraphs. 
		 */
		adjList.add(e);
		mappedGraph.put(v, adjList);			
	}		
	
	public void connectVertexes(V v, V e) {			
		
		Vertex<V> v1 = mappedVertexGraph.getOrDefault(v, new Vertex<V>(v));
		
		Vertex<V> e1 = mappedVertexGraph.getOrDefault(e, new Vertex<V>(e));
		
		v1.edges.add(e1);
		mappedVertexGraph.put(v, v1);			
		mappedVertexGraph.put(e, e1);
	}
	
	public void revereseConnectVertexes(V e, V v) {			
		
		Vertex<V> e1 = reversedMappedVertexGraph.getOrDefault(e, new Vertex<V>(e));
		
		Vertex<V> v1 = reversedMappedVertexGraph.getOrDefault(v, new Vertex<V>(v));			
		
		e1.edges.add(v1);
		reversedMappedVertexGraph.put(e, e1);			
		reversedMappedVertexGraph.put(v, v1);
	}
	
	public void disconnectVertices(V v, V e) {
		Set<V> set = mappedGraph.get(v);
		set.remove(e);
		mappedGraph.put(v, set);
	}
	
	public Map<V, Set<V>> getMappedGraph() {
		return mappedGraph;
	}
	
	public Map<V, Set<V>> getReverseMappedGraph() {
		return reversedMappedGraph;
	}
	
	public Map<V, Vertex<V>> getMappedVertexGraph() {
		return mappedVertexGraph;
	}
	
	public Map<V, Vertex<V>> getReverseMappedVertexGraph() {
		return reversedMappedVertexGraph;
	}
}
