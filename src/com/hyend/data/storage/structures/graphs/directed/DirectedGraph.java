package com.hyend.data.storage.structures.graphs.directed;

import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.Collection;
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
	
	private Set<V> mGraph = null;
	
	private class Graph {

		private Map<V, Set<V>> mapping = null;
		
		public Graph() {
			mapping = new LinkedHashMap<>();
		}
		
		public Map<V, Set<V>> getGraph() {
			return mapping;
		}
		
		public void connectVertices(V v, V e) {			
			
			Set<V> setV = mapping.getOrDefault(v, new LinkedHashSet<>());
			/**
			 * Since it's diGraph so we are sure that there's a link b/w V -> E
			 * but the vice versa isn't the case for diGraphs. 
			 */
			setV.add(e);
			mapping.put(v, setV);
			
			// Since it's diGraph so V -> E is for sure but not E -> V.
			/*if(!mapping.containsKey(e))				
				mapping.put(e, new LinkedHashSet<>());*/
		}				
		
		public void disconnectVertices(V v, V e) {
			Set<V> set = mapping.get(v);
			set.remove(e);
			mapping.put(v, set);
		}

		
	}
	
	public DirectedGraph() {
		graph = new Graph();	
		mGraph = new LinkedHashSet<>();
	}
	
	public DirectedGraph(List<List<V>> vertices) {
		this();
		create(vertices);
	}	
	
	public DirectedGraph(Map<V, List<V>> vertices) {				
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
	
	public Map<V, Set<V>> getGraph() {
		return graph.getGraph();
	}
	
	@SuppressWarnings("unchecked")
	public void create(V[][] data) {		
		
		if(data instanceof GraphVertex[][]) {
			
			for(V[] v : data) {			
								
				V gv = v[0];
				
				for(int i = 1; i < v.length; ++i) {
					
					((GraphVertex<V>)gv).edges.add((GraphVertex<V>) v[i]);
				}				
				mGraph.add(gv);
			}
		}
		else {
			for(V[] v : data) {			
				
				for(int i = 1; i < v.length; ++i) {
					graph.connectVertices(v[0], v[i]);
				}
			}
		}
	}
	
	public void create(List<List<V>> list) {				
			
		list.forEach(v -> {
			
			for(int i = 1; i < v.size(); ++i) {
											
				graph.connectVertices(v.get(0), v.get(i));
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
	
	public DirectedGraph<V> reverse() {
		
		DirectedGraph<V> diGraph = new DirectedGraph<>();
		
		getAllVertices().forEach(v -> {
			
			getAdjacencyList(v).forEach(e -> {
				
				diGraph.graph.connectVertices(e, v);
			});
		});
		return diGraph;
	}
	
	public DirectedGraph<V> disconnectVertices(V v, V e) {
		
		graph.disconnectVertices(v, e);		
		return this;
	}
	
	/**
	 * Vertices in a DAG which have no incoming edges are referred to as sources.
	 * vertices which have no outgoing edges are referred to as sinks.
	 */
	public boolean isItASink(V v) {
		return (getAdjacencyList(v) == null);
	}
	
	public int edges() {
		return totalEdges;
	}
	
	public int vertices() {
		return graph.getGraph().size();
	}
	
	public Collection<V> getAllVertices() {
		return graph.getGraph().keySet();
	}
	
	public Set<V> getAllGraphVertexes() {
		return mGraph;
	}
	
	public Set<V> getAdjacencyList(V v) { 
		return graph.getGraph().getOrDefault(v, new LinkedHashSet<>());
	}
	
	public void printGraph() {
				
		System.out.println(toString());
	}
	
	public void printGraphVertex() {
		
		System.out.println(toString());
	}
}