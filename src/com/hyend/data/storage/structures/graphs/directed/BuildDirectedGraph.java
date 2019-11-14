package com.hyend.data.storage.structures.graphs.directed;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * A Directed Graph Builder Wrapper
 * 
 * https://algs4.cs.princeton.edu/42digraph/
 * 
 * NOTE : Refer to the above link for the source.
 * 
 * @author gopi_karmakar
 */
public class BuildDirectedGraph<V> {

	public static void main(String[] args) {
		
		DirectedGraph<Integer> diGraph = buildDefaultGraph();
		diGraph.printGraph();
		diGraph.reverse().printGraph();
	}
	
	/**
	 * Default Integer graph creation for testing
	 * 
	 * Time complexity is O(v + e) where v = number of vertices and
	 * e = maximum degree of any vertex called edges. 
	 */	
	public static DirectedGraph<Integer> buildDefaultGraph() {
		
		Integer[][] data = {{0, 1, 5}, {2, 0, 3}, {3, 5, 2}, {4, 3, 2}, {5, 4},
							{6, 0, 4, 9}, {7, 6, 8}, {8, 7, 9}, {9, 10, 11}, 
							{10, 12}, {11, 4, 12}, {12, 9}};		
		
		return new BuildDirectedGraph<Integer>().buildGraph(data);			
	}
	
	public DirectedGraph<V> buildGraph(V[][] data) {
		
		DirectedGraph<V> diGraph = new DirectedGraph<>();
	
		diGraph.create(data);
		
		return diGraph;
	}
	
	public DirectedGraph<GraphVertex<V>> buildWithGraphVertex(GraphVertex<V>[][] data) {
		
		DirectedGraph<GraphVertex<V>> diGraph = new DirectedGraph<>();
		
		diGraph.create(data);
		
		return diGraph;
	}
	
	public DirectedGraph<V> buildGraph(List<List<V>> data) {
		
		DirectedGraph<V> diGraph = new DirectedGraph<>();
		
		diGraph.create(data);
		
		return diGraph;
	}
	
	public DirectedGraph<GraphVertex<V>> buildWithGraphVertex(List<List<GraphVertex<V>>> data) {
		
		DirectedGraph<GraphVertex<V>> diGraph = new DirectedGraph<>();
		
		diGraph.create(data);
		
		return diGraph;
	}
	
	//////////////////////////////Helper Methods //////////////////////////////////////
	
	private List<List<GraphVertex<V>>> convertInToGraphVertexList(GraphVertex<V>[][] data) {
		
		List<List<GraphVertex<V>>> list = new ArrayList<>();
		
		for(GraphVertex<V>[] v : data) {
			
			List<GraphVertex<V>> l = new ArrayList<>();
			
			for(GraphVertex<V> e : v) {
				
				l.add(e);
			}
			list.add(l);
		}		
		return list;
	}
}
