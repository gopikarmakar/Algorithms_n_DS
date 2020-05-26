package com.hyend.data.storage.structures.graphs.directed.edgeweighted;

import java.util.List;

import com.hyend.data.storage.structures.graphs.directed.edgeweighted.MinimumSpanningTree.Edge;

/**
 * Prim's algorithm for minimum spanning tree (MST)
 * A minimum spanning tree in a graph means that each vertices of the whole graph 
 * or any given subgraph should be visited such that the visited path should be the 
 * shortest path with least edges required.
 * 
 * Kindly see the below link for the Graph data and design:
 * https://www.youtube.com/watch?v=oP2-8ysT3QQ 
 * 
 * Variant: A Salesman Traveling problem. A salesman wants to 
 * reach to each n every house such that the salesman takes the 
 * shortest route to cover all houses.
 * 
 * Time complexity O((|E| + |V|)log|V|).
 * Space Complexity O(E + V)
 * 
 * @author gopi_karmakar
 */
public class PrimsMST<V extends Comparable<V>> {

	public static void main(String[] args) {
		
		String[][] data = {{"A", "B", "3"}, {"A", "D", "1"}, {"B", "C", "1"}, 
				   		   {"C", "F", "4"}, {"C", "E", "5"}, {"D", "C", "1"},
				   		   {"D", "B", "3"}, {"D", "E", "6"}, {"E", "F", "2"}};
		
		/*Integer[][] data2 = {{1, 2, 3}, {2, 3, 1}, {3, 1, 1}, 
							 {1, 4, 1}, {2, 4, 3}, {4, 5, 6}, 
							 {5, 6, 2}, {3, 5, 5}, {3, 6, 4}};*/
		
		PrimsMST<String> mst = new PrimsMST<>();
		
		EdgeWeightedGraph<String> uGraph = mst.createGraph(data);
		
		mst.computeMST(uGraph);
	}
	
	private EdgeWeightedGraph<V> createGraph(V[][] data) {
		
		EdgeWeightedGraph<V> uGraph = new EdgeWeightedGraph<>();
		
		for(V[] v: data) {
			
			uGraph.addUnDirectedEdge(v[0], v[1], 
					((v[2] instanceof String) ? 
						Integer.parseInt(v[2].toString()) : (Integer)v[2]));
		}		
		uGraph.printGraph();
		
		return uGraph;
	}
	
	private void computeMST(EdgeWeightedGraph<V> uGraph) {			
		
		VertexWithDistance<V> source = uGraph.getGraph().iterator().next();
		
		List<Edge<V>> result = MinimumSpanningTree.mstTraversal(uGraph.getGraph(), source);				
		
		System.out.println("\nMinimum Spanning Tree Edges Are:");
		result.forEach(e -> {
			
			System.out.println(e);			
		});		
	}
}