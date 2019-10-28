package com.hyend.data.storage.structures.graphs.directed;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class BuildDirectedGraph<V> {

	public static void main(String[] args) {
		
		DirectedGraph<Integer> diGraph = buildDefaultGraph();
		diGraph.traverseGraph(diGraph.getGraph());
	}
	
	private static DirectedGraph<Integer> buildDefaultGraph() {
		
		Integer[][] data = {{0, 1, 5}, {2, 0, 3}, {3, 5, 2}, {4, 3, 2}, {5, 4},
							 {6, 0, 4, 9}, {7, 6, 8}, {8, 7, 9}, {9, 10, 11}, 
							 {10, 12}, {11, 4, 12}, {12, 9}};		
		
		return new BuildDirectedGraph<Integer>().buildGraph(data);			
	}
	
	public DirectedGraph<V> buildGraph(V[][] data) {
		
		DirectedGraph<V> diGraph = new DirectedGraph<>();
		
		diGraph.create(new BuildDirectedGraph<V>().convertInToList(data));
		
		return diGraph;
	}
	
	public DirectedGraph<V> buildGraph(List<List<V>> data) {
		
		DirectedGraph<V> diGraph = new DirectedGraph<>();
		
		diGraph.create(data);
		
		return diGraph;
	}
	
	//////////////////////////////Helper Methods //////////////////////////////////////
	
	private List<List<V>> convertInToList(V[][] data) {
		
		List<List<V>> list = new ArrayList<>();
		
		for(int i = 0; i < data.length; ++i) {
			
			list.add(Arrays.asList(data[i]));
		}
		return list;
	}
}
