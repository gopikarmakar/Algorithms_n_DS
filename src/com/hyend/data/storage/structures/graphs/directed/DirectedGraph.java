package com.hyend.data.storage.structures.graphs.directed;

import java.util.Set;

import com.hyend.data.storage.structures.graphs.Vertex;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
public class DirectedGraph<V extends Comparable<V>> {
	
	private int totalEdges = 0;
	
	private Graph mGraph = null;
	
	private Set<Vertex<V>> mVertexGraph = null;
	
	Map<V, Vertex<V>> mappedVertexGraph = null;
	
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
		mGraph = new Graph();	
		mappedVertexGraph = new HashMap<>();
		mVertexGraph = new LinkedHashSet<>();		
	}
	
	@Override
	public String toString() {		
		String message = "";
		
		for(V v : mGraph.getGraph().keySet()) {
			
			message += v + "\t->\t" + getAdjacencySet(v) + "\n";
		}		
		return message;
	}
	
	public V addEdge(V v1, V v2) {
		
		mGraph.connectVertices(v1, v2);	
		
		totalEdges += 1;
		return v1;
	}
	
	public Vertex<V> addEdge(Vertex<V> v1, Vertex<V> v2) {
		
		v1.edges.add(v2);
		mVertexGraph.add(v1);
		
		totalEdges += 1;
		return v1;
	}
	
	public void create(V[][] data) {				
		for(V[] v : data) {						
			for(int i = 1; i < v.length; ++i) {
				mGraph.connectVertices(v[0], v[i]);
				totalEdges += 1;
			}
		}		
	}
	
	public void create(Vertex<V>[][] data) {		
		for(Vertex<V>[] v : data) {
			
			Vertex<V> gv = v[0];			
			for(int i = 1; i < v.length; ++i) {
				
				gv.edges.add(v[i]);
				totalEdges += 1;
			}				
			mVertexGraph.add(gv);				
		}		
	}
	
	public void create(List<List<V>> list) {			
		list.forEach(v -> {			
			for(int i = 1; i < v.size(); ++i) {											
				mGraph.connectVertices(v.get(0), v.get(i));
				totalEdges += 1;
			}
		});
	}
	
	public void createVertexGraph(List<List<Vertex<V>>> list) {			
		list.forEach(v -> {
			
			Vertex<V> gv = v.get(0);
			for(int i = 1; i < v.size(); ++i) {											
				
				gv.edges.add(v.get(i));
				totalEdges += 1;
			}
			mVertexGraph.add(gv);
		});
	}
	
	public void create(Map<V, List<V>> map) {
		
		map.entrySet().forEach(entry -> {
			
			entry.getValue().forEach(e -> {
								
				mGraph.connectVertices(entry.getKey(), e);
				totalEdges += 1;
			});
		});
	}
	
	public void createMappedVertexGraph(V[][] data) {					
		
		for(V[] v : data) {
			
			Vertex<V> gv = mappedVertexGraph.getOrDefault(v[0], new Vertex<V>(v[0]));			
			for(int i = 1; i < v.length; ++i) {
				
				gv.edges.add(new Vertex<>(v[i]));
				totalEdges += 1;
			}				
			mappedVertexGraph.put(gv.v, gv);				
		}
	}
	
	public DirectedGraph<V> reverse() {
		
		DirectedGraph<V> diGraph = new DirectedGraph<>();
		
		getAllVertices().forEach(v -> {
			
			getAdjacencySet(v).forEach(e -> {
				
				mGraph.connectVertices(e, v);
				totalEdges += 1;
			});
		});
		return diGraph;
	}
	
	public Collection<Vertex<V>> reverseVertexGraph() {
		
		
		Map<V, Vertex<V>> map = new HashMap<>();
		
		mappedVertexGraph.values().forEach(v -> {
			
			v.edges.forEach(e -> {
				
				Vertex<V> reversed = map.getOrDefault(e.v, new Vertex<>(e));
				reversed.edges.add(v);
				map.put(e.v, reversed);
			});			
			
		});		
		return map.values();
	}
	
	public DirectedGraph<V> disconnectVertices(V v, V e) {
		
		mGraph.disconnectVertices(v, e);		
		return this;
	}
	
	/**
	 * Vertices in a DAG which have no incoming edges are referred to as sources.
	 * vertices which have no outgoing edges are referred to as sinks.
	 */
	public boolean isItASink(V v) {
		return (getAdjacencySet(v) == null);
	}
	
	public int edges() {
		return totalEdges;
	}
	
	public int vertices() {
		return mGraph.getGraph().size();
	}
	
	public Map<V, Set<V>> getGraph() {
		return mGraph.getGraph();
	}
	
	public Set<Vertex<V>> getVertexGraph() {
		return mVertexGraph;
	}
	
	public Map<V, Vertex<V>> getMappedVertexGraph() {
		
		return mappedVertexGraph;
	}
	
	public Collection<V> getAllVertices() {
		return mGraph.getGraph().keySet();
	}
	
	public Set<V> getAdjacencySet(V v) { 
		return mGraph.getGraph().getOrDefault(v, new LinkedHashSet<>());
	}
	
	public List<V> getAdjacencyList(V v) {	
		return new ArrayList<V>(getGraph().getOrDefault(v, new LinkedHashSet<>()));
	}
	
	public void printGraph() {
				
		System.out.println(toString());
	}
	
	public void printVertexGraph() {
		
		for(Vertex<V> v: mVertexGraph)
			System.out.println(v);
	}
	
	public void printMappedVertexGraph() {
		
		for(Vertex<V> v: mappedVertexGraph.values())
			System.out.println(v);
	}
}