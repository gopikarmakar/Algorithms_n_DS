package com.hyend.data.storage.structures.graphs.undirected;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * An Undirected Graph Builder Wrapper
 *  
 * @author gopi_karmakar
 */
public class BuildUndirectedGraph<V> {

	public static void main(String[] args) {	
		
		UndirectedGraph<Integer> undiGraph = buildDefaultGraph();		
		undiGraph.traverseGraph(undiGraph.getGraph());
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
		
		return new BuildUndirectedGraph<Integer>().buildGraph(graph);
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
						
		return new BuildUndirectedGraph<String>().buildGraph(graph);
	}
	
	public UndirectedGraph<V> buildGraph(V[][] data) {
		
		UndirectedGraph<V> uGraph = new UndirectedGraph<>();
		
		uGraph.create(new BuildUndirectedGraph<V>().convertIntoList(data));
		
		return uGraph;
	}
	
	public UndirectedGraph<V> buildGraph(List<List<V>> data) {
		
		UndirectedGraph<V> uGraph = new UndirectedGraph<>();
		
		uGraph.create(data);
		
		return uGraph;
	}
	
	
	////////////////////////////// Helper Methods //////////////////////////////////////
	
	private List<List<V>> convertIntoList(V[][] data) {		
		
		List<List<V>> vertices = new ArrayList<>();				
		
		for(int i = 0; i < data.length; ++i) {
								
			vertices.add(Arrays.asList(data[i]));
		}		
		return vertices;
	}
	
	private Map<V, List<V>> convertIntoMap(V[][] data) {
		
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