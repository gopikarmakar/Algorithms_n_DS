package com.hyend.data.storage.structures.graphs.directed;

import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import com.hyend.data.storage.structures.graphs.Vertex;

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
	
	private MapGraph<V> mapGraph = null;
	
	private Set<Vertex<V>> mVertexGraph = null;
	
	private Set<Vertex<V>> mReversedVertexGraph = null;		
		
	public DirectedGraph() {
		mapGraph = new MapGraph<>();			
		mVertexGraph = new LinkedHashSet<>();		
		mReversedVertexGraph = new LinkedHashSet<>();
	}
	
	@Override
	public String toString() {		
		String message = "";
		
		for(V v : mapGraph.getMappedGraph().keySet()) {
			
			message += v + "\t->\t" + getAdjacencySet(v) + "\n";
		}		
		return message;
	}
	
	public V mapEdge(V v, V e) {
		
		mapGraph.connectVertices(v, e);	
		
		totalEdges += 1;
		return v;
	}
	
	public Vertex<V> addEdge(Vertex<V> v, Vertex<V> e) {
		
		v.edges.add(e);
		mVertexGraph.add(v);
		
		totalEdges += 1;
		return v;
	}
	
	public Vertex<V> addReverseEdge(Vertex<V> e, Vertex<V> v) {
		
		e.edges.add(v);	
		mReversedVertexGraph.add(e);
		
		totalEdges += 1;
		return e;
	}
	
	public void create(V[][] data) {				
		for(V[] v : data) {						
			for(int i = 1; i < v.length; ++i) {
				mapEdge(v[0], v[i]);
				totalEdges += 1;
			}
		}		
	}
	
	public void create(List<List<V>> list) {
		list.forEach(v -> {			
			for(int i = 1; i < v.size(); ++i) {											
				mapEdge(v.get(0), v.get(i));
				totalEdges += 1;
			}
		});
	}
	
	public void createMappedVertexGraph(V[][] data) {					
		
		for(V[] v : data) {
								
			for(int i = 1; i < v.length; ++i) {
				
				mapGraph.connectVertexes(v[0], v[i]);
				totalEdges += 1;
			}				
		}
	}
	
	public void reverseMappedGraph() {
		
		getAllVertices().forEach(v -> {
			
			getAdjacencySet(v).forEach(e -> {
				
				mapEdge(e, v);
				totalEdges += 1;
			});
		});	
	}
	
	public Map<V, Vertex<V>> reverseMappedVertexGraph() {				
		
		for(Vertex<V> v : getMappedVertexGraph().values()) {
			
			for(Vertex<V> e : v.edges) {
				
				mapGraph.revereseConnectVertexes(e.v, v.v);
			}
		}				
		return getReversedMappedVertexGraph();
	}
	
	public void disconnectVertices(V v, V e) {		
		mapGraph.disconnectVertices(v, e);		
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
		return mapGraph.getMappedGraph().size();
	}
	
	public Collection<V> getAllVertices() {
		return mapGraph.getMappedGraph().keySet();
	}
	
	public Set<V> getAdjacencySet(V v) { 
		return mapGraph.getMappedGraph().getOrDefault(v, new LinkedHashSet<>());
	}
	
	public List<V> getAdjacencyList(V v) {	
		return new ArrayList<V>(getGraph().getOrDefault(v, new LinkedHashSet<>()));
	}
	
	public Map<V, Set<V>> getGraph() {
		return mapGraph.getMappedGraph();
	}
	
	public Set<Vertex<V>> getVertexGraph() {
		return mVertexGraph;
	}
	
	public Set<Vertex<V>> getReverseVertexGraph() {
		return mReversedVertexGraph;
	}
	
	public Map<V, Vertex<V>> getMappedVertexGraph() {		
		return mapGraph.getMappedVertexGraph();
	}
	
	public Map<V, Vertex<V>> getReversedMappedVertexGraph() {		
		return mapGraph.getReverseMappedVertexGraph();
	}	
	
	public void printGraph() {
				
		System.out.println(toString());
	}
	
	public void printVertexGraph() {
		
		for(Vertex<V> v: mVertexGraph)
			System.out.println(v);
	}
	
	public void printReversedVertexGraph() {
		
		for(Vertex<V> v: mReversedVertexGraph)
			System.out.println(v);
	}
	
	public void printMappedVertexGraph() {
		
		for(Vertex<V> v: getMappedVertexGraph().values())
			System.out.println(v);
	}
	
	public void printReverseMappedVertexGraph() {
		
		for(Vertex<V> v: getReversedMappedVertexGraph().values())
			System.out.println(v);
	}
}