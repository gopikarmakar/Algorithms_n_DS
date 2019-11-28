package com.hyend.data.storage.structures.graphs.undirected;

import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

import com.hyend.data.storage.structures.graphs.Vertex;
import com.hyend.data.storage.structures.graphs.directed.DirectedGraph;

/**
 * An Undirected Graph Implementation
 * 
 * Graph creation takes O(v + e) time.
 * Where v = total number of vertices and 
 * e = max degree of any vertex.
 *  
 * @author gopi_karmakar
 */
public class UndirectedGraph<V extends Comparable<V>> { 
	
	private int totalEdges = 0;
	
	private Graph graph = null;
	
	private Set<Vertex<V>> vertexGraph = null;
	
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
		vertexGraph = new LinkedHashSet<>();
	}
	
	@Override
	public String toString() {		
		String message = "";
		
		for(V v : graph.getGraph().keySet()) {
			
			message += v + "\t->\t" + getAdjacencySet(v) + "\n";
		}		
		return message;
	}
	
	public void addEdge(V v1, V v2) {
		
		graph.connectVertices(v1, v2);	
		graph.connectVertices(v2, v1);
		totalEdges += 1;
	}
	
	public void addEdge(Vertex<V> v1, Vertex<V> v2) {
		
		v1.edges.add(v2);
		vertexGraph.add(v1);		
		
		v2.edges.add(v1);
		vertexGraph.add(v2);
		
		totalEdges += 1;
	}
	
	public void create(V[][] data) {				
		for(V[] v : data) {	
			
			for(int i = 1; i < v.length; ++i) {
				
				graph.connectVertices(v[0], v[i]);
				graph.connectVertices(v[i], v[0]);
				
				totalEdges += 1;
			}
		}		
	}
	
	public void create(Vertex<V>[][] data) {		
		for(Vertex<V>[] v : data) {
			
			Vertex<V> gv = v[0];			
			for(int i = 1; i < v.length; ++i) {
				
				gv.edges.add(v[i]);				
				v[i].edges.add(gv);
				
				totalEdges += 1;
			}				
			vertexGraph.add(gv);				
		}		
	}
	
	public void create(List<List<V>> list) {				
		
		list.forEach(v -> {
			
			for(int i = 1; i < v.size(); ++i) {
				
				graph.connectVertices(v.get(0), v.get(i));
				graph.connectVertices(v.get(i), v.get(0));				
				
				totalEdges += 1;
			}					
		});
	}
	
	public void createWithGraphVertex(List<List<Vertex<V>>> list) {			
		list.forEach(v -> {
			
			Vertex<V> gv = v.get(0);
			for(int i = 1; i < v.size(); ++i) {											
				
				gv.edges.add(v.get(i));
				
				v.get(i).edges.add(gv);
				
				totalEdges += 1;
			}
			vertexGraph.add(gv);
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
	
	public DirectedGraph<V> reverse() {
		
		DirectedGraph<V> diGraph = new DirectedGraph<>();
		
		getAllVertices().forEach(v -> {
			
			getAdjacencySet(v).forEach(e -> {
				
				graph.connectVertices(e, v);
				totalEdges += 1;
			});
		});
		return diGraph;
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
	
	public Set<Vertex<V>> getVertexGraph() {
		return vertexGraph;
	}
	
	public Set<V> getAdjacencySet(V v) {	
		return graph.getGraph().get(v);
	}
	
	public List<V> getAdjacencyList(V v) {	
		return new ArrayList<V>(getGraph().get(v));
	}
	
	public void printGraph() {
		
		System.out.println(toString());
	}
	
	public void printVertexGraph() {
		
		for(Vertex<V> v: vertexGraph)
			System.out.println(v);
	}
}