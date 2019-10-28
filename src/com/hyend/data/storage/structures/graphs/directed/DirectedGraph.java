package com.hyend.data.storage.structures.graphs.directed;

import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/**
 * A Directed Graph Implementation
 * 
 * Graph creation takes O(v + e) time.
 * Where v = total number of vertices and 
 * e = max degree of any vertex.
 * 
 * @author gopi_karmakar
 */
public class DirectedGraph<V> {
	
	private int totalEdges = 0;
	
	private Graph graph = null;	
	
	private class Graph {

		private Map<V, Set<V>> mapping = null;
		
		public Graph() {
			mapping = new LinkedHashMap<>();
		}
		
		public Map<V, Set<V>> getGraph() {
			return mapping;
		}
		
		public void connectVertices(V v, V e) {
			Set<V> set = mapping.getOrDefault(v, new LinkedHashSet<>());
			set.add(e);
			mapping.put(v, set);
		}
	}
	
	public DirectedGraph() {
		graph = new Graph();		
	}
	
	public DirectedGraph(List<List<V>> vertices) {
		this();
		create(vertices);
	}	
	
	public DirectedGraph(Map<V, List<V>> vertices) {				
		this();
		create(vertices);
	}
	
	public Map<V, Set<V>> getGraph() {
		return graph.getGraph();
	}
	
	public void create(List<List<V>> list) {		
		
		list.forEach(node -> {
			
			for(int i = 1; i < node.size(); ++i) {
				
				graph.connectVertices(node.get(0), node.get(i));				
				totalEdges += 1;
			}
		});
	}
	
	public void create(Map<V, List<V>> map) {
		
		map.entrySet().forEach(entry -> {
			
			entry.getValue().forEach(e -> {
				
				graph.connectVertices(entry.getKey(), e);				
				totalEdges += 1;
			});
		});
	}
	
	public int getTotalEdges() {
		return totalEdges;
	}
	
	public int getTotalVertices() {
		return graph.getGraph().size();
	}
	
	public Collection<V> getAllVertices() {
		return graph.getGraph().keySet();
	}
	
	public Iterable<V> getAdjacencyList(V v) {
		return graph.getGraph().get(v);
	}
	
	public Iterator<V> getAdjacencyIterator(V v) {
		return graph.getGraph().get(v).iterator();		
	}
	
	public void traverseGraph(Map<V, Set<V>> graph) {
		
		graph.keySet().forEach(k -> {			
			
			System.out.println(k + "\t->\t" + getAdjacencyList(k));
		});
	}
}