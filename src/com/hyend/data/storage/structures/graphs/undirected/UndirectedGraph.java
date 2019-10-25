package com.hyend.data.storage.structures.graphs.undirected;

import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * An Undirected Graph Implementation
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
		
		private void addPair(V v, V e) {
			
			Set<V> edges = mapping.getOrDefault(v, new HashSet<V>());
			edges.add(e);
			mapping.put(v, edges);
		}
	}
	
	public UndirectedGraph() {
		graph = new Graph();
	}
	
	public UndirectedGraph(Map<V, List<V>> vertices) {				
		this();
		create(vertices);
	}
	
	public UndirectedGraph(List<Node<V>> vertices) {
		this();
		create(vertices);
	}		
			
	public void create(List<Node<V>> list) {				
		
		list.forEach(node -> {
			
			node.e.forEach(v -> {
				
				graph.addPair(node.v, v);
				graph.addPair(v, node.v);
				
				totalEdges += 1;
			});
		});
	}
	
	public void create(Map<V, List<V>> map) {				
		
		map.entrySet().forEach(entry -> {
			
			entry.getValue().forEach(v -> {
				
				graph.addPair(entry.getKey(), v);
				graph.addPair(v, entry.getKey());
				
				totalEdges += 1;
			});
		});
	}
	
	public int getTotalEdges() {
		return totalEdges;
	}
	
	public int getTotalVertices() {
		return graph.mapping.size();
	}
	
	public Collection<V> getAllVertices() {
		return graph.mapping.keySet();
	}
	
	public Map<V, Set<V>> getGraph() {
		return graph.mapping;		
	}
	
	public Iterable<V> getAdjacencyList(V v) {	
		return graph.mapping.get(v);
	}
	
	public Iterator<V> getAdjacencyIterator(V v) {	
		return graph.mapping.get(v).iterator();
	}
	
	public void traverseGraph(Map<V, Set<V>> graph) {
		
		graph.keySet().forEach(k -> {
			
			System.out.print(k + "\t->\t");
			
			System.out.println(getAdjacencyList(k));
		});
	}
}