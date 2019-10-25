package com.hyend.data.storage.structures.graphs.undirected;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An Integer or String graph creation
 *  
 * @author gopi_karmakar
 */
public class BuildUndirectedGraph<V> {

	public static void main(String[] args) {	
		
		UndirectedGraph<Integer> undiGraph = buildDefaultGraph();
		
		undiGraph.traverseGraph(undiGraph.getGraph());
	}
	
	/**
	 * Time complexity is O(n X m) where n = number of vertices and
	 * m = maximum degree of any vertex. 
	 */
	public static UndirectedGraph<Integer> buildDefaultGraph() {
		
		int[][] graph = {{0, 5}, {4, 3}, {0, 1}, {9, 12}, {6, 4},
						 {5, 4}, {0, 2}, {11, 12}, {9, 10}, {0, 6},
						 {7, 8}, {9, 11}, {5, 3}};
		
		return buildIntGraph(graph);
	}
	
	/**
	 * Default Integer graph creation
	 */
	public static UndirectedGraph<Integer> buildIntGraph(int[][] graph) {
		
		UndirectedGraph<Integer> undiGraph = new UndirectedGraph<>();
		undiGraph.create(createSampleData(graph));
		//undiGraph.create(createMappedSampleData(graph));
		return undiGraph;
	}
	
	private static List<Node<Integer>> createSampleData(int[][] graph) {		
		
		List<Node<Integer>> vertices = new ArrayList<>();				
		
		for(int i = 0; i < graph.length; ++i) {
			
			Node<Integer> node = new Node<>(graph[i][0], new ArrayList<>());
			
			for(int j = 1; j < graph[i].length; ++j) {
								
				node.e.add(graph[i][j]);
			}			
			vertices.add(node);
		}		
		return vertices;
	}
	
	private static Map<Integer, List<Integer>> createMappedSampleData(int[][] graph) {
		
		Map<Integer, List<Integer>> vertices = new HashMap<>();
		
		for(int i = 0; i < graph.length; ++i) {
			
			List<Integer> list = vertices.getOrDefault(graph[i][0], new ArrayList<>());
			
			for(int j = 1; j < graph[i].length; ++j) {
								
				list.add(graph[i][j]);				
			}
			vertices.put(graph[i][0], list);
		}		
		return vertices;
	}
	
	private static List<Node<String>> createSampleStringData() {		
		
		List<Node<String>> nodes = new ArrayList<>();
		nodes.add(new Node<String>("A", new ArrayList<String>(Arrays.asList(new String[] {"B"}))));
		nodes.add(new Node<String>("C", new ArrayList<String>(Arrays.asList(new String[] {"D"}))));
		nodes.add(new Node<String>("J", new ArrayList<String>(Arrays.asList(new String[] {"I"}))));
		nodes.add(new Node<String>("I", new ArrayList<String>(Arrays.asList(new String[] {"M"}))));
		nodes.add(new Node<String>("M", new ArrayList<String>(Arrays.asList(new String[] {"K"}))));
		nodes.add(new Node<String>("K", new ArrayList<String>(Arrays.asList(new String[] {"L"}))));
		nodes.add(new Node<String>("F", new ArrayList<String>(Arrays.asList(new String[] {"G", "I"}))));
		nodes.add(new Node<String>("E", new ArrayList<String>(Arrays.asList(new String[] {"B", "D", "H"}))));						
		
		return nodes;
	}
}