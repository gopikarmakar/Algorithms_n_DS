package com.hyend.data.storage.structures.graphs.undirected;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.hyend.data.storage.structures.graphs.Vertex;

/**
 * An Undirected Graph Builder Wrapper
 * 
 * https://algs4.cs.princeton.edu/41graph/
 * 
 * NOTE : Refer to the above link for the source. 
 *  
 * @author gopi_karmakar
 */
public class BuildUndirectedGraph<V extends Comparable<V>> {

	public static void main(String[] args) {	
		
		UndirectedGraph<Integer> undiGraph = buildDefaultGraph();		
		undiGraph.printGraph();
	}
	
	/**
	 * Default Integer graph creation for testing
	 * 
	 * Time complexity is O(v + e) where v = number of vertices and
	 * e = maximum degree of any vertex called edges. 
	 */
	public static UndirectedGraph<Integer> buildDefaultGraph() {
		
		Integer[][] graph = {{0, 5}, {4, 3}, {0, 1}, {9, 12}, {6, 4},
						 	 {5, 4}, {0, 2}, {11, 12}, {9, 10}, {0, 6},
						 	 {7, 8}, {9, 11}, {5, 3}};
		
		return buildGraph(graph);
	}
	
	/**
	 * Default String graph creation for testing
	 * 
	 * Time complexity is O(v + e) where v = number of vertices and
	 * e = maximum degree of any vertex called edges. 
	 */
	public static UndirectedGraph<String> buildDefaultStringGraph() {
		
		String[][] graph = {{"A", "B"}, {"C", "D"}, {"J", "I"}, {"I", "M"}, {"M", "K"},
		   					{"K", "L"}, {"F", "G", "I"}, {"E", "B", "D", "H"}};
						
		return buildGraph(graph);
	}
	
	public static <V extends Comparable<V>> UndirectedGraph<V> buildGraph(V[][] data) {
		
		UndirectedGraph<V> uGraph = new UndirectedGraph<>();
		
		uGraph.create(data);
		
		return uGraph;
	}
	
	public static <V extends Comparable<V>> UndirectedGraph<V> buildGraph(List<List<V>> data) {
		
		UndirectedGraph<V> uGraph = new UndirectedGraph<>();
		
		uGraph.create(data);
		
		return uGraph;
	}
	
	public static <V extends Comparable<V>> UndirectedGraph<V> buildGraph(Map<V, Set<V>> data) {
		
		UndirectedGraph<V> uGraph = new UndirectedGraph<>();
		
		uGraph.create(data);
		
		return uGraph;
	}	
	
	public static <V  extends Comparable<V>> UndirectedGraph<V> buildVertexGraph(V[][] data) {
		
		UndirectedGraph<V> uDiGraph = new UndirectedGraph<>();
		BuildUndirectedGraph<V> helper = new BuildUndirectedGraph<V>();
		
		for(V[] v: data) {
			
			for(int i = 1; i < v.length; ++i) {
				
				helper.convertToGraphVertex(v[0], v[i]);
				uDiGraph.addEdge(helper.getGraphVertex(v[0]), helper.getGraphVertex(v[i]));
			}
		}
		
		return uDiGraph;
	}
	
	public static <V  extends Comparable<V>> UndirectedGraph<V> buildVertexGraph(List<List<Vertex<V>>> data) {
		
		UndirectedGraph<V> uDiGraph = new UndirectedGraph<>();
		
		uDiGraph.createWithGraphVertex(data);
		
		return uDiGraph;
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
	
	private static <V extends Comparable<V>> List<List<V>> convertIntoList(V[][] data) {		
		
		List<List<V>> vertices = new ArrayList<>();				
		
		for(int i = 0; i < data.length; ++i) {
								
			vertices.add(Arrays.asList(data[i]));
		}		
		return vertices;
	}
	
	private static <V extends Comparable<V>> Map<V, List<V>> convertIntoMap(V[][] data) {
		
		Map<V, List<V>> vertices = new HashMap<>();
		
		for(int i = 0; i < data.length; ++i) {
			
			List<V> list = vertices.getOrDefault(data[i][0], new ArrayList<V>());
			
			for(int j = 1; j < data[i].length; ++j) {
								
				list.add(data[i][j]);				
			}
			vertices.put(data[i][0], list);
		}		
		return vertices;
	}
}