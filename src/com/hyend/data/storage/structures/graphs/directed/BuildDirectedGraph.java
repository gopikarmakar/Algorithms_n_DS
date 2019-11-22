package com.hyend.data.storage.structures.graphs.directed;

import java.util.List;

import com.hyend.data.storage.structures.graphs.Vertex;

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
		
		return BuildDirectedGraph.buildGraph(data);			
	}
	
	public static <V> DirectedGraph<V> buildGraph(V[][] data) {
		
		DirectedGraph<V> diGraph = new DirectedGraph<>();
	
		diGraph.create(data);
		
		return diGraph;
	}
	
	public static <V> DirectedGraph<V> buildGraph(List<List<V>> data) {
		
		DirectedGraph<V> diGraph = new DirectedGraph<>();
		
		diGraph.create(data);
		
		return diGraph;
	}
	
	public static <V> DirectedGraph<V> buildWithGraphVertex(Vertex<V>[][] data) {
		
		DirectedGraph<V> diGraph = new DirectedGraph<>();
		
		diGraph.create(data);
		
		return diGraph;
	}
	
	public static <V> DirectedGraph<V> buildWithGraphVertex(List<List<Vertex<V>>> data) {
		
		DirectedGraph<V> diGraph = new DirectedGraph<>();
		
		diGraph.createWithGraphVertex(data);
		
		return diGraph;
	}
	
	//////////////////////////////Helper Methods //////////////////////////////////////
	
	public static <V> List<List<Vertex<V>>> convertInToList(Vertex<V>[][] data) {
		
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
