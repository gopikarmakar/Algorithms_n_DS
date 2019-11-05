package com.hyend.data.storage.structures.graphs.undirected;

import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.HashSet;
import java.util.Collection;
import java.util.LinkedHashMap;

/**
 * An Undirected Graph Implementation
 * 
 * Graph creation takes O(v + e) time.
 * Where v = total number of vertices and 
 * e = max degree of any vertex.
 *  
 * @author gopi_karmakar
 */
public class UndirectedGraph<V> { 
	
	private int totalEdges = 0;
	private Graph graph = null;
	
	class Graph {
		
		private final Map<V, Set<V>> mapping;
		
		public Graph() {
			mapping = new LinkedHashMap<V, Set<V>>();
		}
		
		public Map<V, Set<V>> getGraph() {
			return mapping;
		}
		
		private void connectVertices(V v, V e) {
			
			Set<V> edges = mapping.getOrDefault(v, new HashSet<V>());
			edges.add(e);
			mapping.put(v, edges);
		}
	}
	
	public UndirectedGraph() {
		graph = new Graph();
	}
	
	public UndirectedGraph(Map<V, Set<V>> vertices) {				
		this();
		create(vertices);
	}
	
	public UndirectedGraph(List<List<V>> vertices) {
		this();
		create(vertices);
	}
	
	@Override
	public String toString() {		
		String message = "";
		
		for(V v : graph.getGraph().keySet()) {
			
			message += v + "\t->\t" + getAdjacencyList(v) + "\n";
		}		
		return message;
	}
	
	public void create(List<List<V>> list) {				
		
		list.forEach(node -> {
			
			for(int i = 1; i < node.size(); ++i) {
				
				graph.connectVertices(node.get(0), node.get(i));
				graph.connectVertices(node.get(i), node.get(0));
			}					
		});
	}
	
	public void create(Map<V, Set<V>> map) {				
		
		map.entrySet().forEach(entry -> {
			
			entry.getValue().forEach(v -> {
				
				graph.connectVertices(entry.getKey(), v);
				graph.connectVertices(v, entry.getKey());
				
				totalEdges += 1;
			});
		});
	}
	
	public int edges() {
		return totalEdges;
	}
	
	public int vertices() {
		return graph.mapping.size();
	}
	
	public Collection<V> getAllVertices() {
		return graph.mapping.keySet();
	}
	
	public Map<V, Set<V>> getGraph() {
		return graph.getGraph();		
	}
	
	public Set<V> getAdjacencyList(V v) {	
		return graph.getGraph().get(v);
	}
	
	public void printGraph() {
		
		System.out.println(toString());
	}
}