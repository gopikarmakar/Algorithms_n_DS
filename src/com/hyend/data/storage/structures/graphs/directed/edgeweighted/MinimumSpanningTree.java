package com.hyend.data.storage.structures.graphs.directed.edgeweighted;

import java.util.Set;
import java.util.List;
import java.util.TreeSet;
import java.util.SortedSet;
import java.util.ArrayList;

/**
 * Prim's algorithm for minimum spanning tree (MST)
 * A minimum spanning tree in a graph means that each vertices of the whole graph 
 * or any given subgraph should be visited such that the visited path should be the 
 * shortest path with least edges required.  
 * 
 * NOTE: Assuming it's a DAG, So not checking for cyclicity.
 * 
 * Kindly see the below link for the Graph data and design:
 * https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/ 
 * 
 * Variant: A Salesman Travelling problem. A salesman wants to reach to each n every house  
 * such that the salesman takes the shortest route to cover all houses. 
 *  
 * @author gopi_karmakar
 */
public class MinimumSpanningTree {	
	
	public static void main(String[] args) {
	
		String[][] data = {{"A", "B", "4"}, {"B", "C", "8"}, {"H", "I", "7"}, {"C", "D", "7"},
						   {"E", "F", "10"}, {"C", "F", "4"}, {"B", "H", "11"}, {"A", "H", "8"}, 
						   {"C", "I", "2"}, {"D", "F", "14"}, {"F", "G", "2"}, {"G", "I", "6"},
						   {"G", "H", "1"}, {"B", "I", "2"}, {"D", "E", "9"}};						   
		
		EdgeWeightedDiGraph<String> weightedDiGraph = new EdgeWeightedDiGraph<>();
		
		for(String[] row : data) {
			
			weightedDiGraph.addEdge(row[0], row[1], Integer.valueOf(row[2]));
		}		
		
		weightedDiGraph.printGraph();
		
		VertexWithDistance<String> source = weightedDiGraph.getGraph().iterator().next();
		
		List<Edge<String>> list = new ArrayList<>();
		
		mstTraversal(weightedDiGraph.getGraph(), list, source);
		
		System.out.println("\nMinimum Spanning Tree Edges Are:");
		list.forEach(e -> {
			
			System.out.println(e);			
		});				
	}
	
	/**
	 * The Time complexity is O((E + V)log(V)).
	 * Space complexity is O(E + V)
	 */
	private static void mstTraversal(Set<VertexWithDistance<String>> graph, List<Edge<String>> result, VertexWithDistance<String> s) {
		
		SortedSet<GraphVertex<String>> bst = new TreeSet<>();
		
		// Initializing the source vertex with 0 before begin the traversal. 
		s.vertex.distanceWithFewestEdges = new DistanceWithFewestEdges(0, 0);
		bst.add(s.vertex);				
		
		while(!bst.isEmpty()) {
			
			GraphVertex<String> v = bst.first();				
							
			if(v.parent != null) {
				Edge<String> edge = new Edge<>(v.parent, v);				
				result.add(edge);
			}								
			
			bst.remove(v);
			
			for(VertexWithDistance<String> e: v.edges) {
				
				int eDistance = v.distanceWithFewestEdges.distance + e.distance;
				int eNumEdges = v.distanceWithFewestEdges.minNumEdges + 1;
				
				if(e.vertex.distanceWithFewestEdges.distance > eDistance ||
					(e.vertex.distanceWithFewestEdges.distance == eDistance && 
					e.vertex.distanceWithFewestEdges.minNumEdges > eNumEdges)) {
					
					bst.remove(e.vertex);
					e.vertex.parent = v;
					e.vertex.distanceWithFewestEdges = new DistanceWithFewestEdges(eDistance, eNumEdges);
					bst.add(e.vertex);
				}
			}
		}
	}
	
	private static class Edge<V extends Comparable<V>> {
		
		GraphVertex<V> v;
		GraphVertex<V> e;
		
		public Edge(GraphVertex<V> v, GraphVertex<V> e) {
		
			this.e = e;
			this.v = v;
		}
		
		@Override
		public String toString() {			
			return v.v + " -> " + e.v;
		}
	}
}
