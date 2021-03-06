package com.hyend.data.storage.structures.graphs.directed;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import com.hyend.data.storage.structures.graphs.Vertex;

/**
 * A Directed Graph Builder Wrapper
 * 
 * https://algs4.cs.princeton.edu/42digraph/
 * 
 * NOTE : Refer to the above link for the source.
 * 
 * @author gopi_karmakar
 */
public class BuildDirectedGraph<V extends Comparable<V>> {

	public static void main(String[] args) {
		
		DirectedGraph<Integer> diGraph = createDefault();
		diGraph.printGraph();
	}
	
	/**
	 * Default Integer graph creation for testing
	 * 
	 * Time complexity is O(v + e) where v = number of vertices and
	 * e = maximum degree of any vertex called edges. 
	 */	
	public static DirectedGraph<Integer> createDefault() {
		
		Integer[][] data = {{0, 1, 5}, {2, 0, 3}, {3, 2, 5}, {4, 3, 2}, {5, 4},
							{6, 0, 4, 9}, {7, 6, 8}, {8, 7, 9}, {9, 10, 11}, 
							{10, 12}, {11, 4, 12}, {12, 9}};		
		
		return BuildDirectedGraph.buildGraph(data);			
	}
	
	public static DirectedGraph<Integer> defaultVertexGraph() {
		
		Integer[][] data = {{0, 1, 5}, {2, 0, 3}, {3, 2, 5}, {4, 3, 2}, {5, 4},
							{6, 0, 4, 9}, {7, 6, 8}, {8, 7, 9}, {9, 10, 11}, 
							{10, 12}, {11, 4, 12}, {12, 9}};		
		
		return BuildDirectedGraph.buildVertexGraph(data);			
	}
	
	public static <V extends Comparable<V>> DirectedGraph<V> buildGraph(V[][] data) {
		
		DirectedGraph<V> diGraph = new DirectedGraph<>();
	
		diGraph.create(data);
		
		return diGraph;
	}
	
	public static <V extends Comparable<V>> DirectedGraph<V> buildGraph(List<List<V>> data) {
		
		DirectedGraph<V> diGraph = new DirectedGraph<>();
		
		diGraph.create(data);
		
		return diGraph;
	}
		
	public static <V  extends Comparable<V>> DirectedGraph<V> buildVertexGraph(V[][] data) {
		
		DirectedGraph<V> diGraph = new DirectedGraph<>();
		BuildDirectedGraph<V> helper = new BuildDirectedGraph<V>();
		
		for(V[] v: data) {
			
			for(int i = 1; i < v.length; ++i) {
				
				helper.convertToGraphVertex(v[0], v[i]);
				diGraph.addEdge(helper.getGraphVertex(v[0]), helper.getGraphVertex(v[i]));
			}
		}		
		return diGraph;
	}
	
	public static <V  extends Comparable<V>> DirectedGraph<V> reverseVertexGraph(DirectedGraph<V> diGraph) {						
		
		BuildDirectedGraph<V> helper = new BuildDirectedGraph<V>();
				
		for(Vertex<V> v: diGraph.getVertexGraph()) {
			
			for(Vertex<V> e: v.edges) {
				
				helper.convertToGraphVertex(v.v, e.v);
				diGraph.addReverseEdge(helper.getGraphVertex(e.v), helper.getGraphVertex(v.v));				
			}
		}		
		return diGraph;
	}
	
	public static <V  extends Comparable<V>> DirectedGraph<V> buildMappedVertexGraph(V[][] data) {
		
		DirectedGraph<V> diGraph = new DirectedGraph<>();
		
		diGraph.createMappedVertexGraph(data);
		
		return diGraph;
	}
	
	public static <V  extends Comparable<V>> DirectedGraph<V> reverseMappedVertexGraph(DirectedGraph<V> diGraph) {
						
		diGraph.reverseMappedVertexGraph();
		
		return diGraph;
	}
	
	////////////////////////////// Helper Methods //////////////////////////////////////
	
	private Map<V, Vertex<V>> map = new HashMap<>();
	
	private void convertToGraphVertex(V v1, V v2) {

		map.putIfAbsent(v1, new Vertex<V>(v1));
		map.putIfAbsent(v2, new Vertex<V>(v2));
	}
	
	public Vertex<V> getGraphVertex(V key) {
		return map.get(key);
	}
	
	public static <V  extends Comparable<V>> List<List<Vertex<V>>> convertInToList(Vertex<V>[][] data) {
		
		List<List<Vertex<V>>> list = new ArrayList<>();
		
		for(Vertex<V>[] v : data) {
			
			List<Vertex<V>> l = new ArrayList<>();
			
			for(Vertex<V> e : v) {
				
				l.add(e);
			}
			list.add(l);
		}		
		return list;
	}
}
